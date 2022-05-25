package filtering

import Constants
import io.reactivex.Observable
import io.reactivex.functions.Consumer

fun main() {
    first()
}

fun first() {
    Observable.fromIterable(Constants.defaultIterable)
        .first(-1)
        .subscribe(Consumer {
            println("filter = $it")
        })
}