package filtering

import io.reactivex.Observable

fun main() {
    ignoreElements()
}

fun ignoreElements() {
    Observable.fromIterable(Constants.defaultIterable)
        .ignoreElements()
        .subscribe {
            println("ignoreElements OnComplete...")
        }
}

