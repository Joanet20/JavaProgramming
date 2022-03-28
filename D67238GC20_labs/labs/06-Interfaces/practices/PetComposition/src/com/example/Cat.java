package com.example;

public class Cat extends Animal implements Pet {

    private Nameable nameable = new NameableImpl();
    private Ambulatory ambulatory;
    
    private String name;
    
    public Cat() {
        this("Fluffy");
    }
    
    public Cat(String name) {
        super(4);
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println("Cats like to eat spiders and fish.");
    }

    public String getName(){
        return nameable.getName();
    }

    public void setName(String name){
        this.nameable = nameable;
    }

    @Override
    public void play() {
        System.out.println(name + " likes to play with string.");
    }


    public void walk(){
        ambulatory = new AmbulatoryImpl(4);
    }
    
}