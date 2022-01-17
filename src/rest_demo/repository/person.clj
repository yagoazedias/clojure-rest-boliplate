(ns rest-demo.repository.person
  (:require [clojure.string :as str]))

(def people-collection (atom []))

(defn addperson! [firstname surname]
  (swap! people-collection conj {:firstname (str/capitalize firstname)
                                      :surname (str/capitalize surname)}))