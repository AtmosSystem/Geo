(ns atmos-geography.core
  (:require [atmos-geography.implementation.core :refer [get-all-sectors
                                                         get-all-towns]]))


;-------------------------------------------------------
; BEGIN VARS
;-------------------------------------------------------
(def sectors "sectors")
(def towns "towns")
;-------------------------------------------------------
; END VARS
;-------------------------------------------------------

;-------------------------------------------------------
; BEGIN Geography functions
;-------------------------------------------------------

(defn get-sectors
  "Return all sectors"
  []
  (get-all-sectors))


(defn get-towns
  "Return all towns"
  []
  (get-all-towns))

;-------------------------------------------------------
; END Geography functions
;-------------------------------------------------------

