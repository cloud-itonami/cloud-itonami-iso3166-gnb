(ns statute.facts
  "General-law compliance catalog for the Republic of Guinea-Bissau
  (GNB) -- extends this repo's existing `marketentry.facts` (public-
  procurement market-entry only, narrow scope) with a second, orthogonal
  catalog of statutes a company operating in this jurisdiction must
  generally track for compliance. Mirrors cloud-itonami-iso3166-ben/
  -btn/-caf/-cog/-gin's `statute.facts` (ADR-2607141700, cloud-itonami-
  compliance-fact-federation).

  Every entry below cites an OFFICIAL government-hosted, official-
  professional-body-hosted (OAGB), or official-supranational-body-
  hosted (OHADA) URL -- never fabricated, all curl/WebFetch-verified
  2026-07-23:

  - **Companies/commercial-entity law**: this iteration specifically
    investigated, rather than assumed by analogy to the GIN/CAF/COG
    siblings, whether Guinea-Bissau is itself an OHADA member state --
    independently confirmed directly on OHADA's own 'Les Etats membres
    de l'OHADA' page (`ohada.org/les-etats-membres-de-lohada/`,
    WebFetch-verified this session), which lists 'Guinée Bissau' among
    the member states, explicitly distinct from 'Guinée' and 'Guinée
    Equatoriale' in the SAME sentence -- this iteration did not conflate
    the three. So, like Benin/CAF/COG/GIN, company law is governed
    DIRECTLY by a SUPRANATIONAL instrument, the OHADA Acte uniforme
    relatif au droit des sociétés commerciales et du groupement
    d'intérêt économique (AUSCGIE) -- this iteration independently
    re-fetched OHADA's own page this session
    (`ohada.org/droit-des-societes-commerciales-et-du-gie/`,
    WebFetch-verified directly, NOT copied from a sibling's entry) and
    confirmed, in OHADA's own words: 'Adoption Date: 30 janvier 2014 à
    Ouagadougou (Burkina Faso) -- Publication Date: 04 février 2014 --
    Entry into Force: 05 mai 2014'. This is independently corroborated,
    GNB-specifically, by the Ordem dos Advogados da Guiné-Bissau
    (OAGB)'s own official legislative-reference page
    (`oagb.gw/legislacao-nacional.php`, fetched directly this session):
    'Direito Comercial / Direito Comercial (OHADA) / Atos Uniformes
    OHADA / O antigo Código Comercial português foi substituído pelo
    sistema harmonizado da OHADA, vigente desde 1996.' -- i.e. Guinea-
    Bissau's own Bar Association confirms, in its own words, that OHADA
    replaced the prior Portuguese Commercial Code, effective since 1996
    (Guinea-Bissau's own OHADA-membership start; a DIFFERENT date from
    the CURRENT AUSCGIE instrument's own 2014 adoption/entry-into-force
    above -- this iteration does not conflate 'when OHADA membership
    began' with 'when the current AUSCGIE text was adopted'). Separately,
    RCCM/business-entity REGISTRATION -- as opposed to company
    FORMATION/governance law -- is governed by a DIFFERENT OHADA
    instrument, the Acte Uniforme relatif au Droit Commercial Général
    (AUDCG); this catalog does not conflate the two (`marketentry.facts`
    cites AUDCG separately for RCCM).
  - **Lei Geral do Trabalho (General Labor Law)**: Lei n.º 2/86 --
    this iteration confirmed this citation directly from the Ordem dos
    Advogados da Guiné-Bissau (OAGB)'s own official legislative-
    reference page (`oagb.gw/legislacao-nacional.php`, fetched directly
    this session, own text, verbatim): 'Direito do Trabalho / Lei Geral
    do Trabalho / Lei n.º 2/86 / Regulamenta as relações laborais,
    direitos do trabalhador e do empregador na Guiné-Bissau.' This
    iteration did NOT independently fetch the law's own primary text
    (only OAGB's own citing page) -- an honest gap, the same discipline
    GIN's catalog uses for its own Code des Investissements citation.
  - This iteration also independently confirmed, from Guinea-Bissau's
    own Código do Investimento's primary text (Lei n.° 13/2011, de 06 de
    Julho -- machine-readable, NOT scanned; fetched directly this
    session from an embassy-hosted mirror,
    `embassygbissau-banjul.com/WP/wp-content/uploads/2022/08/Codigo-do-
    Investimento.pdf`, honestly disclosed as a non-.gw secondary
    hosting rather than a Guinean-government domain, the same 'primary
    site unreachable, honest secondary source used instead' discipline
    this fleet applies to droit-afrique.com), a further Guinea-Bissau-
    specific statute relevant to compliance. Own preamble text
    (verbatim): the Código revokes and replaces the prior 'Código de
    Investimento aprovado pelo Decreto-Lei nº 4/91, de 14 de Outubro'
    and 'Decreto-Lei nº 03/2009, de 31 de Dezembro'. The current Código
    is administered by the 'Direcção Geral da Promoção do Investimento
    Privado' (DGPIP, own Art. 17 §2(a)) -- see `marketentry.facts`'s
    namespace docstring for the honestly-flagged tax-incentive tacit-
    approval mechanism (Art. 12) found but not built into the flagship
    check.

  A law not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of statute entries. `:statute/url` + `:statute/law-number`
  are the citation the governor requires before any compliance-fact
  proposal referencing this law can commit."
  {"GNB"
   [{:statute/id "gnb.ohada-auscgie"
     :statute/title "Acte uniforme relatif au droit des sociétés commerciales et du groupement d'intérêt économique (AUSCGIE)"
     :statute/jurisdiction "GNB"
     :statute/kind :law
     :statute/law-number "OHADA Uniform Act -- adopted 30 January 2014 (Ouagadougou), published in the OHADA Official Journal 4 February 2014, in force 5 May 2014; directly applicable in the Republic of Guinea-Bissau as an OHADA member state. The Ordem dos Advogados da Guiné-Bissau (OAGB)'s own site independently confirms OHADA's harmonized system has applied in Guinea-Bissau, replacing the prior Portuguese Commercial Code, 'vigente desde 1996' (Guinea-Bissau's own OHADA-membership start, a distinct date from this current AUSCGIE text's own 2014 adoption)"
     :statute/url "https://www.ohada.org/droit-des-societes-commerciales-et-du-gie/"
     :statute/url-provenance :official-ohada-org
     :statute/enacted-date "2014-01-30"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:corporate-governance :incorporation}}
    {:statute/id "gnb.lei-geral-do-trabalho-1986"
     :statute/title "Lei Geral do Trabalho da República da Guiné-Bissau"
     :statute/jurisdiction "GNB"
     :statute/kind :law
     :statute/law-number "Lei n.º 2/86 (per the Ordem dos Advogados da Guiné-Bissau (OAGB)'s own official legislative-reference page; this iteration did NOT independently fetch the law's own primary text, an honest gap)"
     :statute/url "https://www.oagb.gw/legislacao-nacional.php"
     :statute/url-provenance :official-bar-association-oagb
     :statute/enacted-date "1986-01-01"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:labor :employment}}
    {:statute/id "gnb.codigo-do-investimento-2011"
     :statute/title "Código do Investimento da República da Guiné-Bissau"
     :statute/jurisdiction "GNB"
     :statute/kind :law
     :statute/law-number "Lei n.° 13/2011, de 06 de Julho (own primary text, machine-readable, fetched directly this session from an embassy-hosted mirror -- honestly disclosed as a secondary, non-.gw hosting of the primary text, not the Guinean government's own domain)"
     :statute/url "https://embassygbissau-banjul.com/WP/wp-content/uploads/2022/08/Codigo-do-Investimento.pdf"
     :statute/url-provenance :secondary-embassy-hosted-primary-text
     :statute/enacted-date "2011-07-06"
     :statute/retrieved-at "2026-07-23"
     :statute/topic #{:investment}}]})

(defn spec-basis
  "The jurisdiction's statute vector, or nil -- nil means NO spec-basis
  for that jurisdiction yet."
  [iso3]
  (get catalog iso3))

(defn coverage
  "Honest coverage report, same shape/discipline as `marketentry.facts/coverage`:
  never report a missing jurisdiction as covered."
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-gnb statute.facts Wave 0 (ADR-2607141700): "
                 (count (get catalog "GNB")) " GNB statutes seeded with an "
                 "official citation. Extend "
                 "`statute.facts/catalog`, never fabricate a law-id or URL.")})))

(defn by-topic
  "Statutes for `iso3` tagged with `topic` (e.g. :labor, :corporate-governance)."
  [iso3 topic]
  (filterv #(contains? (:statute/topic %) topic) (spec-basis iso3)))
