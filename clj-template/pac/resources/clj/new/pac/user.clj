(ns user
  (:require [integrant.repl :as ig-repl]
            [{{root-ns}}.system :as system]))

(ig-repl/set-prep! system/read-config)

(def go ig-repl/go)
(def halt ig-repl/halt)
(def reset ig-repl/reset)
