package guru.springframework.netfluxexample;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Created by jt on 10/12/17.
 */
public class FunctionalProgrammingExamples {
    /* 4 properties of a function
     * 1. name
     * 2. return type
     * 3. parameter list
     * 4. body
     */

    @Test
    public void functionWith4Things() throws Exception {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() { //method
                System.out.println(" In thread t1"); //body
            }
        });

        t1.start();

        System.out.println("In Main Test");
    }

    @Test
    public void lambdaExpression() throws Exception {

        /*
         //lambda expression
        // (parameter list) -> body
             * 1. name - anonymous
     * 2. return type - can be inferred
     * 3. parameter list
     * 4. body
         */
        Thread t1 = new Thread(() -> System.out.println("Silence of the Lambdas"));
        // ^ Constructor is a higher order function,
        // function is a first class citizen

        t1.start();

        System.out.println("In Main Test");
    }

    @Test
    public void listIteratorHighCeremony() throws Exception {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        for (int i = 0; i < dogs.size(); i++) {
            System.out.println(dogs.get(i));
        }

        //very complex, requires a lot of knowledge of code, a lot to go wrong
    }

    @Test
    public void listIteratorLessCeremonyExternalIter() throws Exception {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        for (String doggy : dogs) {
            System.out.println(doggy);
        }
        //simpler, still using external iterator
    }

    @Test
    public void listInternalIterConsumer() throws Exception {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

    @Test
    public void listInternalIterLambdaMethod() throws Exception {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.forEach((String s) -> System.out.println(s));
    }

    @Test
    public void listInternalIterLambdaMethodTypeInference() throws Exception {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        dogs.forEach((s) -> System.out.println(s)); //inferred by compiler
    }

    @Test
    public void listInternalIterLambdaMethodTypeInferenceJustOne() throws Exception {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        //drop () if we have one, still need for none or more than one parameter
        dogs.forEach(s -> System.out.println(s)); //inferred by compiler
    }

    @Test
    public void listInternalIterLambdaMethodTypeJava8MethodRef() throws Exception {
        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        //Java 8 Method Ref
        dogs.forEach(System.out::println);

    }

    @Test
    public void countDogsWithSixCharactersImp() throws Exception {
        /*
        Get count of dogs with 6 characters in name
         */

        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        int dogCount = 0;

        for (String dog : dogs) { //external iterator
            if (dog.length() == 6) {
                dogCount++; //note dogCount is mutating
            }
        }

        System.out.println(dogCount);
    }

    @Test
    public void countDogsWithEightCharactersDec() throws Exception {
        /*
        Get count of dogs with 6 characters in name
         */

        List<String> dogs = Arrays.asList("Vizsla", "Lab", "Golden", "GSP", "Poodle", "Yorkie", "Mutt");

        //no mutability
        System.out.println(dogs.stream() //like iterator Java 8 Streams
                .filter(dog -> dog.length() == 6) //filter condition
                .collect(Collectors.toList()) //collect to list
                .size()); //return size
    }
}
