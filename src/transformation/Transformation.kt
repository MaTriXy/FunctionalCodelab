package transformation

import rx.Observable
import rx.functions.Func0
import rx.functions.Func1
import rx.functions.Func2
import utils.Utils
import java.util.function.Function

fun main(args : Array<String>){

    val func = object : Func1<String, String>{
        override fun call(s: String): String {
            return s.toUpperCase()
        }
    }

    val f = object : Function<String, String>{
        override fun apply(t: String): String {
            return t.toUpperCase()
        }

    }

    System.out.println("----------------------- map --------------------------")

    Observable.from(Utils.DataGenerator.provideGreekAlphabet())
            .map { func.call( it ) }  //Method 1
            .map { f.apply(it) }      //Method 2
            .map{it.toUpperCase()}    //Method 3
            .subscribe({System.out.println(it.toString())})

    System.out.println("-------------------------------------------------")

    System.out.println("------------------------ flat map -------------------------")

    val f2 = object : Function<String, Observable<String>>{
        override fun apply(t: String): Observable<String> {
            val result = listOf<String>(t.toUpperCase(), t.toLowerCase())
            return Observable.from(result)
        }

    }

    Observable.from(Utils.DataGenerator.provideGreekAlphabet())
            .flatMap { f2.apply(it) }
            .subscribe({System.out.println(it.toString())})

    System.out.println("-------------------------------------------------")


    System.out.println("------------------------ scan -------------------------")

    val f3 = object : Func2<StringBuilder, String, StringBuilder>{
        override fun call(buffer: StringBuilder, next: String?): StringBuilder {
            return buffer.append(next)
        }
    }

    Observable.from(Utils.DataGenerator.provideGreekAlphabet())
            .scan(StringBuilder()) { buf, next -> buf.append(next) }.last().subscribe{
        System.out.println(it)
    }

}