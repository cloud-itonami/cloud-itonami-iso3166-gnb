# Business model — GNB (Guinea-Bissau)

Independent public-sector market-entry and procurement-compliance
service for Guinea-Bissau, run by a supervised MarketEntry-LLM
advisor sealed behind an independent **Market-Entry Compliance
Governor** — the same actor family as `cloud-itonami-iso3166-ago`
(Angola) and its francophone-Africa/OHADA siblings
`cloud-itonami-iso3166-dji` (Djibouti) and `cloud-itonami-iso3166-mli`
(Mali).

## Grounding — a deliberately thinner dossier

This catalog is thinner and more conservative than sibling
jurisdictions in this actor family. That is intentional, not a
defect — it mirrors the same honest-disclosure precedent already set
by `cloud-itonami-iso3166-stp` (São Tomé and Príncipe) and
`cloud-itonami-iso3166-sdn` (Sudan): a smaller, verified fact set is
preferable to padding a catalog with plausible-sounding invented
detail. Specifically, the research dossier behind this catalog (2026-
07-22 research pass, cross-checked against the World Bank/PPIAF PPP
Knowledge Lab document library and secondary business-registration
sources):

- Confirmed the procurement **legal basis**: the Lei-Quadro Relativo
  Aos Contratos Públicos (Framework Law on Public Contracts), indexed
  at `https://www.ppiaf.org/documents/2808` (mirrored at
  `https://library.pppknowledgelab.org/documents/2808`).
- Confirmed a **procurement planning requirement**: contracting
  authorities must develop an annual public-procurement plan, based
  on their own activity program, incorporated into the State budget —
  only contracts included in this annual plan may be executed.
- Confirmed **business/commercial registration** runs through the
  Centro de Formalização de Empresas (CFE — Business Formalization
  Center), which centralizes registration with the commercial
  registry (the Conservatória do Registo Comercial, operating within
  the Ministry of Justice's framework) AND the general tax authority
  in one filing.
- Confirmed Guinea-Bissau's commercial law draws on the OHADA Uniform
  Act on General Commercial Law — Guinea-Bissau is an OHADA member
  state (acceded).
- Did **NOT** find an independently-verifiable Portuguese official
  name for the national procurement regulatory body (the dossier
  found only an English-language description: a national public
  procurement agency, formerly called the "Central Unit of Public
  Purchases"). An additional targeted search pass surfaced only
  secondary, non-primary mentions of possible acronyms — none rose to
  the bar of a verified primary source, so none is stated as fact.
  This corrects this repo's own original scaffold, which had claimed
  "ARMP" for Guinea-Bissau — that specific acronym belongs to
  procurement regulators in OTHER countries (Senegal, Côte d'Ivoire,
  DR Congo, Guinea, Cameroon, Benin, Cape Verde), and no primary
  Guinea-Bissau government source confirming it for Guinea-Bissau
  itself was found.
- Did **NOT** find a national e-procurement portal — none is claimed.
- Did **NOT** find a specific named tax-ID scheme (a NIF-equivalent)
  distinct from ordinary CFE/Conservatória registration — the
  tax-registration requirement is grounded only in "the general tax
  authority" registration obtained via the CFE single window, without
  a named acronym.

See `src/marketentry/facts.cljc` for the full catalog entry and its
docstring, which is the single source of truth for every regulatory
claim this actor makes.

## Service

A market-entry operator engages this actor to:

1. **Intake** an engagement (company/operator details).
2. **Assess** the jurisdiction — the actor cites the exact spec-basis
   above and returns the required-evidence checklist. A jurisdiction
   with no catalog entry gets NO fabricated checklist (HARD hold).
3. **Draft** a filing package once evidence is complete (always
   human-approved).
4. **Submit** the filing once the Conservatória/CFE commercial
   registration and the independently-recomputed engagement fee both
   check out (always human-approved, always HARD-held if either is
   wrong).

## Engagement fee

Base fee + monthly monitoring rate × monitoring months. The Governor
independently recomputes this on every `:filing/submit` and HARD-holds
on any mismatch with the claimed fee — never trusts the LLM's own
arithmetic.

## Trust Controls

- Any actual portal registration or filing submission requires
  Market-Entry Compliance Governor clearance and always escalates to
  human sign-off — no phase, however mature, allows
  `:filing/draft`/`:filing/submit` to auto-commit.
- A false or fabricated regulatory-requirement claim is a HARD hold —
  the Governor's `spec-basis` check rejects any proposal that doesn't
  cite `marketentry.facts`.
- A missing Conservatória do Registo Comercial / CFE commercial
  registration on an engagement that declares it requires one is a
  HARD hold, unoverridable by a human approver.
- A mismatched engagement fee is a HARD hold, unoverridable by a
  human approver.
- Double-drafting or double-submitting the same engagement is a HARD
  hold.

## Precedent

This is the sixth actor in the `cloud-itonami-iso3166-*` family to
land with an implemented governor (after `ago`, `dji`, `mli`, `stp`,
`sdn`), and follows `stp`/`sdn` in correctly shipping SIX governor
checks instead of seven, because the dossier does not ground a
distinct tax-ID check.
