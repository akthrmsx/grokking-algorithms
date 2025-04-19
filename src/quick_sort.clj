(ns quick-sort)

(defn quick-sort [coll]
  (if (< (count coll) 2)
    coll
    (let [pivot (first coll)
          less (filter #(<= % pivot) (rest coll))
          greater (filter #(> % pivot) (rest coll))]
      (into [] (concat (quick-sort less)
                       [pivot]
                       (quick-sort greater))))))

(assert (= (quick-sort [10 5 2 3]) [2 3 5 10]))
