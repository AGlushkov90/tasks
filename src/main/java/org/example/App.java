package org.example;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class App
{
    // задача 1 - необходимо пригласить на встречу участников страше 25 лет. метод должен возврашать мапу где key id, value год рождения. вывести на экран даты рождения. people 1
    // задача 2 - удалить дубликаты по id. ответ в виде list. people 2
    // задача 3 - вывести сумму всех id
    // задача 4 - вывести имена всех собак
    public static void main( String[] args )
    {
        List<Person> people1 = List.of(
                new Person(1,"jon",Sex.MALE, LocalDate.of(1994,1, 1), Collections.emptyList()),
                new Person(2,"bob",Sex.MALE,LocalDate.of(1990,1, 1), Collections.emptyList()),
                new Person(3,"Yrick",Sex.MALE,LocalDate.of(1999,1, 1),Collections.emptyList()),
                new Person(4,"Jora",Sex.MALE,LocalDate.of(1998,1, 1),Collections.emptyList()),
                new Person(5,"Nady",Sex.FEMALE,LocalDate.of(1991,1, 1),Collections.emptyList()),
                new Person(6,"Luba",Sex.FEMALE,LocalDate.of(2001,1, 1),Collections.emptyList()),
                new Person(7,"Slava",Sex.MALE,LocalDate.of(2003,1, 1),Collections.emptyList()),
                new Person(8,"Natasha",Sex.FEMALE,LocalDate.of(2002,1, 1),Collections.emptyList())

        );

        List<Person> people2 = List.of(
                new Person(1,"jon",Sex.MALE, LocalDate.of(1994,1, 1), Collections.emptyList()),
                new Person(1,"bob",Sex.MALE,LocalDate.of(1990,1, 1), Collections.emptyList()),
                new Person(3,"Yrick",Sex.MALE,LocalDate.of(1999,1, 1), Collections.emptyList()),
                new Person(4,"Jora",Sex.MALE,LocalDate.of(1998,1, 1), Collections.emptyList()),
                new Person(4,"Nady",Sex.FEMALE,LocalDate.of(1991,1, 1), Collections.emptyList()),
                new Person(6,"Luba",Sex.FEMALE,LocalDate.of(2001,1, 1), Collections.emptyList()),
                new Person(7,"Slava",Sex.MALE,LocalDate.of(2003,1, 1), Collections.emptyList()),
                new Person(8,"Natasha",Sex.FEMALE,LocalDate.of(2002,1, 1), Collections.emptyList())

        );
    }



}

class Person{
    private int id;
    private String name;
    private Sex sex;
    private LocalDate birthday;

    private List<Dog> dogs;

    public Person(int id, String name, Sex sex, LocalDate birthday, List<Dog> dogs) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.dogs = dogs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }


}

enum Sex {
    MALE,
    FEMALE
        }

class Dog {
    private int id;
    private String name;

    public Dog(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

