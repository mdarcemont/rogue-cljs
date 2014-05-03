(ns rogue-cljs.ui
  (:require-macros [cljs.core.async.macros :refer [go go-loop]])
  (:require [rogue-cljs.canvas :as canvas]
            [cljs.core.async :as async :refer [chan put! pipe unique merge map< filter< alts!]]
            [goog.events :as events]
            [goog.dom :as gdom]
            [clojure.set :refer [union]]
            [clojure.string :as string]))

(enable-console-print!)

(def ui-state (atom nil))

(defn by-id [id]
  (.getElementById js/document (name id)))

(def canvas
  (by-id "canvas"))

(def width 512)

(def height 480)

(def heroImage
  (let [img (js/Image.)]
    (set! (.-src
         img
         ) "/images/hero.png")
    img
))



(def init-hero!
  {:x (/ width 2) :y (/ height 2)}
  )

(defn resetMonster []
  {:x (+ 32 (* (rand) (- width 64)))
   :y (+ 32 (* (rand) (- width 64)))}
)

(defn drawHero! [canvas coord]
 (let [{:keys [x y]} coord]
   (canvas/draw-image! canvas heroImage 20 30)
))

(defn init-canvas! [canvas]
  (drawHero! canvas init-hero!)
)

(defn init
  "Initialize UI"
  []
  (let [commands (chan)]
    (init-canvas! canvas)

    )
  )
