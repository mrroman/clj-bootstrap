(ns clj-bootstrap.utils
    (:use [clojure.string :only [join]]))

(defn make-class [default-class args class-map]
  (join " " (cons default-class
                  (map #(% class-map) args))))
