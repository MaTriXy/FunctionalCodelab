package group

import rx.Observable
import rx.Observer
import rx.functions.Func1
import rx.observables.GroupedObservable
import utils.Utils
import java.util.function.Function

fun main(args: Array<String>) {

    val f1 = Func1<Int, Observable<String>> { i ->
        if (i % 2 == 0) {
            Observable.just("EVEN")
        } else {
            Observable.just("ODD")
        }
    }


    val f2 = Function<Int, GroupedObservable<String, Int>> { t ->
        if (t % 2 == 0) {
            GroupedObservable.from("EVEN", Observable.just(t))
        } else {
            GroupedObservable.from("ODD", Observable.just(t))
        }
    }



    Observable.from(Utils.DataGenerator.generateBigIntegerList())
            .groupBy {
                f2.apply(it).subscribe(object : Observer<Int> {
                    override fun onError(p0: Throwable?) {
                    }

                    override fun onCompleted() {
                    }

                    override fun onNext(p0: Int) {
                        System.out.println(p0)
                    }

                })
            }
}


//    Observable.from(Utils.DataGenerator.generateBigIntegerList())
//            .groupBy { if(0 == it % 2) "EVEN" else "ODD"  }
//            .subscribe{
//                System.out.println("Key: ${it.key}")
//                it.subscribe{
//                    x -> System.out.println("${it.key} : $x")
//                }
//            }
//            }
