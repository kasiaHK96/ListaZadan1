package zadania;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLData;
import java.sql.Statement;
import java.sql.ResultSet;

public class MyApplication {

    public static void main(String[] args) throws SQLException {

        boolean czyWykonane = false;


        List<Zadanie> taskList = new ArrayList<Zadanie>();

        taskList.add(new Zadanie("Sprzątanie", false));
        taskList.add(new Zadanie("Zakupy", false));
        taskList.add(new Zadanie("Gotowanie", false));
        taskList.add(new Zadanie("Ćwiczenia", false));
        taskList.add(new Zadanie("Spacer", false));
        taskList.add(new Zadanie("Jazda na rowerze", false));
        taskList.add(new Zadanie("Spotkanie z przyjaciółmi", false));

        System.out.println("Aktualna lista zadań do wyboru:");

        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + "." + taskList.get(i));
        }

        System.out.println("Dodaj nowe zadanie:");

        Scanner scanner = new Scanner(System.in);
        String opisNowegoZadania = scanner.nextLine();
        taskList.add(new Zadanie(opisNowegoZadania, false));

        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + "." + taskList.get(i));
        }

        System.out.println("Lista zadań została zaaktualizowana.");

        String url = "jdbc:postgresql://localhost:5432/Plan Tygodnia";
        String user = "postgres";
        String password = "Borys2014";

        Connection connection = null;

        try {
            Connection Connection = DriverManager.getConnection(url, user, password);
            System.out.println("Połączono");

            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Podaj nazwę zadania.");
            String opisZadania = scanner.nextLine();


            System.out.println("Czy zadanie jest wykonane? T/N");
            String wykonane = scanner.nextLine();

            if (wykonane.equalsIgnoreCase("T")) {
                czyWykonane = true;
            } else if (wykonane.equalsIgnoreCase("N")) {
                czyWykonane = false;
            } else {
                System.out.println("Błędna wartość. Ustawiono jako niewykonane.");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Podaj dzień tygodnia, do którego chcesz dodać zadanie:");

        int wybor = scanner.nextInt();

        switch (wybor) {
            case 1:
                DzienTygodnia wybranyDzien1 = zadania.DzienTygodnia.PONIEDZIALEK;
                System.out.println("Wybrany dzień to:" + wybranyDzien1);
                break;
            case 2:
                DzienTygodnia wybranyDzien2 = zadania.DzienTygodnia.WTOREK;
                System.out.println("Wybrany dzień to:" + wybranyDzien2);
                break;
            case 3:
                DzienTygodnia wybranyDzien3 = zadania.DzienTygodnia.SRODA;
                System.out.println("Wybrany dzień to:" + wybranyDzien3);
                break;
            case 4:
                DzienTygodnia wybranyDzien4 = DzienTygodnia.CZWARTEK;
                System.out.println("Wybrany dzień to:" + wybranyDzien4);
                break;
            case 5:
                DzienTygodnia wybranyDzien5 = DzienTygodnia.PIATEK;
                System.out.println("Wybrany dzień to:" + wybranyDzien5);
                break;
            case 6:
                DzienTygodnia wybranyDzien6 = DzienTygodnia.SOBOTA;
                System.out.println("Wybrany dzień to:" + wybranyDzien6);
                break;
            case 7:
                DzienTygodnia wybranyDzien7 = DzienTygodnia.NIEDZIELA;
                System.out.println("Wybrany dzień to:" + wybranyDzien7);
                break;
            default:
                System.out.println("Błędny wybór. Nie dodano zadania.");
                scanner.close();
                return;
        }

        String insertQuery = "INSERT INTO Plan Tygodnia WHERE poniedziałek || wtorek || Środa || czwartek || piątek = wybor" + wybor;
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, wybor);
            preparedStatement.executeUpdate();
            System.out.println("Dodano zadanie do bazy danych.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT * FROM Plan Tygodnia";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println(query);
    }
}