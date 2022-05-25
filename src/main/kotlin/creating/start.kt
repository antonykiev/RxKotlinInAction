package creating

import Constants
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    start()

    Thread.sleep(10000)
}

/**
 * https://reactivex.io/documentation/operators/timer.html
 * create an Observable that emits a particular item after a given delay
 */
fun start() {
    Observable.timer(2, TimeUnit.SECONDS)
        .subscribe {
            println("timer = $it")
        }

}