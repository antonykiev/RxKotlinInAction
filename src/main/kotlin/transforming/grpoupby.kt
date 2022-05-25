package transforming

import io.reactivex.Observable

fun main() {
    groupBy()
}

fun groupBy() {

    Observable.range(0, 99)

        .groupBy { it % 2 == 0 }
        .flatMapSingle { grpd -> grpd
            .toList()
            .map { it.size to it }
        }
        .subscribe {
            println("groupBy = $it")
        }

}
