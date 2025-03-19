package org.examples.az204;

public class Person {
    private String name;

    // Construtor vazio necessário para a desserialização do Jackson
    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}