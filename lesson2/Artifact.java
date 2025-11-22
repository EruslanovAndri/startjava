class Artifact {
    int artifactNumber;
    String culture;
    int century;

    public Artifact(int artifactNumber) {
        this.artifactNumber = artifactNumber;
    }

    public Artifact(int artifactNumber, String culture) {
        this.artifactNumber = artifactNumber;
        this.culture = culture;
    }

    public Artifact(int artifactNumber, String culture, int century) {
        this.artifactNumber = artifactNumber;
        this.culture = culture;
        this.century = century;
    }

    public static void main(String[] args) {
        Artifact artifact1 = new Artifact(1234);
        Artifact artifact2 = new Artifact(1234, "Maiya");
        Artifact artifact3 = new Artifact(1234, "Peruan", 14);

        System.out.println(artifact1.artifactNumber);
        System.out.println(artifact2.artifactNumber + artifact2.culture);
        System.out.println(artifact3.artifactNumber + artifact3.culture + artifact3.century);

    }
}