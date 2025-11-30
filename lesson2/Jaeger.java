public class Jaeger {
    private String modelName;
    private String mark;
    private String origin;
    private float weight;
    private float height;
    private int strength;
    private int armor;
    private int speed;

    public Jaeger() {
    }

    public Jaeger(String modelName, String mark, String origin, float weight,
            float height, int strength, int armor, int speed) {
        this.modelName = modelName;
        this.mark = mark;
        this.origin = origin;
        this.weight = weight;
        this.height = height;
        this.strength = strength;
        this.armor = armor;
        this.speed = speed;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Название модели - " + modelName +
                "\n" + "Марка - " + mark +
                "\n" + "Происхождение - " + origin +
                "\n" + "Вес - " + weight + " тонн" +
                "\n" + "Рост - " + height + " метров" +
                "\n" + "Сила - " + strength +
                "\n" + "Броня - " + armor +
                "\n" + "Скорость - " + speed;
    }

    public void useRetractileSword() {
        System.out.println("Меч активирован");
    }

    public void move() {
        System.out.println("Двигаюсь");
    }
}