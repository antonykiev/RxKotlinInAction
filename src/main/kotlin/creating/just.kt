package creating

import Constants
import io.reactivex.Observable

fun main() {
    Observable.just(Constants.defaultStr)
        .subscribe {
            println("just = $it")
        }
}

