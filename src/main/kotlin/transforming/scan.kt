package transforming

import io.reactivex.Observable


fun main() {
    scan()
}

/**
 * https://reactivex.io/documentation/operators/scan.html
 * apply a function to each item emitted by an Observable, sequentially, and emit each successive value
 */
fun scan() {
    Observable.just("h", "e", "l", "l", "o", "w", "!")
        .scan { t1, t2 -> t1 + t2 }
        .subscribe {
            println("scan = $it")
        }
}