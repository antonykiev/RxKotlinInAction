package transforming

import Constants
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    flatmap()
    while (true) {}
}

/**
 * https://reactivex.io/documentation/operators/flatmap.html
 *  transform the items emitted by an Observable into Observables, then flatten the emissions from those into a single Observable
 */
fun flatmap() {
    Observable.range(1, 15)
        .flatMap {
            Observable.just(it).delay(1, TimeUnit.MILLISECONDS)
        }
        .subscribe {
            println("concatMap = $it")
        }

}