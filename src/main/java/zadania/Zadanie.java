package zadania;

public class Zadanie {

    private String opisZadania;
    private boolean czyWykonane;

    public Zadanie(String opisZadania, boolean wykonane) {
        this.opisZadania = opisZadania;
        this.czyWykonane = false;;
    }

    public static void oznaczJakoWykonane(int numerZadania) {
    }

    public String getOpisZadania() {

        return opisZadania;
    }

    public boolean CzyWykonane() {

        return czyWykonane;
    }

    public void oznaczJakoWykonane() {

        this.czyWykonane = true;
    }

    @Override
    public String toString() {

        return opisZadania + " - Wykonane: " + czyWykonane;
    }


}