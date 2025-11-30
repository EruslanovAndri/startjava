public class JaegerTest {
    public static void main(String[] args) {
        Jaeger jaegerOne = new Jaeger();
        jaegerOne.setModelName("Gipsy Danger");
        jaegerOne.setMark("Mark-3");
        jaegerOne.setOrigin("United States of America");
        jaegerOne.setWeight(1.980f);
        jaegerOne.setHeight(79.25f);
        jaegerOne.setStrength(8);
        jaegerOne.setArmor(6);
        jaegerOne.setSpeed(7);
        System.out.println(jaegerOne.toString());
        jaegerOne.useRetractileSword();
        jaegerOne.move();
        Jaeger jaegerTwo = new Jaeger("Striker Eureka", "Mark-5", "Australia", 1.850f, 76.2f, 10, 9, 10);
        System.out.println(jaegerTwo.toString());
        jaegerTwo.useRetractileSword();
        jaegerTwo.move();
    }
}