package filtering

import Constants
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit

fun main() {
    debounce()
    while (true) { }
}


/**
 * https://reactivex.io/documentation/operators/debounce.html
 * If items keep being emitted by the source ObservableSource faster than the timeout then no items will be emitted by the resulting ObservableSource.
 */
fun debounce() {
    val subject = BehaviorSubject.create<Int>()

    subject
        .debounce(1, TimeUnit.SECONDS)
        .subscribe {
            println("debounce = $it")
        }

    Observable.interval(2_800, TimeUnit.MILLISECONDS)
        .map { it.toInt() }
        .subscribe {
            subject.onNext(it)
        }
}