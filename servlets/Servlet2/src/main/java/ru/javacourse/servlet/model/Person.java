package ru.javacourse.servlet.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Georgy Gobozov on 9/3/2015.
 */
@XmlRootElement
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private Address address;
    private List<Phone> numbers;


    public Person() {
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void addPhone(Phone num){
        if (numbers == null)
            numbers = new ArrayList<Phone>();
        numbers.add(num);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Phone> numbers) {
        this.numbers = numbers;
    }
}
