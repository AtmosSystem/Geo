(ns atmos-geography.api
  (:require [compojure.core :refer [GET defroutes]]
            [atmos-kernel.core :refer [not-found-route
                                       not-implemented-fn
                                       ms-atmos-method
                                       make-json-app
                                       ms-atmos-response
                                       ms-atmos-cond-response
                                       ms-atmos-let-cond-response
                                       ms-atmos-main-method-response
                                       keyword-map
                                       request-body
                                       read-resource-edn]]
            [atmos-rdb-kernel.core :refer [defpersistence init-persistence]]
            [atmos-geography.core :refer :all]))


;-------------------------------------------------------
; BEGIN VARS
;-------------------------------------------------------
(def configuration (read-resource-edn :config-prod))

(-> configuration :database defpersistence init-persistence)

;-------------------------------------------------------
; END VARS
;-------------------------------------------------------


;-------------------------------------------------------
; BEGIN Geography functions
;-------------------------------------------------------
(defn- get-cities*
  []
  (ms-atmos-response (get-cities)))

(defn- get-towns*
  []
  (ms-atmos-response (get-towns)))

;-------------------------------------------------------
; END Geography functions
;-------------------------------------------------------


(defroutes app-routes
           (ms-atmos-main-method-response :geography)

           (GET
             (ms-atmos-method :geography cities)
             request
             (get-cities*))

           (GET
             (ms-atmos-method :geography towns)
             request
             (get-towns*))

           not-found-route)

(def app (make-json-app app-routes))