package filtering

import Constants
import io.reactivex.Observable

fun main() {
    take()
}

fun take() {
    Observable.fromIterable(Constants.defaultIterable)
        .take(5)
        .subscribe {
            println("take = $it")
        }
}