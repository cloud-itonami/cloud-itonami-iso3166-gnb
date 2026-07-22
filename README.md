# cloud-itonami-iso3166-gnb

**`:implemented`** for **GNB** (Guinea-Bissau): an "Actors" pattern
market-entry / public-procurement compliance service (Governor + LLM advisor
+ langgraph-clj StateGraph + append-only audit ledger + Store), adapted from
the `cloud-itonami-iso3166-ago` reference implementation and the same-OHADA-
framework siblings `cloud-itonami-iso3166-dji` (Djibouti) and
`cloud-itonami-iso3166-mli` (Mali).

Flagship check: `commercial-registration-missing` (Conservatória do Registo
Comercial commercial registration via the Centro de Formalização de Empresas,
OHADA Uniform Act on General Commercial Law). **Six** governor checks, not
the AGO reference's seven -- see `src/marketentry/governor.cljc` for why.

```
clojure -M:dev:test
```

## Correction: this repo previously claimed "ARMP"

This repo's original scaffold said Guinea-Bissau's public-procurement
regulator was **"ARMP"**. That claim could **not be independently verified**
for Guinea-Bissau specifically: "ARMP" is a real procurement-regulator
acronym used by several OTHER African jurisdictions (Senegal, Côte d'Ivoire,
DR Congo, Guinea, Cameroon, Benin, Cape Verde), but no primary Guinea-Bissau
government source confirming that same acronym for Guinea-Bissau's own
procurement body was found. An additional targeted search pass (2026-07-22)
also surfaced a World Bank Guinea-Bissau Public Expenditure Review reference
to a "Central Public Procurement Unit" and scattered secondary mentions of an
acronym "ARCP" in workshop/social-media contexts -- neither rises to the bar
of an independently-verified PRIMARY source, so neither is stated as fact.
This repo no longer states the "ARMP" claim anywhere (`src/marketentry/
facts.cljc`, `organization.edn`, `docs/`). What IS verified, and is what this
actor's catalog now cites:

- **Procurement legal basis**: Lei-Quadro Relativo Aos Contratos Públicos
  (Framework Law on Public Contracts), indexed at the World Bank's PPIAF/PPP
  Knowledge Lab library: `https://www.ppiaf.org/documents/2808` (mirrored at
  `https://library.pppknowledgelab.org/documents/2808`).
- **Procurement planning requirement**: contracting authorities must develop
  an annual public-procurement plan, based on their own activity program,
  incorporated into the State budget -- only contracts included in this
  annual plan may be executed.
- **Procurement administering authority**: an English-language description
  was found (a national public procurement agency, formerly the "Central
  Unit of Public Purchases") but no independently-verified current
  Portuguese official name -- state it only in English terms, do not invent
  a Portuguese name.
- **Commercial/company registration**: business creation and registration
  procedures run through the **Centro de Formalização de Empresas (CFE)**,
  which centralizes registration with the commercial registry AND the
  general tax authority. The commercial registry itself is the
  **Conservatória do Registo Comercial**, operating within the Ministry of
  Justice's framework.
- **Legal/corporate framework**: Guinea-Bissau's commercial law draws on the
  **OHADA Uniform Act on General Commercial Law** -- Guinea-Bissau is an
  OHADA member state (acceded).
- **National e-procurement**: no verified transactional portal found for
  Guinea-Bissau (unlike Angola's SNCP e-procurement system) -- not invented.
- **Tax-ID scheme**: no specific named tax-ID scheme (a NIF-equivalent) was
  independently confirmed -- the tax-registration requirement is grounded
  only in "the general tax authority" registration obtained via the CFE
  single window, without a named acronym. This is why the governor has SIX
  checks, not AGO's/MLI's seven (no distinct tax-ID check).

AGPL-3.0-or-later.

## Culture catalog

Alongside the market-entry / statute catalogs, this repo carries a
**country-level regional-culture catalog** (ADR-2607171400 addendum 2,
`cloud-itonami-municipality-culture-catalog` Wave 1, in
`com-junkawasaki/root`) — national dishes, protected products, beverages,
crafts, festivals and heritage sites for Guinea-Bissau:

- `src/culture/facts.cljc` — the catalog, source of truth (keyed by
  uppercase ISO3, mirroring `statute.facts`).
- `schema/culture.edn` — DataScript schema.
- `data/culture-tx.edn` — derived DataScript tx-data (regenerated from
  the catalog, never hand-edited).

City-level counterparts live in the `cloud-itonami-municipality-*` repos.
Same provenance discipline as the compliance catalogs: every entry cites a
source URL that was actually fetched and read on `:culture/retrieved-at`;
summaries state only what the cited source confirms. An item not in
`culture.facts/catalog` has no spec-basis — never fabricate one.
