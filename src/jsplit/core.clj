(ns jsplit.core
  (:use seesaw.core))

;native OS menu bar, fonts, etc
(native!)

;main frame, everything in here, will split into sub-frames later
(def main-frame (frame :title "JSplit"
              :content (label (str (java.util.Date.)))
              :on-close :exit))

;update the main-frame contents
(defn display [content]
  (config! main-frame :content content)
  content)

;update label & sets it's contents in the main-frame
(defn update-label []
  (display (label (str (java.util.Date.)))))

;updater calls f every second, sends time to console
(defn clock-updater [f n]
            (doseq [task (repeat n f)]
                   (f)
                   (Thread/sleep 1000)
                   (println (java.util.Date.) "")))

(defn -main [& args]
  (invoke-later
  (->
    main-frame
    pack!
    show!
    (future (clock-updater update-label 10)))))
