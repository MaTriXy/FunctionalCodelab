package highorder;

import java.util.function.Function;
import java.util.function.Supplier;

public class HighOrder {

    public static void main(String[] args){

        Function<String, String> toUpperCase = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        System.out.println("--------------- Call High Order function and store it's value in variable");
        Supplier<String> xFormTransfomration = createCombineAndTransform("Good ", "Day", toUpperCase);
        System.out.println(xFormTransfomration.get()); //Only when calling the 'get' method, the code in the high order function will run.



    }


    public static Supplier<String> createCombineAndTransform(final String a, final String b, final Function<String, String> transform){

        return new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("High order was invoked");
                String aa = a;
                String bb = b;
                if(transform != null){
                    aa = transform.apply(a);
                    bb = transform.apply(b);
                }
                return aa + bb;
            }
        };
    }
}
