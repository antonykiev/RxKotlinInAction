package creating

import io.reactivex.Observable


/**
 * https://reactivex.io/documentation/operators/defer.html
 */
fun main() {
    val car = Car()

    val brandObservable = car.getBrandObservable()
    val brandDeferObservable = car.getBrandDeferObservable()

    car.brand = "BMW"

    brandObservable
        .subscribe { brand ->
            println("brandObservable : $brand")
        }

    brandDeferObservable
        .subscribe { brand ->
            println("brandDeferObservable : $brand")
        }
}

class Car(var brand: String = Constants.defaultStr) {

    fun getBrandObservable(): Observable<String> = Observable.just(brand)

    fun getBrandDeferObservable(): Observable<String> = Observable.defer {
            Observable.just(brand)
        }
}