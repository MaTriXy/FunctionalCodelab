package filtering

import rx.Observable
import rx.Observer
import utils.Utils
import java.util.function.Function
import java.util.function.Predicate

fun main(args: Array<String>){


    val pred = object : Predicate<Int> {
        override fun test(t: Int): Boolean {
            return ((t % 3 == 0) && (t < 20))
        }
    }

    val func = Function<Int, Boolean> { t -> ((t % 3 == 0) && (t < 20)) }

    Observable.from(Utils.DataGenerator.generateBigIntegerList())
//            .filter { it -> ((it % 3 == 0) && (it < 20)) }
            .filter { pred.test(it) }
            .filter {func.apply(it)}
            .filter { t -> ((t % 3 == 0) && (t < 20)) }
            .subscribe{
        System.out.println(it)
    }


    Observable.from(Utils.DataGenerator.provideEnglishAlphabet())
            .first()
            .subscribe(object : Observer<String>{
                override fun onCompleted() {
                }

                override fun onError(e: Throwable?) {
                }

                override fun onNext(c: String?) {
                    System.out.println("onNext: '$c'" )
                }
            })


    Observable.from(Utils.DataGenerator.provideEnglishAlphabet())
            .take(4)
            .subscribe({System.out.println("onNext: '$it'")})


    Observable.from(Utils.DataGenerator.provideEnglishAlphabet())
            .last()
            .subscribe({System.out.println("onNext: '$it'")})


    Observable.from(Utils.DataGenerator.provideEnglishAlphabet())
            .takeLast(4)
            .subscribe({System.out.println("onNext: '$it'")})


    Observable.from(Utils.DataGenerator.provideEmptyList())
            .firstOrDefault("List is empty")
            .subscribe({System.out.println("onNext: '$it'")})


    Observable.from(Utils.DataGenerator.provideEmptyList())
            .lastOrDefault("List is empty")
            .subscribe({System.out.println("onNext: '$it'")})

}