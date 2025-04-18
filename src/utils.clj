(ns utils)

(defn int-div [num div]
  (-> (/ num div)
      Math/floor
      int))

(defn remove-by-index [coll idx]
  (into [] (concat (take idx coll)
                   (drop (inc idx) coll))))
