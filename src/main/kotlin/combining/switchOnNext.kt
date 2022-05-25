package combining

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    switchOnNext()
    while (true) {}
}

fun switchOnNext() {

    val firstObservable = Observable.interval(100, TimeUnit.MILLISECONDS)
        .map { "SOURCE - 1 $it" }
        .startWith("Started - 1")

    val secondObservable = Observable.interval(30, TimeUnit.MILLISECONDS)
        .map { "SOURCE - 2 $it" }
        .startWith("Started - 2")
//        .delay(3, TimeUnit.SECONDS)

    Observable.switchOnNext(
        firstObservable.map { secondObservable }
    )
        .take(10)
        .subscribe {
        println("switchOnNext = $it")
    }
}