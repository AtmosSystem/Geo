(ns atmos-geography.api
  (:require [atmos-kernel.web.core :refer [json-web-app]]
            [atmos-kernel.web.route :refer [defatmos-route
                                            atmos-GET]]
            [atmos-geography.core :refer :all]))


(defatmos-route app-routes :geography
                (atmos-GET [sectors] (get-sectors))

                (atmos-GET [towns] (get-towns)))

(def app (json-web-app app-routes))