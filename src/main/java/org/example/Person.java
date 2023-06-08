package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address = null;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAddress(address);
    }

    public boolean hasAge() {
        if (age == -1) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasAddress() {
        if (address == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        } else {
            System.out.println("Нельзя отпраздновать, так как нет данных о возрасте\n");
        }
    }

    @Override
    public String toString() {
        return "\nИнформация: " +
                "\n Имя: " + name +
                "\n Фамилия: " + surname +
                "\n Возраст: " + ((hasAge()) ? age : "не известен") +
                "\n Адрес: " + ((hasAddress()) ? address : "не известен");
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
