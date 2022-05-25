package creating

import io.reactivex.Observable

fun main() {
    range()
}

/**
 * https://reactivex.io/documentation/operators/range.html
 * create an Observable that emits a particular range of sequential integers
 */
fun range() {
    Observable.range(0, 10)
        .subscribe{
            println("range = $it")
        }
}