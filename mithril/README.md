# cljsjs/mithril

```clojure
[cljsjs/mithril "0.2.4-0"] ;; latest release
```

This jar comes with `deps.cljs` as used by the [Foreign Libs][flibs] feature
of the Clojurescript compiler. After adding the above dependency to your project
you can require the packaged library like so:

```clojure
(ns application.core
  (:require cljsjs.mithril :as m))
```
