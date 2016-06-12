# cljsjs/mdi

## Q: What version/release number makes sense?

[](dependency)
```clojure
[cljsjs/midi "0.1.0-0"] ;; latest release

```
[](/dependency)

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.midi))
```

Documentation for the midi.js lib can be found [on its github page](https://github.com/mudcube/MIDI.js)

[flibs]: https://github.com/clojure/clojurescript/wiki/Packaging-Foreign-Dependencies
