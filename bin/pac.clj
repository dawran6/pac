(ns pac
  (:require [integrant.core :as ig]
            [pac.system :as system]))

(defn -main [& args]
  (defonce system (ig/init (system/read-config)))
  (println "Server started"))

(comment
  (-main)
  (ig/halt! system))
