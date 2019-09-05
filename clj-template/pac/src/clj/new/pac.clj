(ns clj.new.pac
  "Generate a pac application project."
  (:require [clj.new.templates :refer [renderer project-name name-to-path ->files
                                       multi-segment sanitize-ns]]))

(def render (renderer "pac"))

(defn pac
  "A pac application project template."
  [name]
  (let [data {:name      (project-name name)
              :sanitized (name-to-path name)
              :root-ns   (multi-segment (sanitize-ns name))}]
    (println "Generating fresh pac project called"
             (project-name name)
             ".")
    (->files data
             [".dir-locals.el" (render ".dir-locals.el" data)]
             [".gitignore" (render "gitignore" data)]
             ["README.md" (render "README.md" data)]
             ["deps.edn" (render "deps.edn" data)]
             ["test.http" (render "test.http" data)]
             ["dev/user.clj" (render "user.clj" data)]
             ["resources/{{sanitized}}/system.edn" (render "system.edn" data)]
             ["src/{{sanitized}}/system.clj" (render "system.clj" data)]
             ["src/{{sanitized}}/handlers.clj" (render "handlers.clj" data)])))
