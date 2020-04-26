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
                    String text;
                    User user = new User();
                    UserDao userDao = new UserDao();
                    Scanner scan = new Scanner(System.in);
                    System.out.print("podaj nazwę użytkownika: ");
                    text = scan.next();
                    user.setUserName(text);
                    System.out.print("podaj email użytkownika: ");
                    text = scan.next();
                    user.setEmail(text);
                    System.out.print("podaj hasło użytkownika: ");
                    text = scan.next();
                    user.setPassword(text);
                    System.out.print("podaj ID grupy użytkownika: ");
                    int id = wczytajLiczbe();
                    user.setUserGroupId(id);
                    userDao.create(user);
                    listUsers();
                    break;
                }
                 case 2: {
                     Scanner scan = new Scanner(System.in);
                     String tekst;
                     System.out.println("EDYCJA UŻYTKOWNIKA");
                     listUsers();
                     System.out.print("Podaj id użytkownika którego chcesz zmienić >>>> ");
                     int id = wczytajLiczbe();
                     UserDao userDao = new UserDao();
                     User user = userDao.read(id);
                     User user1 = user;
                     System.out.print("Zmień nazwę użytkownika z " +user.getUserName() + "  na  " );
                     tekst = scan.next();
                     user.setUserName(tekst);
                     System.out.print("Zmień email użytkownika z " +user.getEmail() + "  na  " );
                     tekst = scan.next();
                     user.setEmail(tekst);
                     System.out.print("Zmień hasło użytkownika z " +user.getPassword() + "  na  " );
                     tekst = scan.next();
                     user.setPassword(tekst);
                     System.out.print("Zmień ID grupy użytkownika z " +user.getUserGroupId() + "  na  " );
                     int idGroup = wczytajLiczbe();
                     user.setUserGroupId(idGroup);
                     userDao.update(user);
                     System.out.print("Zmieniono dane użytkownika  " + user1.toString() + " na " );
                     System.out.println(user.toString());





                   break;
                 }
                case 3:
                    System.out.println("USUWANIE UŻYTKOWNIKA");
                    listUsers();
                    System.out.print("Podaj id użytkownika którego chcesz usunąć >>>> ");
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

