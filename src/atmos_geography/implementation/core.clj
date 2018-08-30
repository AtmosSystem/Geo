(ns atmos-geography.implementation.core
  (:require [atmos-data-kernel.persistence.sql :refer [defget-all-entity]]
            [atmos-kernel.configuration :refer [read-edn]]
            [atmos-kernel.security.ssl :refer [defssl]]
            [atmos-data-kernel.persistence.core :refer [defpersistence]]
            [environ.core :refer [env]]
            [korma.core :refer :all]
            [korma.db :refer [defdb]]))


;-------------------------------------------------------
; BEGIN VARS
;-------------------------------------------------------
(declare get-all-towns get-all-sectors atmos-geography)

(def ^:private persistence-type :mysql)

(def ^:private resource-file (or (keyword (env :resource-file)) :config-prod))
(def ^:private configuration (read-edn resource-file))
;-------------------------------------------------------
; END VARS
;-------------------------------------------------------

; Persistence initialization
(-> configuration :ssl-data defssl)
(->> configuration :database (defpersistence persistence-type) (defdb atmos-geography))


(defentity ^:private towns
           (pk :id)
           (entity-fields :id :name))

(defentity ^:private sectors
           (pk :id)
           (entity-fields :id :name))

;------------------------------
; BEGIN Geography functions
;------------------------------
(defget-all-entity towns #(select towns))

(defget-all-entity sectors #(select sectors))
;------------------------------
; END Geography functions
;------------------------------