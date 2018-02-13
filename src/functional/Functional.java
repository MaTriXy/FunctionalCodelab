package functional;

import utils.Utils;

import java.util.Observable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Functional {

    public static void main(String[] args){

        System.out.println("Hello From Java");

        Predicate<String> strLegthTest = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() < 10;
            }
        };

        System.out.println("String length less then 10: " + strLegthTest.test("Hello World"));

        Function<String, Integer> strLength = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };


        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Consumer: accept " + s);
            }
        };

        Supplier<String> stringSupplier = new Supplier<String>() {
            @Override
            public String get() {
                return "I Love Java";
            }
        };

        String str = stringSupplier.get();
        System.out.println(str + " length is " + strLength.apply(str));


        Function<Integer, String> converter = new Function<Integer, String>() {
            @Override
            public String apply(Integer i) {
                return i.toString();
            }
        };


        System.out.println("Yesterday I've ate " + converter.apply(5) + " apples");

        Calculate calculate = new Calculate() {
            @Override
            public int calc(int x, int y) {
                System.out.println("Calculate: calc was called");
                return x + y;
            }
        };

        System.out.println("5 + 4 = " + calculate.calc(5, 4));

    }
}
