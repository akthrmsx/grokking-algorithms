(ns bfs
  (:import [clojure.lang PersistentQueue]))

(defn bfs [graph start pred]
  (loop [queue (apply conj PersistentQueue/EMPTY (get graph start))
         searched #{}]
    (if-let [target (peek queue)]
      (if (not (contains? searched target))
        (if (pred target)
          target
          (recur (apply conj (pop queue) (get graph target))
                 (conj searched target)))
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
