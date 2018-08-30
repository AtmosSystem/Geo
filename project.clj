(defproject atmos-geography "0.1.0-SNAPSHOT"
  :description "Atmos geography micro service"
  :url "https://github.com/AtmosSystem"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [atmos-kernel "0.6.11"]
                 [atmos-data-kernel "0.5.6"]
                 [environ "1.1.0"]]
  :plugins [[lein-ring "0.12.3"]
            [lein-environ "1.1.0"]]
  :ring {:handler atmos-geography.api/app}
  :profiles {
             :uberjar {:aot :all
                       :env {:resource-file "config-prod"}}
             :dev     {:dependencies [[javax.servlet/servlet-api "2.5"]
                                      [ring/ring-mock "0.3.0"]]
                       :env          {:resource-file "config-dev"}}})
