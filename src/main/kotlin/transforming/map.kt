package transforming

import io.reactivex.Observable

fun main() {
    map()
}

fun map() {

    Observable.range(0, 99)
        .map { "maped = $it" }
        .subscribe {
            println(it)
        }

}