package streams;

import imperative.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Hayk", Main.Gender.MALE),
                new Person("Alex", Main.Gender.MALE),
                new Person("Hovhannes", Main.Gender.MALE),
                new Person("Ani", Main.Gender.FEMALE)
        );

//         people.stream()
//                .map(person -> person.name)
//                 .mapToInt(String::length)
//                 .forEach(System.out::println);

         people.stream()
                 .allMatch()

        // imperative
        System.out.println("-----------------------");

        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }

        // declarative way
        System.out.println("------------------------");
        people.stream()
                .filter(person -> Main.Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }

    static class Person {
        private final String name;
        private final Main.Gender gender;

        Person(String name, Main.Gender gender) {
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


