(set-env!
  :resource-paths #{"resources"}
  :dependencies '[[cljsjs/boot-cljsjs "0.5.1" :scope "test"]])

(require '[cljsjs.boot-cljsjs.packaging :refer :all])

(def +lib-version+ "0.3.1")
(def +version+ (str +lib-version+ "-0"))

(task-options!
 pom { :project     'cljsjs/midi
       :version     +version+
       :description "MIDI.js: Sequencing in Javascript"
       :url         "http://galacticmilk.com/midi-js"
       :scm         { :url "https://github.com/mudcube/MIDI.js" }
       :license     { "MIT" "https://github.com/mudcube/MIDI.js/blob/master/LICENSE.txt" }})

(deftask package []
  (comp
   ;; Q: Where can this be downloaded?
   (download :url (format "https://github.com/jimrthy/MIDI.js/archive/v%s.zip" +lib-version+)
             ;; Q: What kind of checksum is expected here?
             :checksum
             ;; This was the md5sum of my original .zip file
             ;; "9abcbe7e16600c56e13b2779d096b7a8"
             ;; This is the version I actually downloaded from github
             "28c8f96ed13dfa709e423881950d3a72"
             :unzip true)
    (sift :move { #"^MIDI.js.*/dist/midi\.js$"      "cljsjs/midi/development/MIDI.js"
                  #"^MIDI.js.*/dist/midi\.min\.js$" "cljsjs/midi/production/MIDI.min.js" })
    (sift :include #{#"^cljsjs"})
    (deps-cljs :name "cljsjs.midi")
    (pom)
    (jar)))
