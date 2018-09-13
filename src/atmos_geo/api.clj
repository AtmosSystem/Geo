(ns atmos-geo.api
  (:require [atmos-kernel.web.core :refer [json-web-app]]
            [atmos-kernel.web.route :refer [defatmos-route
                                            atmos-GET]]
            [atmos-geo.core :refer :all]))

(def sectors "sectors")
(def towns "towns")

(defatmos-route app-routes :geo
                (atmos-GET [sectors] (get-all sectors))

                (atmos-GET [towns] (get-all towns)))

(def app (json-web-app app-routes))