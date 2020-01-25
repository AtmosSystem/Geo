(ns atmos-geo.serializers
  (:require [atmos-kernel.serializer.core :refer :all]))

(defrecord Sector [id name])
(defrecord Town [id name])

(defn serialize-sectors
  [sector-data]
  (let [{:keys [id name]} sector-data
        sector-data (mapping (make-fields ->Sector serializer-field [[id 'id]
                                                                     [name 'name]]))]
    sector-data))

(defn serialize-towns
  [town-data]
  (let [{:keys [id name]} town-data
        town-data (mapping (make-fields ->Town serializer-field [[id 'id]
                                                                 [name 'name]]))]
    town-data))