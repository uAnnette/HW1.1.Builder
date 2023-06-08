package org.example;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age = -1;
    protected String address = null;

    public PersonBuilder setName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Не указано имя");
        } else {
            this.name = name;
        }
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (surname.isEmpty()) {
            throw new IllegalArgumentException("Не указана фамилия");
        } else {
            this.surname = surname;
        }
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < -1) {
            throw new IllegalArgumentException("Неправильно введен возраст");
        } else {
            this.age = age;
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Не указаны имя или фамилия");
        }
        Person person;
        if (age == -1) {
            person = new Person(name, surname);
        } else {
            person = new Person(name, surname, age);
        }
        person.setAddress(address);
        return person;
    }
}
