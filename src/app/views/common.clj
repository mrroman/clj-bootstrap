(ns app.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css include-js html5]]))

(def ^{ :private true } app-title "Clj-bootstrap")

(defn menu-item [address text]
  [:li
   [:a { :href address } text ]])

(defn navbar [& menu]
  [:div { :class "navbar navbar-fixed-top" }
   [:div { :class "navbar-inner" }
    [:div { :class "container-fluid" }
     [:a { :class "btn btn-navbar" :data-toggle "collapse" :data-target ".nav-collapse" }
      [:span { :class "icon-bar" }]
      [:span { :class "icon-bar" }]
      [:span { :class "icon-bar" }]]
     [:a { :class "brand" :href "#" } app-title]
     [:div { :class "nav-collapse collapse" }
      [:p { :class "navbar-text pull-right" }]
      [:ul { :class "nav" }
       menu]]]]])

(defpartial layout [& content]
            (html5
              [:head
               [:title app-title]
               (include-css "/css/bootstrap-responsive.min.css")
               (include-css "/css/bootstrap.min.css")]
              [:body
               (navbar
                (menu-item "#" "Item1")
                (menu-item "#" "Options"))
               [:div#container
                content]
               (include-js "http://code.jquery.com/jquery-latest.js")
               (include-js "/js/bootstrap.min.js")]))
