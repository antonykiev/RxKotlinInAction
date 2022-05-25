package filtering

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import java.util.concurrent.TimeUnit


fun main() {
    throttle()
    while (true) { }
}

fun throttle() {
    val subject = BehaviorSubject.create<Int>()

    subject
        .throttleLatest(2, TimeUnit.SECONDS)
        .subscribe {
            println("debounce = $it")
        }

    Observable.interval(500, TimeUnit.MILLISECONDS)
        .map { it.toInt() }
        .subscribe {
            subject.onNext(it)
        }
}