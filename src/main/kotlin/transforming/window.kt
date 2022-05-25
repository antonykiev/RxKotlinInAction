package transforming

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

fun main() {
    window()
    Thread.sleep(10000)
}

/**
 * https://reactivex.io/documentation/operators/window.html
 * periodically subdivide items from an Observable into Observable windows and emit these windows rather than emitting
 * the items one at a time
 */
fun window() {

    Observable.range(0, 99)
        .window(5)
        .subscribe {
            println("onNext")
            it.subscribe {
                println("window = $it")
            }
        }
    
}