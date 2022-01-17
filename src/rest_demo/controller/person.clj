(ns rest-demo.controller.person
 (:require [clojure.data.json :as json]
           [rest-demo.repository.person :as repo]))

(defn getparameter [req pname] (get (:params req) pname))

(defn people-handler [req]
  {:status  200
   :headers {"Content-Type" "text/json"}
   :body    (str (json/write-str @repo/people-collection))})

(defn addperson-handler [req]
  {:status  200
   :headers {"Content-Type" "text/json"}
   :body    (-> (let [p (partial getparameter req)]
                  (str (json/write-str (repo/addperson! (p :firstname) (p :surname))))))})