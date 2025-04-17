(ns utils)

(defn int-div [num div]
  (-> (/ num div)
      Math/floor
      int))

(defn remove-by-index [coll idx]
  (into (subvec coll 0 idx) (subvec coll (inc idx))))
