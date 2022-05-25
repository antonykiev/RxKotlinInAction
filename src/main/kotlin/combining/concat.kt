package combining

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    concat()
    while (true) {}
}

fun concat() {
    val firstObservable = Observable.interval(1000, TimeUnit.MILLISECONDS)
        .take(10)

    val secondObservable = Observable.interval(3000, TimeUnit.MILLISECONDS)
        .map { "SOURCE-1 $it" }
        .take(5)

    Observable.concat(firstObservable, secondObservable)
        .subscribe {
            println("concat = $it")
        }
}