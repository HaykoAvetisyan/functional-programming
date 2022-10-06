package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class TestValid {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Hayk", "hayk@mail.com", "+374949494", LocalDate.of(1992, 5, 2)
        );

//        CustomerValidatorService customerValidatorService = new CustomerValidatorService();
//        boolean valid = customerValidatorService.isValid(customer);
//
//        System.out.println(valid);

        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }
        //

    }


}
