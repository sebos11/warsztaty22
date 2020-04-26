package pl.coderslab.app;

import pl.coderslab.dao.UserDao;
import pl.coderslab.models.User;

import java.util.Scanner;

public class manageUsers {
    public static void main(String[] args) {
        boolean end = false;
        while (!end) {
            System.out.println("Zarządzaj użytkownikami - wybierz odpowiednią liczbę aby:");
            System.out.print("[1 - dodać]  ");
            System.out.print("[2 - edytować]  ");
            System.out.print("[3 - usunąć użytkownika]  ");
            System.out.print("[4 - ZAKOŃCZYĆ] >>> ");

            int userAnswer = wczytajLiczbe();

            switch (userAnswer) {
                case 1: {
                    System.out.println("DODAWANIE UŻYTKOWNIKA");

                    break;
                }
                 case 2: {
                     System.out.println("EDYCJA UŻYTKOWNIKA");

                   break;
                 }
                case 3:
                    System.out.println("USUWANIE UŻYTKOWNIKA");
                    listUsers();
                    System.out.println("Podaj id użytkownika którego chcesz usunąć >>>> ");
                    int id = wczytajLiczbe();
                    UserDao userDao = new UserDao();
                    userDao.delete(id);
                    System.out.println("Usunięto użytkownika o id = " + id);
                    listUsers();
                    break;
                case 4:
                    end = true;
                    System.out.println("Koniec programu");
                    break;
                default: {
                    System.out.println("Wybierz właściwą opcję");
                }

            }
        }
    }

    public static int wczytajLiczbe(){
        Scanner wczytaj = new Scanner(System.in);
        while (!wczytaj.hasNextInt()){
            System.out.println("musisz podac liczbe");
            wczytaj.next();
        }
        return wczytaj.nextInt();
    }
    public static void listUsers(){
        UserDao userDao = new UserDao();

        User[] users = userDao.findAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }


}

