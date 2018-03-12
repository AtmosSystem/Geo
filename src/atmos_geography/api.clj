(ns atmos-geography.api
  (:require [compojure.core :refer [GET defroutes]]
            [atmos-kernel.core :refer [not-found-route
                                       ms-atmos-method
                                       make-json-app
                                       ms-atmos-response
                                       ms-atmos-main-method-response
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

(defn- get-sectors*
  []
  (ms-atmos-response (get-all-sectors)))


(defn- get-towns*
  []
  (ms-atmos-response (get-all-towns)))

;-------------------------------------------------------
; END Geography functions
;-------------------------------------------------------


(defroutes app-routes
           (ms-atmos-main-method-response :geography)

           (GET
             (ms-atmos-method :geography sectors)
             request
             (get-sectors*))

           (GET
             (ms-atmos-method :geography towns)
             request
             (get-towns*))

           not-found-route)

(def app (make-json-app app-routes))