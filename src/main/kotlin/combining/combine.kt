package combining

import Constants
import io.reactivex.Observable

fun main() {
    combineLatest()
}

/**
 * https://reactivex.io/documentation/operators/combinelatest.html
 * when an item is emitted by either of two Observables, combine the latest item emitted by each Observable via a
 * specified function and emit items based on the results of this function
 */
fun combineLatest() {

    val observable0 = Observable.fromIterable(Constants.defaultIterable)
    val observable1 = Observable.fromIterable(Constants.defaultIterable2)

    Observable.combineLatest(observable0, observable1) { it0, it1 -> it0 to it1 }
        .subscribe {
            println("combineLatest = $it")
        }

}