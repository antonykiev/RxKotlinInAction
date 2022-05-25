package creating

import Constants.defaultArray
import Constants.defaultIterable
import io.reactivex.Observable

fun main() {
    fromArray()
    fromCallable()
}

fun fromArray() {
    Observable.fromArray(defaultArray)
        .subscribe {
            it.forEach {
                println("fromArray = $it")
            }
        }
}

fun fromCallable() {
    Observable.fromCallable {
        return@fromCallable System.currentTimeMillis()
    }.subscribe { println("fromIterable = $it") }
}

fun fromIterable() {
    Observable.fromIterable(defaultIterable)
        .subscribe { println("fromIterable = $it") }
}