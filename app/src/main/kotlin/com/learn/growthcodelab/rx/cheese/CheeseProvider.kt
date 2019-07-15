package com.learn.growthcodelab.rx.cheese

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class CheeseProvider {

    fun search(query: String): Observable<List<Cheese>> {
        /*  return Observable.timer(3, TimeUnit.MILLISECONDS)
                  .flatMap { Observable.fromCallable { doSearchCheese(query) } }*/
        return Observable
                .fromCallable { doSearchCheese(query) }
                .delay(3, TimeUnit.SECONDS)
    }

    private fun doSearchCheese(query: String): List<Cheese> {
        return Cheese.cheeses[query] ?: Cheese.defaultCheese
    }
}