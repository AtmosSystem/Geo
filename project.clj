(defproject atmos-geography "0.1.0-SNAPSHOT"
  :description "Atmos geography micro service"
  :url "https://github.com/AtmosSystem"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [atmos-kernel "0.6.3"]
                 [atmos-data-kernel "0.5.1"]]
  :plugins [[lein-ring "0.12.3"]]
  :ring {:handler atmos-geography.api/app}
  :profiles {
             :uberjar {:aot :all}
             :dev     {:dependencies [[javax.servlet/servlet-api "2.5"]
                                      [ring/ring-mock "0.3.0"]]}})
