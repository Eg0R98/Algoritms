package com.stulikov.different;

import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Group group1 = new Group(Arrays.asList(
                new Person("Вова", 16L),
                new Person("Никита", 18L),
                new Person("Лёша", 22L)));

        Group group2 = new Group(Arrays.asList(
                new Person("Саша", 14L),
                new Person("Аня", 20L),
                new Person("Дима", 60L)));

        System.out.println(adultPersons(List.of(group1, group2)));

//        throw new UnsupportedOperationException("Implemented it!");
    }

    /**
     * Возвращает всех людей старше 18 лет.
     *
     * @param groups список групп людей
     * @return список людей старше 18 лет
     */
    public static List<Person> adultPersons(List<Group> groups) {

        return groups.stream().flatMap(group -> group.people().stream()).filter(person -> person.age > 18).toList();

//        throw new UnsupportedOperationException("Implemented it!");
    }


    static class Person {

        private final String name;
        private final Long age;

        public Person(String name, Long age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    static class Group {
        private final List<Person> people;

        public Group(List<Person> people) {
            this.people = people;
        }

        public List<Person> people() {
            return people;
        }

        @Override
        public String toString() {
            return "Group{" +
                    "people=" + people +
                    '}';
        }
    }
}
