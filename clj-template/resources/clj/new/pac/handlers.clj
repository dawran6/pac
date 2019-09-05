(ns {{root-ns}}.handlers
  (:require [hiccup2.core :as hiccup]))

(defn index [req]
  {:status 200
   :body   (str (hiccup/html [:h1 "Hello Pac!"]))})
