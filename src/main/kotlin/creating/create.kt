package creating

import io.reactivex.Observable

fun main() {
    create()
}

/**
 * https://reactivex.io/documentation/operators/create.html
 *
 */
fun create() {
    Observable.create<Int> { emitter ->
        emitter.onNext(0)
        emitter.onNext(1)
        emitter.onNext(2)
        emitter.onNext(0)
        emitter.onComplete()
    }.subscribe {
        println(it)
    }
}