package combining

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit

fun main() {
    zip()
    while (true) {}
}

fun zip() {

    val firstObservable = Observable.interval(1000, TimeUnit.MILLISECONDS)

    val secondObservable = Observable.interval(5000, TimeUnit.MILLISECONDS)

    Observable.zip(firstObservable, secondObservable) { t0, t1 ->
        "$t0 - $t1"
    }.subscribe {
        println("mergeWith = $it")
    }
}