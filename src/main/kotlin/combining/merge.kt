package combining

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    merge()
    while (true) {}
}

fun merge() {

    val firstObservable = Observable.interval(1000, TimeUnit.MILLISECONDS)
        .map { "SOURCE-1 $it" }

    val secondObservable = Observable.interval(3000, TimeUnit.MILLISECONDS)
        .map { "SOURCE-2 $it" }

    firstObservable.mergeWith(secondObservable)
        .subscribe {
            println("mergeWith = $it")
        }
}