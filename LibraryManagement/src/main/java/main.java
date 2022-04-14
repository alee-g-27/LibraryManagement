import LM.Libro;

public class main {

    public static void main(String[] args) {

        Libro lib1 = new Libro("CIAO", 10, "MIAMAMMA",
                    2020, "ITALIANO", 10, "IFBG916IH",
                    100);

        Libro lib2 = new Libro("CIAO", 10, "MIAMAMMA",
                2020, "ITALIANO", 10, "IFBG916IH",
                100);

        Libro lib3 = new Libro("CIAO", 10, "MIAMAMMA",
                2020, "ITALIANO", 10, "IFBG916IH",
                100);

        Libro lib4 = new Libro("CIAO", 10, "MIAMAMMA",
                2020, "ITALIANO", 10, "IFBG916IH",
                100);

        System.out.println(lib1.toString());
        System.out.println(lib2.toString() + "\n");
        System.out.println(lib3.toString() + "\n");
        System.out.println(lib4.toString() + "\n");

    }
}
