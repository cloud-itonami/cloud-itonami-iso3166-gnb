(ns marketentry.facts
  "Guinea-Bissau (GNB) market-entry catalog.

  Every fact under \"GNB\" below is grounded ONLY in a verified research
  dossier (2026-07-22 research pass, cross-checked against the World
  Bank/PPIAF PPP Knowledge Lab document library and secondary
  business-registration sources). This catalog is DELIBERATELY thinner
  and more conservative than sibling jurisdictions in this actor family
  (compare `cloud-itonami-iso3166-ago`'s `AGO` entry, or even
  `cloud-itonami-iso3166-mli`'s `MLI` entry, which shares the same
  OHADA/francophone-Africa legal framework): the dossier did NOT
  surface an independently-verifiable Portuguese official name for the
  national procurement regulatory body, and did NOT surface a national
  e-procurement portal or a distinct tax-ID scheme name -- rather than
  invent any of those, this catalog states honestly what the dossier
  actually confirms and leaves the rest unfilled. This mirrors the
  precedent already set by `cloud-itonami-iso3166-stp`'s `STP` entry
  and `cloud-itonami-iso3166-sdn`'s `SDN` entry (both correctly kept
  thin for the same reason -- a thinner catalog is not a defect, it is
  the honest reflection of a thinner dossier).

  Sources actually used:
    - Procurement legal basis: \"Lei-Quadro Relativo Aos Contratos
      Públicos\" (Framework Law on Public Contracts), indexed at the
      World Bank's PPIAF/PPP Knowledge Lab library:
      https://www.ppiaf.org/documents/2808 (mirrored at
      https://library.pppknowledgelab.org/documents/2808).
    - Procurement planning requirement: contracting authorities must
      develop an annual public-procurement plan, based on their own
      activity program, incorporated into the State budget -- only
      contracts included in this annual plan may be executed.
    - Business/commercial registration: business creation and
      registration procedures run through the Centro de Formalização
      de Empresas (CFE -- Business Formalization Center), which
      centralizes registration with the commercial registry AND the
      general tax authority in one filing. The commercial registry
      itself is the Conservatória do Registo Comercial, operating
      within the Ministry of Justice's framework.
    - Legal/corporate framework: Guinea-Bissau's commercial law draws
      on the OHADA Uniform Act on General Commercial Law -- Guinea-
      Bissau is an OHADA member state (acceded).

  IMPORTANT CORRECTION (same pattern as `cloud-itonami-iso3166-stp`'s
  `STP` entry docstring): this repo's original scaffold (README.md,
  organization.edn `:head-role`) claimed a named regulator \"ARMP\" for
  Guinea-Bissau. That specific claim could NOT be independently
  confirmed for this research pass -- \"ARMP\" is a real procurement-
  regulator ACRONYM used by several OTHER African jurisdictions
  (Senegal, Côte d'Ivoire, DR Congo, Guinea, Cameroon, Benin, Cape
  Verde), but no primary Guinea-Bissau government source confirming
  that same acronym for Guinea-Bissau's own procurement body was found.
  An additional targeted search pass (beyond the original dossier) also
  surfaced a World Bank Guinea-Bissau Public Expenditure Review
  reference to a \"Central Public Procurement Unit\" and scattered
  secondary mentions of an acronym \"ARCP\" in workshop/social-media
  contexts (e.g. an Angola government report listing \"ARCP da
  Guiné-Bissau\" as a PALOP workshop participant) -- neither rises to
  the bar of an independently-verified PRIMARY source (a Guinea-Bissau
  government domain or the procurement law's own text), so neither is
  stated as fact here. `:owner-authority` below therefore names the
  body only in English descriptive terms (per the dossier: formerly
  the \"Central Unit of Public Purchases\"), not by an unverified
  Portuguese acronym. Do not upgrade this to a specific named agency
  (\"ARMP\", \"ARCP\", or any other) without a verified primary source.

  What this catalog deliberately does NOT claim (per dossier
  instruction): no national e-procurement portal was found -- none is
  invented. No specific tax-ID scheme name (a NIF-equivalent) was
  independently confirmed for Guinea-Bissau -- the tax-registration
  requirement is grounded ONLY in \"the general tax authority\"
  registration performed via the CFE single window, without a named
  acronym. Accordingly there is no separate `:rep-*`/`:corporate-
  number-*` sub-map on the `GNB` entry below (contrast `AGO`/`MLI`,
  which both have at least one, grounded in their own richer
  dossiers) -- `rep-spec-basis`/`corporate-number-spec-basis` return
  nil for `GNB`, honestly, not as a bug.")

(def catalog
  {"GNB" {:name "Guinea-Bissau"
          ;; The dossier surfaced an English-language description of
          ;; this body ("a National Public Procurement Agency",
          ;; formerly the "Central Unit of Public Purchases") but NOT
          ;; an independently-verified current Portuguese official
          ;; name -- see the IMPORTANT CORRECTION note above. State
          ;; only what is confirmed.
          :owner-authority "the national public-sector procurement regulatory body responsible for administering the Lei-Quadro Relativo Aos Contratos Públicos (formerly known as the \"Central Unit of Public Purchases\"; its current Portuguese official name was NOT independently confirmed in this research pass -- see this namespace's docstring)"
          :legal-basis "Lei-Quadro Relativo Aos Contratos Públicos (Framework Law on Public Contracts)"
          :national-spec "an annual public-procurement plan requirement (each contracting authority develops one from its own activity program, incorporated into the State budget; only contracts included in this plan may be executed) -- no verified national e-procurement portal"
          :provenance "https://www.ppiaf.org/documents/2808 (mirrored at https://library.pppknowledgelab.org/documents/2808)"
          :required-evidence ["Centro de Formalização de Empresas (CFE) business-registration record"
                               "Conservatória do Registo Comercial commercial-registration record (OHADA Uniform Act on General Commercial Law)"
                               "General tax-authority registration record (obtained via the CFE single window)"
                               "Annual procurement-plan inclusion record"]}
   ;; -- reference jurisdictions, reused verbatim from already-merged
   ;; sibling repos (cloud-itonami-iso3166-ago / -mli), not new claims --
   "USA" {:name "United States" :owner-authority "GSA/SAM.gov" :legal-basis "FAR" :national-spec "SAM.gov" :provenance "https://sam.gov/"
          :required-evidence ["EIN record" "SAM.gov registration record" "State business registration record" "SAM UEI verification record"]}
   "CIV" {:name "Côte d'Ivoire" :owner-authority "ANRMP" :legal-basis "Code des marchés publics" :national-spec "e-procurement" :provenance "https://www.anrmp.ci/"
          :required-evidence ["RCCM record" "e-procurement registration" "RCCM extract" "Authorized-representative record"]}})

(defn spec-basis [iso3] (get catalog iso3))
(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s) missing (remove catalog iso3s)]
     {:requested (count iso3s) :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note "R0 catalog seed"})))
(defn required-evidence-satisfied? [iso3 submitted]
  (when-let [{:keys [required-evidence]} (spec-basis iso3)]
    (= (count required-evidence) (count (filter (set submitted) required-evidence)))))
(defn evidence-checklist [iso3] (:required-evidence (spec-basis iso3) []))
(defn rep-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:rep-owner-authority sb)
      (select-keys sb [:rep-owner-authority :rep-legal-basis :rep-provenance]))))
(defn corporate-number-spec-basis [iso3]
  (when-let [sb (spec-basis iso3)]
    (when (:corporate-number-owner-authority sb)
      (select-keys sb [:corporate-number-owner-authority :corporate-number-legal-basis :corporate-number-provenance]))))
