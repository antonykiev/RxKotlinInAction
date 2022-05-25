package filtering

import io.reactivex.Observable

fun main() {
    distinct()
}

fun distinct() {
    Observable.just(0,0,1,1,0,4,5,6,7,8)
        .distinct()
        .subscribe {
            println("distinct = $it")
        }
}