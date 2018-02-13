import java.util.*
import java.util.function.Function
import java.util.function.Predicate
import java.util.function.Supplier


fun main(args: Array<String>) {
    System.out.println("Hello from Kotlin")

    val strLegthTest = Predicate<String> { s -> s.length < 10 }

    //Predicate - takes one argument and return a boolean
    //The test() method is used to do the predicate functionality
    val strLength = object : Predicate<String>{
        override fun test(t: String): Boolean {
            return  t.length < 10
        }
    }

    //Supplier - Takes no argument and produce a value
    //The get() method is used to do the Supplier functionality and retrieve the value
    val testString = object : Supplier<String>{
        override fun get(): String {
           return  "I Love Kotlin"
        }
    }

    println("${testString.get()} length less then 10: ${strLength.test("Hello World")}" )


    //Function - takes one argument and produce a value
    //The apply() method is used to do run Function functionality
    val converter = object : Function<Integer, String>{
        override fun apply(t: Integer): String {
            return t.toString()
        }
    }


    println("\"${testString.get()}\" length is ${converter.apply(Integer(testString.get().length))} ")

}


