(ns app.views.welcome
  (:require [app.views.common :as common])
  (:use [noir.core :only [defpage]]))

(defpage "/" []
         (common/layout
           [:p ""]))
