package creation

import rx.Observable
import utils.Utils

fun main(args: Array<String>){



    System.out.println("-----------------------------------------------")
    System.out.println("---- Observable creation from single value ----")
    System.out.println("-----------------------------------------------")

    var observable = Observable.just(Integer.valueOf(26 ))

    observable.subscribe{i -> System.out.println("onNext: $i")}


    System.out.println("-----------------------------------------------")
    System.out.println("----- Observable creation from Iterable  -----")
    System.out.println("-----------------------------------------------")


    observable = Observable.from(Utils.DataGenerator.getFibonachiList())

    observable.subscribe{
        System.out.println(it)
    }

    System.out.println("-----------------------------------------------")
    System.out.println("----- Observable creation from Array  -----")
    System.out.println("-----------------------------------------------")


    observable = Observable.from(Utils.DataGenerator.getFibonaciArray())

    observable.subscribe{
        System.out.println(it)
    }


}
