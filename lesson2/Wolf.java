public class Wolf {
    String gender;
    String nickname;
    int weight;
    int age;
    String furColor;

    void go() {
        System.out.println("Волк идет");
    }

    void sit() {
        System.out.println("Волк сидит");
    }

    void run() {
        System.out.println("Волк бежит");
    }

    void howl() {
        System.out.println("Волк воет");
    }

    void hunt() {
        System.out.println("Волк охотиться");
    }
}

class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();
        wolfOne.gender = "male";
        wolfOne.nickname = "lex";
        wolfOne.weight = 45;
        wolfOne.age = 8;

        System.out.printf("""
            Gender = %s
            Nickname = %s
            Weight = %d
            Age = %d
            Fur color = %s
                """, wolfOne.gender, wolfOne.nickname, wolfOne.weight, wolfOne.age, wolfOne.furColor);

        wolfOne.go();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}