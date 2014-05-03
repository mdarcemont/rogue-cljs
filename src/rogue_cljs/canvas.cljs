(ns rogue-cljs.canvas)

(defn context [canvas] (.getContext canvas "2d"))

(defn set-dimensions! [canvas w h]
  (set! (.-width canvas) w)
  (set! (.-height canvas) h))

(defn fill-style! [ctx color]
  (set! (.-fillStyle ctx) color))

(defn font! [ctx font]
  (set! (.-font ctx) font))

(defn text-align! [ctx text-align]
  (set! (.-textAlign ctx) text-align))

(defn text-baseline! [ctx text-baseline]
  (set! (.-textBaseline ctx) text-baseline))

(defn fill-text! [ctx text x y]
  (set! (.-fillText ctx) [text x y]))

(defn draw-image! [canvas image x y]
  (.drawImage (context canvas) image x y)
)
