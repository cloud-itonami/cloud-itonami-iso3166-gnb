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

## Correction history: "ARMP" rejected, "ARCP" now confirmed

This repo's original scaffold said Guinea-Bissau's public-procurement
regulator was **"ARMP"**. That claim could **not be independently verified**
for Guinea-Bissau specifically: "ARMP" is a real procurement-regulator
acronym used by several OTHER African jurisdictions (Senegal, Côte d'Ivoire,
DR Congo, Guinea, Cameroon, Benin, Cape Verde), but no primary Guinea-Bissau
government source confirming that same acronym for Guinea-Bissau's own
procurement body was found -- this repo does not state the "ARMP" claim
anywhere.

A 2026-07-22 research pass also surfaced scattered SECONDARY mentions of an
acronym **"ARCP"** (a World Bank Public Expenditure Review's "Central Public
Procurement Unit" description, and an Angola government report listing
"ARCP da Guiné-Bissau" as a PALOP workshop participant) but explicitly
declined to state it as fact, since neither source was a primary
Guinea-Bissau government domain or the procurement law's own text.

**2026-07-23 resolution**: that primary source has now been found and
independently fetched+read directly: Guinea-Bissau's own Boletim Oficial,
Número 34 (20 de Agosto de 2012), hosted at `dgcp.mef.gw` (a Guinea-Bissau
government domain), carries Decreto-Lei n.° 2/2012 ("Código dos Contratos
Públicos"). Its own Artigo 106.° ("Entidade responsável pela regulação")
reads, verbatim: "É instituída a entidade responsável pela regulação dos
concursos públicos e de delegação de serviços públicos denominada
Autoridade de Regulação dos Concursos Públicos (ARCP)..." — "ARCP" is
therefore now a confirmed fact, cited in `src/marketentry/facts.cljc` and
`organization.edn`.

What this actor's catalog now cites:

- **Procurement legal basis**: Código dos Contratos Públicos (Decreto-Lei
  n.° 2/2012), Artigo 106.° (creates the ARCP) and Artigo 101.°(b)
  (disciplinary exclusion for 1-5 years, per the gravity of the infraction)
  -- own primary text at `https://dgcp.mef.gw/quadro-legal/boletins-
  oficiais/7-bo-34-20-08-2012-dl-2-2012-ccp/file`; also still grounded in
  the annual-procurement-plan requirement indexed at the World Bank's
  PPIAF/PPP Knowledge Lab library: `https://www.ppiaf.org/documents/2808`.
- **Procurement planning requirement**: contracting authorities must develop
  an annual public-procurement plan, based on their own activity program,
  incorporated into the State budget -- only contracts included in this
  annual plan may be executed.
- **Procurement administering authority**: Autoridade de Regulação dos
  Concursos Públicos (ARCP), per the primary source above.
- **Commercial/company registration**: business creation and registration
  procedures run through the **Centro de Formalização de Empresas (CFE)**,
  which centralizes registration with the commercial registry AND the
  general tax authority. The commercial registry itself is the
  **Conservatória do Registo Comercial**, operating within the Ministry of
  Justice's framework.
- **Legal/corporate framework**: Guinea-Bissau's commercial law draws on the
  **OHADA Uniform Act on General Commercial Law** (AUDCG, for RCCM
  registration) and the **OHADA Acte uniforme relatif au droit des sociétés
  commerciales et du groupement d'intérêt économique** (AUSCGIE, for company
  formation/governance) -- Guinea-Bissau is an OHADA member state, distinct
  from "Guinée"/"Guinée Equatoriale" (confirmed directly on OHADA's own
  member-states page). See `src/statute/facts.cljc` for the general-law
  compliance catalog (AUSCGIE, Lei Geral do Trabalho Lei n.º 2/86, Código do
  Investimento Lei n.° 13/2011).
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
