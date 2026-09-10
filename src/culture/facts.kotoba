(ns culture.facts
  "Country-level regional-culture catalog for Guinea-Bissau (GNB) --
  national dishes, protected products, beverages, crafts, festivals and
  heritage sites, per ADR-2607171400 addendum 2 (cloud-itonami-
  municipality-culture-catalog Wave 1, in com-junkawasaki/root). Sibling
  namespace to `marketentry.facts` / `statute.facts` (ADR-2607141700);
  city-level counterparts live in the cloud-itonami-municipality-* repos.

  Catalog is keyed by UPPERCASE ISO3 (mirrors `statute.facts`); entries
  carry no :culture/municipality (that attribute is city-level only).

  Every entry cites a source URL that was actually fetched and read on
  :culture/retrieved-at -- never fabricated. Summaries state only what the
  cited source confirms. An item not in this table has NO spec-basis, full
  stop; extend `catalog`, do not invent an id/url.")

(def catalog
  "iso3 -> vector of culture entries."
  {"GNB"
   [{:culture/id "gnb.dish.caldo-de-mancarra"
     :culture/name "Caldo de mancarra"
     :culture/country "GNB"
     :culture/kind :dish
     :culture/summary "Traditional caldo (soup) of Guinea-Bissauan cuisine."
     :culture/url "https://en.wikipedia.org/wiki/Guinea-Bissauan_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gnb.dish.yassa"
     :culture/name "Yassa"
     :culture/country "GNB"
     :culture/kind :dish
     :culture/summary "Chicken prepared with mustard, citrus and onion, eaten in Guinea-Bissau during celebrations such as Amílcar Cabral's birthday."
     :culture/url "https://en.wikipedia.org/wiki/Guinea-Bissauan_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gnb.dish.cafriela-de-frango"
     :culture/name "Cafriela de frango"
     :culture/country "GNB"
     :culture/kind :dish
     :culture/summary "Grilled spicy chicken dish of Guinea-Bissauan cuisine."
     :culture/url "https://en.wikipedia.org/wiki/Guinea-Bissauan_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gnb.beverage.palm-wine"
     :culture/name "Palm wine"
     :culture/country "GNB"
     :culture/kind :beverage
     :culture/summary "Beverage with which family ceremonies marking birth, circumcision, marriage and death are celebrated in Guinea-Bissau."
     :culture/url "https://en.wikipedia.org/wiki/Guinea-Bissauan_cuisine"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gnb.product.cashew"
     :culture/name "Cashew nuts"
     :culture/country "GNB"
     :culture/kind :product
     :culture/summary "Guinea-Bissau ranked ninth in world cashew production in 2019; cashew nuts are a primary export commodity alongside fish."
     :culture/url "https://en.wikipedia.org/wiki/Economy_of_Guinea-Bissau"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}
    {:culture/id "gnb.heritage.bijagos-islands"
     :culture/name "Bijagós Islands"
     :culture/country "GNB"
     :culture/kind :heritage
     :culture/summary "Archipelago of about 88 islands and islets off the coast of Guinea-Bissau, a UNESCO Biosphere Reserve since 1996 and a World Heritage Site as of 2025."
     :culture/url "https://en.wikipedia.org/wiki/Bijag%C3%B3s_Islands"
     :culture/url-provenance :wikipedia-en
     :culture/retrieved-at "2026-07-17"}]})

(defn spec-basis [iso3] (get catalog iso3))

(defn coverage
  ([] (coverage (keys catalog)))
  ([iso3s]
   (let [have (filter catalog iso3s)
         missing (remove catalog iso3s)]
     {:requested (count iso3s)
      :covered (count have)
      :covered-jurisdictions (vec (sort have))
      :missing-jurisdictions (vec (sort missing))
      :note (str "cloud-itonami-iso3166-gnb culture catalog "
                 "(ADR-2607171400 addendum 2, Wave 1): " (count (get catalog "GNB"))
                 " GNB entries, each with a fetched-and-read citation. "
                 "Extend `culture.facts/catalog`, never fabricate an id/url.")})))

(defn by-kind [iso3 kind]
  (filterv #(= (:culture/kind %) kind) (spec-basis iso3)))
