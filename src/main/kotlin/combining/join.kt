package combining

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun main() {
    join()
    while (true) {}
}

 fun join() {

     val firstObservable = Observable.interval(1000, TimeUnit.MILLISECONDS)
         .map { "SOURCE-1 $it" }

     val secondObservable = Observable.interval(3000, TimeUnit.MILLISECONDS)
         .map { "SOURCE-2 $it" }

     val firstWindow = Function<String, Observable<Long>> {
         Observable.timer(0, TimeUnit.SECONDS)
     }
     val secondWindow = Function<String, Observable<Long>> {
         Observable.timer(0, TimeUnit.SECONDS)
     }

     val resultSelector = BiFunction<String, String, String> { t1, t2 -> "$t1, $t2" }

     firstObservable.join(secondObservable, firstWindow, secondWindow, resultSelector)
         .subscribeOn(Schedulers.single())
         .observeOn(Schedulers.single())
         .subscribe {
             println("join = $it")
         }
}