(ns bfs
  (:import [clojure.lang PersistentQueue]))

(defn bfs [graph start pred]
  (loop [queue (apply conj PersistentQueue/EMPTY (get graph start))
         searched #{}]
    (if-let [top (peek queue)]
      (if (not (contains? searched top))
        (if (pred top)
          top
          (recur (apply conj (pop queue) (get graph top))
                 (conj searched top)))
        (recur (pop queue) searched))
      nil)))

(assert (= (-> {:you #{:alice :bob :claire}
                :bob #{:peggy}
                :alice #{:peggy}
                :claire #{:tom :john}
                :peggy #{}
                :tom #{}
                :john #{}}
               (bfs :you #(.endsWith (name %) "m")))
           :tom))
