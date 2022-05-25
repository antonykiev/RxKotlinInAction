package transforming

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    switchMap()
    while (true) {}
}

fun switchMap() {

    Observable.range(0, 99)
        .doOnNext { println("range = $it") }
        .switchMap {
            Observable.just("switchMap = $it")
                .delay(1, TimeUnit.SECONDS)
        }
        .subscribe {
            println(it)
        }

}