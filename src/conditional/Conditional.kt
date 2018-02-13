package conditional

import rx.Observable
import rx.functions.Action2
import rx.functions.Func0
import rx.functions.Func1
import rx.functions.Func2
import utils.Utils
import java.util.function.Function
import java.util.function.Predicate
import java.util.function.Supplier

fun main(args : Array<String>){


    System.out.println("------------------- SwitchIfEmpty  -------------------")

    Observable.empty<String>().switchIfEmpty(Observable.just("Hello World "))
            .subscribe{str -> System.out.println(str)}

    System.out.println("------------------- SwitchIfEmpty + first -------------------")

    Observable.from(Utils.DataGenerator.provideGreekAlphabet())
            .defaultIfEmpty("Hello World")
            .first()
            .collect(object : Func0<String>{
                override fun call(): String {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            } , object : Action2<String, String> {
                override fun call(p0: String?, p1: String?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
            .subscribe{ s -> System.out.println(s)}



    System.out.println("------------------- SkipWhile -------------------")

    val p = object  : Predicate<Int>{
        override fun test(t: Int): Boolean {
            return t < 8
        }

    }
    Observable.from(Utils.DataGenerator.getFibonachiList())
            .skipWhile{p.test(it)}
            .subscribe{ s -> System.out.println(s)}


    System.out.println("------------------- TakeWhile -------------------")

    val p2 = object : Predicate<Int>{
        override fun test(t: Int): Boolean {
            return t < 8
        }

    }

    Observable.from(Utils.DataGenerator.getFibonachiList())
            .takeWhile{fib -> p2.test(fib)}
            .subscribe{System.out.println(it)}

    System.out.println("------------------- TakeWhileWithIndex -------------------")

    val f1 = object : Func1<Int, Boolean>{
        override fun call(index: Int): Boolean {
            return index < 8
        }

    }

    val f2 = object : Function<Int, Boolean>{
        override fun apply(t: Int): Boolean {
            return t < 8
        }

    }

    Observable.from(Utils.DataGenerator.getFibonachiList())
            .takeWhile{num -> f1.call(num)}
            .takeWhile{f2.apply(it)}
            .subscribe{System.out.println(it)}

}