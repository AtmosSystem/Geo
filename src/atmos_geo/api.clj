(ns atmos-geo.api
  (:require [atmos-kernel.web.ring :refer [def-json-web-api]]
            [ring.middleware.defaults :refer [api-defaults]]
            [atmos-kernel.web.route :refer [defatmos-routes
                                            atmos-main-route
                                            atmos-GET]]
            [atmos-kernel.serializer.core :refer :all]
            [atmos-geo.serializers :refer :all]
            [atmos-geo.core :refer :all]))

(def geo "geo")
(def sectors "sectors")
(def towns "towns")

(declare app app-routes request)

(defatmos-routes app-routes
                 (atmos-main-route :geo)

                 (atmos-GET [geo sectors] request
                            (serialize (get-all sectors) serialize-sectors))

                 (atmos-GET [geo towns] request
                            (serialize (get-all towns) serialize-towns)))

(def-json-web-api app app-routes api-defaults)