package combining

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    startWith()
    while (true) {}
}

fun startWith() {
    Observable.interval(1000, TimeUnit.MILLISECONDS)
        .map { "SOURCE-1 $it" }
        .startWith("***STARTED***")
        .subscribe {
            println("startWith = $it")
        }
}