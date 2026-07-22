(ns marketentry.facts-test
  (:require [clojure.test :refer [deftest is testing]]
            [marketentry.facts :as facts]))

(deftest gnb-has-spec-basis
  (let [sb (facts/spec-basis "GNB")]
    (is (some? sb))
    (is (string? (:provenance sb)))
    (is (seq (:required-evidence sb)))
    (is (= 4 (count (:required-evidence sb)))
        "thinner dossier than AGO's -- honest, not padded")))

(deftest gnb-has-no-rep-or-corporate-number-sub-map
  (testing "the dossier does not ground a distinct resident-rep regime or tax-ID scheme -- unlike AGO/MLI"
    (is (nil? (facts/rep-spec-basis "GNB")))
    (is (nil? (facts/corporate-number-spec-basis "GNB")))))

(deftest gnb-owner-authority-does-not-claim-unverified-armp
  (testing "owner-authority names only what the dossier confirms, not the unverifiable ARMP claim the original scaffold made"
    (let [sb (facts/spec-basis "GNB")]
      (is (not (re-find #"ARMP" (:owner-authority sb))) "must not repeat the unverifiable ARMP claim")
      (is (re-find #"Central Unit of Public Purchases" (:owner-authority sb))))))

(deftest gnb-national-spec-does-not-claim-eprocurement-portal
  (testing "no verified national e-procurement portal was found -- must not invent one"
    (let [sb (facts/spec-basis "GNB")]
      (is (re-find #"no verified national e-procurement portal" (:national-spec sb))))))

(deftest unknown-jurisdiction-has-no-spec-basis
  (is (nil? (facts/spec-basis "ATL")))
  (is (nil? (facts/spec-basis "ZZZ"))))

(deftest required-evidence-satisfied
  (let [sb (facts/spec-basis "GNB")
        all (:required-evidence sb)]
    (is (true? (facts/required-evidence-satisfied? "GNB" all)))
    (is (not (facts/required-evidence-satisfied? "GNB" (take 1 all))))
    (is (nil? (facts/required-evidence-satisfied? "ATL" all)))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["GNB" "ATL"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["ATL"] (:missing-jurisdictions c)))))
