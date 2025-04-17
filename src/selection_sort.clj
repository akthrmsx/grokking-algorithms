(ns selection-sort
  (:require [utils :refer [remove-by-index]]))

(defn- find-smallest-index [coll]
  (loop [smallest-val (first coll)
         smallest-idx 0
         idx 1]
    (if (< idx (count coll))
      (if (< (coll idx) smallest-val)
        (recur (coll idx) idx (inc idx))
        (recur smallest-val smallest-idx (inc idx)))
      smallest-idx)))

(defn selection-sort [coll]
  (loop [coll coll
         sorted-coll []]
    (if (seq coll)
      (let [smallest-idx (find-smallest-index coll)]
        (recur (remove-by-index coll smallest-idx)
               (conj sorted-coll (coll smallest-idx))))
      sorted-coll)))

(assert (= (selection-sort [5 3 6 2 10]) [2 3 5 6 10]))
