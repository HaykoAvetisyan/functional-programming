package optianals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Object get = Optional.ofNullable("ada")
                .orElseGet(() -> "default value");

        System.out.println(get);

     //   System.out.println(get);

//        Supplier<IllegalStateException> stateExceptionSupplier = () ->
//                new IllegalStateException("Exception");
//
//        Object value = Optional.ofNullable(null)
//                .orElseThrow(stateExceptionSupplier);

     //   System.out.println(value);

        Optional.ofNullable(null)
                .ifPresentOrElse((e -> System.out.println("Sending email to " + e)),
                        () ->{
                    System.out.println("cannot send email");
                });
    }
}
