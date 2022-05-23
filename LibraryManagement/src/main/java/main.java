import LM.*;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static LM.JSONModifier.*;

public class main {

    public static void main(String[] args) throws IOException, ParseException {

        Scanner input = new Scanner(System.in);

        boolean exit = false;

        boolean res = false;

        do{

            int scelta = 0;
            boolean errore = true;

            while (errore) {

                try {

                    errore = false;
                    System.out.println("-----------------------------------------------------");
                    System.out.println("                                                     ");
                    System.out.println("                Gestione Biblioteca");
                    System.out.println("                                                     ");
                    System.out.println("-----------------------------------------------------");
                    System.out.println("\n1. Accesso Admin\n" +
                            "2. Accesso Utente Registrato\n" +
                            "3. Crea Account\n" +
                            "4. Uscita\n");
                    System.out.println("-----------------------------------------------------\n");
                    System.out.println("Selezionare un numero: ");
                    scelta = input.nextInt();

                } catch (InputMismatchException ime) {

                    System.out.println("\nErrore! \nInserire un numero da 1 a 4\n");
                    input.nextLine();
                    errore = true;

                }

            }

            switch (scelta) {

                case 1:

                    //ADMIN LOGIN + MENU
                    System.out.println("Accesso Admin\n");

                    System.out.println("Inserire username: ");
                    String username = input.next();
                    System.out.println("Inserire password: ");
                    String password = input.next();

                    Login login = new Login(username, password, "admin");

                    boolean exit1 = false;

                    if (userReader(username, password, "admin")) {

                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        Admin admin = new Admin(username, password);

                        System.out.println("\nBenvenuto " + admin.getNome() + "!\n");

                        do {

                            boolean errore1 = true;
                            int sceltaAdmin = 0;

                            while (errore1) {
                                try {
                                    errore1 = false;
                                    System.out.println("1. Elimina account\n" +
                                            "2. Inserisci libro\n" +
                                            "3. Elimina libro\n" +
                                            "4. Modifica libro\n" +
                                            "5. Visualizza libri\n" +
                                            "6. Logout\n");

                                    System.out.println("Selezionare un'opzione: ");
                                    sceltaAdmin = input.nextInt();

                                } catch (InputMismatchException ime) {
                                    System.out.println("\nErrore! \nInserire un numero da 1 a 6\n");
                                    input.nextLine();
                                    errore1 = true;
                                }
                            }

                            switch (sceltaAdmin) {
                                case 1:

                                    System.out.println("\nEliminazione account\n");
                                    System.out.println("Inserire il nome utente da eliminare: ");
                                    String usernamedaEliminare = input.next();

                                    eliminaUtente(usernamedaEliminare);

                                    break;

                                case 2:

                                    System.out.println("\nInserisci libro\n");

                                    System.out.println("Inserire il titolo del libro: ");
                                    String titolo = input.next();

                                    System.out.println("Inserire l'autore del libro: ");
                                    String autore = input.next();

                                    System.out.println("Inseire il numero delle pagine del libro: ");
                                    int numeroPagine = input.nextInt();

                                    System.out.println("Inserire la casa editrice del libro: ");
                                    String casaEditrice = input.next();

                                    System.out.println("Inserire l'anno di uscita del libro: ");
                                    int annoUscita = input.nextInt();

                                    System.out.println("Inserire la lingua del libro: ");
                                    String lingua = input.next();

                                    System.out.println("Inserire il numero di copie del libro: ");
                                    int numeroCopie = input.nextInt();

                                    System.out.println("Inserire l'ISBN del libro: ");
                                    String isbn = input.next();

                                    System.out.println("Inserire il codice Dewey del libro: ");
                                    int codiceDewey = input.nextInt();

                                    System.out.println("Inserire l'ID del libro: ");
                                    int id = input.nextInt();

                                    Libro libro = new Libro(titolo, autore, numeroPagine, casaEditrice, annoUscita, lingua, numeroCopie, isbn, codiceDewey, id);

                                    creaLibro(libro);

                                    break;

                                case 3:

                                    System.out.println("\nEliminazione libro\n");
                                    System.out.println("Inserire l'ID del libro da eliminare: ");
                                    int idLibroEliminare = input.nextInt();

                                    eliminaLibro(idLibroEliminare);

                                    break;

                                case 4:

                                    System.out.println("\nModifica Libro\n");
                                    System.out.println("Inserire l'ID del libro da modificare: ");
                                    int idLibroModificare = input.nextInt();

                                    eliminaLibro(idLibroModificare);

                                    break;


                                case 5:

                                    System.out.println("\nVisualizza Libri\n");
                                    //admin.visualizzaLibri();
                                    break;

                                case 6:
                                    exit1 = true;
                                    System.out.println("Logout...");
                                    break;
                                default:

                                    System.out.println("Opzione non valida!");

                                    break;
                            }
                        }while(!exit1);

                    }

                break;

                case 2:

                    System.out.println("Registrazione Utente Registrato\n");

                    System.out.println("Inserire username: ");
                    String usernameUtenteReg = input.next();

                    System.out.println("Inserire password: ");
                    String passwordUtenteReg = input.next();

                    Login login1 = new Login(usernameUtenteReg, passwordUtenteReg, "utente");

                    boolean exit2 = false;

                    if (userReader(usernameUtenteReg, passwordUtenteReg, "utente")) {

                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        UtenteRegistrato utenteRegistrato = new UtenteRegistrato(usernameUtenteReg, passwordUtenteReg, "utente");

                        System.out.println("\nBenvenuto " + utenteRegistrato.getNome() + "!\n");

                        do {

                            int sceltaUtenteReg = 0;
                            boolean errore2 = true;

                            while(errore2) {
                                try {
                                    errore2 = false;
                                    System.out.println("1. Invia Richiesta\n" +
                                            "2. Leggi risposte\n" +
                                            "3. Elimina risposte\n" +
                                            "4. Logout\n");

                                    System.out.println("Selezionare un'opzione: ");
                                    sceltaUtenteReg = input.nextInt();

                                } catch (InputMismatchException ime) {
                                    System.out.println("\nErrore! \nInserire un numero da 1 a 4\n");
                                    input.nextLine();
                                    errore2 = true;
                                }
                            }

                            switch (sceltaUtenteReg) {

                                case 1:

                                    System.out.println("\nInserimento Richiesta\n");

                                    System.out.println("Inserire il messaggio: ");

                                    input.nextLine();
                                    String messaggio = input.nextLine();

                                    InviaRichiesta(messaggio, utenteRegistrato.getNome());
                                    break;

                                case 2:

                                    System.out.println("\nLeggi risposte\n");

                                    break;
                                case 3:

                                    System.out.println("\nElimina Risposte\n");

                                    break;

                                case 4:

                                    exit2 = true;
                                    System.out.println("Logout...");
                                    break;
                                default :

                                    System.out.println("\nScelta non valida\n");

                                    break;
                            }
                        }while(!exit2);

                    }

                break;

                case 3:

                    //CREAZIONE DEL NUOVO ACCOUNT
                    System.out.println("Crea il tuo account!\n");

                    System.out.println("Inserire username: ");
                    String username2 = input.next();

                    System.out.println("Inserire password: ");
                    String password2 = input.next();

                    creaUtente(username2, password2, "utente");

                    break;

                case 4:

                    //USCITA
                    exit = true;
                    System.out.println("Uscita...");

                break;

                default:

                    if (scelta >= 5) {

                        System.out.println("\nScelta non valida\n");

                    }

                break;

            }

        }while(!exit);

    }

}
