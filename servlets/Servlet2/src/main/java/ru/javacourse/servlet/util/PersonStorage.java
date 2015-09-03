package ru.javacourse.servlet.util;

import ru.javacourse.servlet.model.Address;
import ru.javacourse.servlet.model.Person;
import ru.javacourse.servlet.model.Phone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgy Gobozov on 9/3/2015.
 */
public class PersonStorage {


    public static List<Person> getPersons(){

        List<Person> persons = new ArrayList<Person>();
        Person p1 = new Person("Vova", "Ivanov", 20);
        Address a1 = new Address("SPb", "Nevsky 10", 123456);
        Phone p11 = new Phone("cell", "23413452345");
        Phone p12 = new Phone("work", "1111111111");

        p1.setAddress(a1);
        p1.addPhone(p11);
        p1.addPhone(p12);


        Person p2 = new Person("Igor", "Petrov", 27);
        Address a2 = new Address("Moscow", "Lenina 20", 23423412);
        Phone p21 = new Phone("cell", "234234123");
        Phone p22 = new Phone("work", "11333331");

        p2.setAddress(a2);
        p2.addPhone(p21);
        p2.addPhone(p22);

        persons.add(p1);
        persons.add(p2);

        return persons;
    }




}
