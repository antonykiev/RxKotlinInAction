package creating

import Constants
import io.reactivex.Observable

fun main() {
    repeat()
}

fun repeat() {
    Observable.just(Constants.defaultStr)
        .repeat(10)
        .subscribe {
             println("repeat = $it")
        }

}