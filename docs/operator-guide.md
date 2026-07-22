# Operator guide — GNB (Guinea-Bissau)

## Regulatory grounding

- **Legal basis**: Lei-Quadro Relativo Aos Contratos Públicos
  (Framework Law on Public Contracts).
  `https://www.ppiaf.org/documents/2808`
  (mirrored: `https://library.pppknowledgelab.org/documents/2808`).
- **Procurement regulator**: the national public-sector procurement
  regulatory body (formerly known as the "Central Unit of Public
  Purchases"). Its current Portuguese official name was NOT
  independently confirmed in this research pass — do not repeat
  "ARMP" (this repo's original scaffold had claimed that, in error;
  see `docs/business-model.md` and `src/marketentry/facts.cljc` for
  the correction). Describe the body only in the English terms above
  until a verified primary source is found.
- **Procurement planning**: contracting authorities must develop an
  annual public-procurement plan from their own activity program,
  incorporated into the State budget. Only contracts included in this
  plan may be executed — an engagement outside the annual plan cannot
  legitimately proceed.
- **No verified e-procurement portal**: unlike Angola's SNCP
  transactional portal, no Guinea-Bissau national e-procurement portal
  was found. Filings are Lei-Quadro-governed, not portal-submitted, as
  far as this catalog's dossier can confirm.

## Commercial/business registration

- **Centro de Formalização de Empresas (CFE)** — the Business
  Formalization Center, the single window for business creation and
  registration.
- **Conservatória do Registo Comercial** — the commercial registry
  itself, operating within the Ministry of Justice's framework. The
  CFE centralizes filing with this registry AND with the general tax
  authority in one submission.
- **OHADA** — Guinea-Bissau is an OHADA member state (acceded); its
  commercial law draws on the OHADA Uniform Act on General Commercial
  Law.
- No specific named tax-ID scheme (a NIF-equivalent) was independently
  confirmed — this actor tracks only "general tax authority
  registration (via CFE)" as required evidence, without a named
  acronym.

## Using the actor

1. `:engagement/intake` — record/patch an engagement (operator name,
   fee terms, jurisdiction). Auto-commits when clean at phase 3.
2. `:jurisdiction/assess` — the actor proposes the GNB required-
   evidence checklist above, citing the Lei-Quadro/PPIAF source.
   ALWAYS requires human approval, even when clean.
3. `:filing/draft` — the actor proposes drafting a filing package.
   ALWAYS requires human approval; HELD if evidence is incomplete or
   the engagement was already drafted.
4. `:filing/submit` — the actor proposes submitting the filing.
   ALWAYS requires human approval; HARD-HELD (unoverridable) if:
   - the engagement requires Conservatória/CFE commercial registration
     but doesn't have it on file (`:requires-gnb-registration? true`
     + `:has-gnb-registration? false`);
   - the claimed engagement fee doesn't equal
     `base-fee + monthly-rate × monitoring-months`;
   - the engagement was already submitted.

## Demo engagements

`src/marketentry/store.cljc`'s `demo-data` seeds five engagements:

| id     | scenario                                            |
|--------|------------------------------------------------------|
| eng-1  | clean — commits end-to-end                            |
| eng-2  | requires registration but lacks it — HARD hold         |
| eng-3  | claimed fee doesn't match recomputed fee — HARD hold   |
| eng-4  | clean, a second differently-shaped fee — commits       |
| eng-5  | doesn't itself require GNB registration — commits      |
