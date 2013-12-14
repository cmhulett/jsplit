(ns jsplit.core
  (:use seesaw.core))

(def main-frame (frame :title "Hello"
              :content "Hello world."
              :on-close :exit))

(defn -main [& args]
  (invoke-later
  (-> main-frame pack! show!)))
