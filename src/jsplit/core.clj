(ns jsplit.core
  (:use seesaw.core))

;native OS menu bar, fonts, etc
(native!)

(label (str (java.util.Date.)))

(def main-frame (frame :title "JSplit"
              :content (label (str (java.util.Date.)))
              :on-close :exit))

(defn display [content]
  (config! main-frame :content content)
  content)

(defn update-label []
  (display (label (str (java.util.Date.)))))

(defn clock-updater [f n wait]
            (doseq [task (repeat n f)]
                   (f)
                   (Thread/sleep wait)
                   (println (java.util.Date.) "")))

(defn -main [& args]
  (invoke-later
  (->
    main-frame
    pack!
    show!
    (future (clock-updater update-label 10 1000)))))
