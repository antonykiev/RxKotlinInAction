package filtering

import Constants
import io.reactivex.Observable

fun main() {
    filter()
}

fun filter() {
    Observable.fromIterable(Constants.defaultIterable)
        .filter { it % 2 == 0 }
        .subscribe {
            println("filter = $it")
        }
}