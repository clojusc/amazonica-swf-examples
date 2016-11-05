(defproject clojusc/amazonica-swf-examples "0.1.0-SNAPSHOT"
  :description "AWS Simple Workflow Service Examples in Clojure (using Amazonica)"
  :url "https://github.com/clojusc/amazonica-swf-examples"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0"}
  :dependencies [[amazonica "0.3.77"]
                 [clojusc/twig "0.2.6"]
                 [com.amazonaws/aws-java-sdk-simpleworkflow "1.11.49"]
                 [com.amazonaws/aws-java-sdk-swf-libraries "1.11.22"]
                 [dire "0.5.4"]
                 [org.aspectj/aspectjrt "1.8.9"]
                 [org.aspectj/aspectjweaver "1.8.9"]
                 [org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.2.395"]
                 [potemkin "0.4.3"]]
  :source-paths ["src/clj"]
  :java-source-paths ["src/java"]
  :aot [clojusc.aws.examples.swf.wfapp]
  :java-agents [[org.aspectj/aspectjweaver "1.8.9"]]
  :main amazonica.examples.simpleworkflow.app
  :aliases {
    "javaapp"
      ^{:doc (str "Command line interface for Java sample app. "
                  "For more info run `lein javaapp help`\n")}
      ^:pass-through-help
      ["run" "-m" "clojusc.aws.examples.swf.javaapp.run"]}
  :profiles {
    :uber {
      :aot :all}
    :test {
      :plugins [
        [jonase/eastwood "0.2.3" :exclusions [org.clojure/clojure]]
        [lein-kibit "0.1.2" :exclusions [org.clojure/clojure]]]
      :test-selectors {
        :default :unit
        :unit :unit
        :system :system
        :integration :integration}}
    :dev {
      :source-paths ["dev-resources/src"]
      :repl-options {:init-ns amazonica.examples.simpleworkflow.dev}
      :dependencies [
        [org.clojure/tools.namespace "0.2.11"
         :exclusions [org.clojure/clojure]]]}
    :docs {
      :dependencies [[codox-theme-rdash "0.1.1"]]
      :plugins [[lein-codox "0.10.1"]
                [lein-simpleton "1.3.0"]]
      :codox {
        :project {
          :name "amazonica-swf-examples"
          :description "AWS Simple Workflow Service Examples in Clojure (using Amazonica)"}
        :namespaces [#"^amazonica.examples.simpleworkflow\.(?!dev)"
                     #"^clojusc.*"]
        :output-path "docs/master/current"
        :doc-paths ["docs/source"]
        :metadata {
          :doc/format :markdown
          :doc "Documentation forthcoming"}
        :themes [:rdash]}}})


