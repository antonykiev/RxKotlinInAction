package transforming

import Constants
import io.reactivex.Observable

fun main() {
    flatmap()
}

/**
 * https://reactivex.io/documentation/operators/flatmap.html
 *  transform the items emitted by an Observable into Observables, then flatten the emissions from those into a single Observable
 */
fun flatmap() {
    Observable.fromIterable(Constants.defaultIterable)
        .flatMap { Observable.just(it + 10) }
        .subscribe {
            println("flatmap = $it")
        }

}