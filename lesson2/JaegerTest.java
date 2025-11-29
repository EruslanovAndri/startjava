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
        System.out.printf("""
                %s
                    Название модели - %s
                    Марка - %s
                    Происхождение - %s
                    Вес - %.3f %s
                    Рост - %.1f %s
                    Сила - %d
                    Броня - %d
                    Скорость - %d 
                """, "Первый робот:", jaegerOne.getModelName(), jaegerOne.getMark(), jaegerOne.getOrigin(),
                jaegerOne.getWeight(), "тонн", jaegerOne.getHeight(), "метров", jaegerOne.getStrength(),
                jaegerOne.getArmor(), jaegerOne.getSpeed());
        jaegerOne.useRetractileSword();
        jaegerOne.move();

        Jaeger jaegerTwo = new Jaeger("Striker Eureka", "Mark-5", "Australia", 1.850f, 76.2f, 10, 9, 10);
        System.out.printf("""
                %s
                    Название модели - %s
                    Марка - %s
                    Происхождение - %s
                    Вес - %.3f %s
                    Рост - %.1f %s
                    Сила - %d
                    Броня - %d
                    Скорость - %d 
                """, "Второй робот:", jaegerTwo.getModelName(), jaegerTwo.getMark(), jaegerTwo.getOrigin(),
                jaegerTwo.getWeight(), "тонн", jaegerTwo.getHeight(), "метров", jaegerTwo.getStrength(),
                jaegerTwo.getArmor(), jaegerTwo.getSpeed());
        jaegerTwo.useRetractileSword();
        jaegerTwo.move();
    }
}