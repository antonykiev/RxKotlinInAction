package transforming

import Constants
import io.reactivex.Observable

fun main() {
    buffer()
}

/**
 * https://reactivex.io/documentation/operators/buffer.html
 * periodically gather items emitted by an Observable into bundles and emit these bundles rather than emitting the items one at a time
 */
fun buffer() {

    Observable.fromIterable(Constants.defaultIterable)
        .buffer(3)
        .subscribe {
            println("buffer = $it")
        }

}