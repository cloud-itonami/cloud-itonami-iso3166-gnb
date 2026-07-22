(ns statute.facts-test
  (:require [clojure.string :as str]
            [clojure.test :refer [deftest is]]
            [statute.facts :as facts]))

(deftest gnb-has-spec-basis
  (let [sb (facts/spec-basis "GNB")]
    (is (= 3 (count sb)))
    (is (every? #(str/starts-with? (:statute/url %) "https://") sb))
    (is (every? :statute/law-number sb))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["GNB" "JPN" "ATL"])]
    (is (= 3 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL" "JPN"] (:missing-jurisdictions c)))))

(deftest by-topic-filters
  (is (= ["gnb.lei-geral-do-trabalho-1986"]
         (mapv :statute/id (facts/by-topic "GNB" :labor))))
  (is (= ["gnb.ohada-auscgie"]
         (mapv :statute/id (facts/by-topic "GNB" :corporate-governance))))
  (is (= ["gnb.codigo-do-investimento-2011"]
         (mapv :statute/id (facts/by-topic "GNB" :investment))))
  (is (empty? (facts/by-topic "GNB" :environment)))
  (is (empty? (facts/by-topic "ATL" :labor))))
