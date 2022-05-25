package creating

import io.reactivex.Observable
import java.util.concurrent.TimeUnit


fun main() {
    interval()
    Thread.sleep(5000);
}

/**
 * https://reactivex.io/documentation/operators/interval.html
 * create an Observable that emits a sequence of integers spaced by a given time interval
 */
fun interval() {
    Observable.interval(1, TimeUnit.SECONDS)
        .subscribe {
            println("interval = $it")
        }
}