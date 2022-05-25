package filtering

import Constants
import io.reactivex.Observable

fun main() {
    skip()
}

fun skip() {
    Observable.fromIterable(Constants.defaultIterable)
        .skip(1)
        .subscribe {
            println("skip = $it")
        }
}