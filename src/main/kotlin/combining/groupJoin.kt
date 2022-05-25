package combining

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {

}

fun groupJoin() {

    val firstObservable = Observable.interval(1000, TimeUnit.MILLISECONDS)
        .map { "SOURCE-1 $it" }

    val secondObservable = Observable.interval(3000, TimeUnit.MILLISECONDS)
        .map { "SOURCE-2 $it" }

    val leftWindow = Function<String, Observable<Long>> {
        Observable.timer(0, TimeUnit.SECONDS)
    }

    val rightWindow = Function<String, Observable<Long>> {
        Observable.timer(3, TimeUnit.SECONDS)
    }

    val resultSelector = BiFunction<String, Observable<String>, Observable<Pair<String, String>>> { t1, t2 ->
        t2.map {
            return@map Pair(t1, it)
        }
    }
    firstObservable.groupJoin(secondObservable, leftWindow, rightWindow, resultSelector)
        .concatMap { it }
        .subscribe {
            println("groupJoin = $it")
        }

}