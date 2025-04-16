(ns utils)

(defn int-div [num div]
  (-> (/ num div)
      Math/floor
      int))
