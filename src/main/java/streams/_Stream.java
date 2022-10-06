package streams;



import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static streams._Stream.Gender.FEMALE;
import static streams._Stream.Gender.MALE;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Hayk", MALE),
                new Person("Alex", MALE),
                new Person("Hovhannes",MALE),
                new Person("Ani", FEMALE)
        );

         people.stream()
                .map(person -> person.name)
                 .mapToInt(String::length)
                 .forEach(System.out::println);

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> FEMALE.equals(person.gender));


        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

        boolean containsAnyMatchFemales = people.stream()
                        .noneMatch(personPredicate);

        System.out.println("any match " + containsAnyMatchFemales);

        System.out.println(containsOnlyFemales);

        // imperative
        System.out.println("-----------------------");

        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }

        // declarative way
        System.out.println("------------------------");
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}


