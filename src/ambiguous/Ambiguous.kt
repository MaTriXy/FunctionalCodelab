package ambiguous

import rx.Observable
import utils.Utils

fun main(args: Array<String>){


    Observable.amb(Observable.from(Utils.DataGenerator.provideGreekAlphabet()), Observable.from(Utils.DataGenerator.provideEnglishAlphabet()))
            .subscribe{System.out.println(it)}


}