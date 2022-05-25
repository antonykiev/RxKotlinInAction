package filtering

import Constants
import io.reactivex.Observable

fun main() {
    elementAt()
}

fun elementAt() {
    Observable.fromIterable(Constants.defaultIterable)
        .elementAt(5)
        .subscribe {
            println("elementAt = $it")
        }
}