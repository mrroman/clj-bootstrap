(ns clj-bootstrap.navbar
  (:use [clj-bootstrap.utils]))

(def ^{ :private true }
  navbar-opts
  {:fixed-to-top "navbar-fixed-top"
   :fixed-to-bottom "navbar-fixed-bottom"
   :static-top "navbar-static-top"
   :inverse "navbar-inverse"})

(defn navbar [& opts-items]
  (let [opts (filter keyword? opts-items)
        items (filter #(not (keyword? %)) opts-items)]
    [:div { :class (make-class "navbar" opts navbar-opts) }
     (conj [:div.navbar-inner] items)]))

(defn brand [title]
  [:a.brand { :href "#" }
   title])

(defn links [& links]
  [:ul.nav
   links])

(defn link [& {:keys [href title active] :or {:active false}}]
  [:li { :class (when active "active") }
   [:a { :href href }
    title]])

