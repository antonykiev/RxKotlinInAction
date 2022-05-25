package transforming

import io.reactivex.Observable
import java.util.concurrent.TimeUnit




fun main() {
    concatMap()
    while (true) {}
}

fun concatMap() {
    Observable.range(1, 15)
        .concatMap {
            Observable.just(it).delay(1, TimeUnit.MILLISECONDS)
        }
        .subscribe {
            println("concatMap = $it")
        }
}