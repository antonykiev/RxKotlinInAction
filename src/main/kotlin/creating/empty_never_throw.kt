package creating

import io.reactivex.Observable


fun main() {
    empty()
    never()
    error()
}

/**
 * https://reactivex.io/documentation/operators/empty-never-throw.html
 * create an Observable that emits no items but terminates normally
 */
fun empty() {
    Observable.empty<Any>()
        .subscribe {
            println("Empty = $it")
        }
}

/**
 * create an Observable that emits no items and does not terminate
 */
fun never() {
    Observable.never<Any>()
        .subscribe {
            println("Never = $it")
        }
}

/**
 * create an Observable that emits no items and terminates with an error
 */
fun error() {
    Observable.error<Exception>(NullPointerException())
        .subscribe({
            println("Error = $it")
        }, {
            println("Error = $it")
        })
}