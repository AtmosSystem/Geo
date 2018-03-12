(in-ns 'atmos-geography.core)

(defentity ^:private towns

           (pk :id)
           (entity-fields :id :name))

(defentity ^:private sectors

           (pk :id)
           (entity-fields :id :name))

;------------------------------
; BEGIN Geography functions
;------------------------------
(load "geography/geography_get")
;------------------------------
; END Geography functions
;------------------------------

(def sectors "sectors")
(def towns "towns")