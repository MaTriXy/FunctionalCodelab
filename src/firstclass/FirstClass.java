package firstclass;

import java.util.function.Function;

public class FirstClass {

    public static void main(String[] args){
        BiFunction<String, String, String> f1 = (s, t) -> s + t;
        TriFunction<String, String, Function<String, String>, String> f2;

        System.out.println(f1.apply("Good", " Morning"));
        System.out.println("--------------------- Store function into variable ---------------------");

        f1 = FirstClass::concatString;
        System.out.println(f1.apply("Static", " Method"));

        FirstClass instance  = new FirstClass();

        f1 = instance::concatPublic;
        System.out.println(f1.apply("Instance ", " Invoke"));

        BiFunction<String, String, Boolean> contains = instance::contains;

        System.out.println("ABCDEFG contains CDE " + contains.apply("CDE", "ABCDEFG"));


        System.out.println("------------------- Pass function as argument --------------------");
        Function<String, String> transformToLower = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toLowerCase();
            }
        };

        f2 = instance::concatAndTransform;

        System.out.println(f2.apply("Good ", "Evening", transformToLower));
    }

    private static String concatString(String u, String t){
        return u + t;
    }

    public String concatPublic(String u, String t){
        return u + t;
    }

    public boolean contains(String needle, String haystack){
       return haystack.contains(needle);
    }



    public String concatAndTransform(String u, String t, Function<String, String> transform){
        if(transform != null){
            u = transform.apply(u);
            t = transform.apply(t);
        }
        return u + t;
    }



}
