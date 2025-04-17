(ns binary-search
  (:require [utils :refer [int-div]]))

(defn binary-search [coll item]
  (loop [low 0
         high (-> coll
                  count
                  inc)]
    (if (<= low high)
      (let [mid (int-div (+ low high) 2)
            val (coll mid)]
        (cond
          (< val item) (recur (inc mid) high)
          (> val item) (recur low (dec mid))
          :else mid))
      -1)))

(assert (= (binary-search [1 3 5 7 9] 3) 1))

(assert (= (binary-search [1 3 5 7 9] -1) -1))
