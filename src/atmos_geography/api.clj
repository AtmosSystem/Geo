(ns atmos-geography.api
  (:require [compojure.core :refer [defroutes]]
            [atmos-kernel.web.core :refer [json-web-app]]
            [atmos-kernel.web.route :refer [not-found-route
                                            atmos-GET
                                            atmos-main-route]]
            [atmos-geography.core :refer :all]))



(defroutes app-routes
           (atmos-main-route :geography)

           (atmos-GET "geography" [sectors] (get-sectors))

           (atmos-GET "geography" [towns] (get-towns))

           not-found-route)

(def app (json-web-app app-routes))