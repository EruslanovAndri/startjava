package com.startjava.lesson_2_3_4.animal;

public class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.setGender("Male");
        wolfOne.setNickname("lex");
        wolfOne.setWeight(45);
        wolfOne.setAge(7);
        wolfOne.setFurColor("Grey");

        System.out.printf("""
                Gender = %s
                Nickname = %s
                Weight = %d
                Age = %d
                Fur color = %s
                """, wolfOne.getGender(), wolfOne.getNickname(),
                wolfOne.getWeight(), wolfOne.getAge(), wolfOne.getFurColor());

        wolfOne.go();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}