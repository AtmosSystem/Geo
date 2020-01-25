(ns atmos-geo.core)

(defmulti get-all (fn [entity] (keyword entity)))

