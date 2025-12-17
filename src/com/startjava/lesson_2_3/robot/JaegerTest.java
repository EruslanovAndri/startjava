package com.startjava.lesson_2_3.robot;

public class JaegerTest {
    public static void main(String[] args) {
        Jaeger gipsyDanger = new Jaeger();
        gipsyDanger.setModelName("Gipsy Danger");
        gipsyDanger.setMark("Mark-3");
        gipsyDanger.setOrigin("United States of America");
        gipsyDanger.setWeight(1.980f);
        gipsyDanger.setHeight(79.25f);
        gipsyDanger.setStrength(8);
        gipsyDanger.setArmor(6);
        gipsyDanger.setSpeed(7);
        System.out.println(gipsyDanger.toString());
        gipsyDanger.useRetractileSword();
        gipsyDanger.move();
        Jaeger strikerEureka = new Jaeger("Striker Eureka", "Mark-5", "Australia", 1.850f, 76.2f, 10, 9, 10);
        System.out.println(strikerEureka.toString());
        strikerEureka.useRetractileSword();
        strikerEureka.move();
    }
}