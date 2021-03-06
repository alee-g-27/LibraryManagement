package LM;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static LM.UserJSONModifier.*;

public class Main {

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

                    System.out.println("————————————————————————————————————————————————————");
                    System.out.println("                                                     ");
                    System.out.println("                Gestione Biblioteca");
                    System.out.println("                                                     ");
                    System.out.println("————————————————————————————————————————————————————");
                    System.out.println("\n1. Accesso Admin\n" +
                            "2. Accesso Utente Registrato\n" +
                            "3. Crea Account\n" +
                            "4. Visualizza Libri\n" +
                            "\n5. Uscita\n");
                    System.out.println("————————————————————————————————————————————————————");
                    System.out.println("\nSelezionare un numero: ");
                    scelta = input.nextInt();

                } catch (InputMismatchException ime) {

                    System.out.println("\nErrore! \nInserire un numero da 1 a 5\n");
                    input.nextLine();
                    errore = true;

                }

            }

            switch (scelta) {

                case 1:

                    //REGISTRATIZIONE UTENTE ADMIN
                    System.out.println("————————————————————————————————————————————————————");
                    System.out.println("                                                     ");
                    System.out.println("                  Accesso Admin");
                    System.out.println("                                                     ");
                    System.out.println("————————————————————————————————————————————————————");

                    System.out.println("\nInserire username: ");
                    String username = input.next();
                    System.out.println("Inserire password: ");
                    String password = input.next();

                    UserJSONModifier.VerificaCredenziali(username, password, "admin");

                    boolean exit1 = false;

                    if (UserJSONModifier.userReader(username, password, "admin")) {

                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        Admin admin = new Admin(username, password);

                        System.out.println("————————————————————————————————————————————————————");
                        System.out.println("                                                     ");
                        System.out.println("                Benvenuto " + admin.getNome() + "!");
                        System.out.println("                                                     ");
                        System.out.println("————————————————————————————————————————————————————");

                        do {

                            boolean errore1 = true;
                            int sceltaAdmin = 0;

                            while (errore1) {
                                try {
                                    errore1 = false;
                                    System.out.println("\n1. Elimina account\n" +
                                            "2. Modifica catalogo\n" +
                                            "3. Visualizza libri\n" +
                                            "4. Gestisci notifiche\n" +
                                            "\n5. Logout Admin");

                                    System.out.println("\nSelezionare un'opzione: ");
                                    sceltaAdmin = input.nextInt();

                                } catch (InputMismatchException ime) {
                                    System.out.println("\nErrore! \nInserire un numero da 1 a 5\n");
                                    input.nextLine();
                                    errore1 = true;
                                }
                            }

                            switch (sceltaAdmin) {
                                case 1:
                                    visualizzaUtenti();
                                    System.out.println("\nEliminazione account\n");
                                    System.out.println("Inserire il nome utente da eliminare: ");
                                    String usernamedaEliminare = input.next();
                                    eliminaUtente(usernamedaEliminare);

                                    break;

                                case 2:

                                    boolean back3 = false;

                                    do {

                                        boolean errore5 = true;
                                        int sceltaModifica = 0;

                                        while(errore5){
                                            //MODIFICA CATALOGO
                                            try {
                                                errore5 = false;
                                                System.out.println("\nModifica catalogo\n");
                                                System.out.println("\n1. Aggiungi libro\n" +
                                                        "2. Elimina libro\n" +
                                                        "3. Modifica libro\n" +
                                                        "\n4. Torna Indietro\n");
                                                System.out.println("\nSelezionare un'opzione: \n");
                                                sceltaModifica = input.nextInt();
                                            } catch (InputMismatchException ime) {
                                                System.out.println("\nErrore! \nInserire un numero da 1 a 4\n");
                                                input.nextLine();
                                                errore5 = true;
                                            }
                                        }

                                        switch (sceltaModifica) {

                                            case 1:

                                                //INSERIMENTO LIBRO
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

                                                Libro libro = new Libro(titolo, autore, numeroPagine, casaEditrice, annoUscita, lingua, numeroCopie, isbn, codiceDewey);

                                                BookJSONModifier.creaLibro(libro);

                                                break;

                                            case 2:

                                                //ELIMINAZIONE LIBRO
                                                System.out.println("\nEliminazione libro\n");
                                                BookJSONModifier.visualizzaLibri();
                                                System.out.println("Inserire l'ID del libro da eliminare: ");
                                                int idLibroEliminare = input.nextInt();

                                                BookJSONModifier.eliminaLibro(idLibroEliminare);

                                                break;

                                            case 3:

                                                //MODIFICA LIBRO
                                                System.out.println("\nModifica Libro\n");
                                                BookJSONModifier.visualizzaLibri();
                                                System.out.println("Inserire l'ID del libro da modificare: ");
                                                int idLibroModificare = input.nextInt();

                                                break;
                                            case 4:
                                                //INDIETRO
                                                back3 = true;
                                                break;

                                        }
                                    }while(!back3);

                                    break;

                                case 3:

                                    //VISUALIZZA LIBRI
                                    System.out.println("————————————————————————————————————————————————————");
                                    System.out.println("                                                     ");
                                    System.out.println("                 Visualizza Libri                    ");
                                    System.out.println("                                                     ");
                                    System.out.println("————————————————————————————————————————————————————");

                                    BookJSONModifier.visualizzaLibri();

                                    System.out.println("\nVuoi visualizzare un libro specifico? (1) si (2) no");
                                    int sceltaVisualizzaLibro = input.nextInt();

                                    if(sceltaVisualizzaLibro == 1){

                                        System.out.println("\nInserire l'ID del libro da visualizzare: ");
                                        int idLibroVisualizzare = input.nextInt();

                                        BookJSONModifier.visualizzaLibro(idLibroVisualizzare-1);

                                    }else if(sceltaVisualizzaLibro == 2){

                                        System.out.println("\n\n");

                                    }
                                    break;
                                case 4:
                                    //GESTIONE NOTIFICHE

                                    boolean back2 = false;
                                    do {

                                        int sceltaNotifiche2 = 0;
                                        boolean errore4 = true;

                                        while(errore4) {
                                            try {
                                                errore4 = false;
                                                System.out.println("\nGestione notifiche\n");
                                                System.out.println("1. Visualizza notifiche" +
                                                        "\n2. Invia notifica" +
                                                        "\n3. Elimina notifica" +
                                                        "\n4. Torna indietro");
                                                sceltaNotifiche2 = input.nextInt();
                                            }catch (InputMismatchException ime) {
                                                System.out.println("\nErrore! \nInserire un numero da 1 a 4\n");
                                                input.nextLine();
                                                errore4 = true;
                                            }
                                        }

                                        switch (sceltaNotifiche2) {
                                            case 1:
                                                //VISUALIZZAZIONE NOTIFICHE
                                                System.out.println("————————————————————————————————————————————————————");
                                                System.out.println("                                                     ");
                                                System.out.println("               Visualizza Richieste                ");
                                                System.out.println("                                                     ");
                                                System.out.println("————————————————————————————————————————————————————");

                                                RequestJSONModifier.visualizzaRichiesteAll();


                                                break;

                                            case 2:
                                                //INVIO NOTIFICA
                                                System.out.println("————————————————————————————————————————————————————");
                                                System.out.println("                                                     ");
                                                System.out.println("                Rispondi Risposta                    ");
                                                System.out.println("                                                     ");
                                                System.out.println("————————————————————————————————————————————————————");

                                                RequestJSONModifier.visualizzaRichiesteAll();

                                                System.out.println("Inserire l'ID della richiesta: ");
                                                int idRichiesta = input.nextInt();

                                                System.out.println("Inserire il messaggio da inserire nella risposta: ");
                                                String messaggio = input.next();

                                                RequestJSONModifier.InviaRispostaAdmin(messaggio, idRichiesta);

                                                break;

                                            case 3:
                                                //ELIMINAZIONE NOTIFICA
                                                break;
                                            case 4:
                                                //INDIETRO
                                                back2 = true;
                                                break;
                                        }
                                    }while(!back2);

                                    break;
                                case 5:
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

                    UserJSONModifier.VerificaCredenziali(usernameUtenteReg, passwordUtenteReg, "utente");

                    boolean exit2 = false;

                    if (UserJSONModifier.userReader(usernameUtenteReg, passwordUtenteReg, "utente")) {

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
                                    System.out.println("1. Gestione Notifiche\n" +
                                            "2. Visualizza libri\n" +
                                            "3. Cambia credenziali\n" +
                                            "\n4. Logout\n");

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

                                    boolean back = false;

                                    do {

                                        int sceltaNotifiche = 0;
                                        boolean errore3 = true;

                                        while (errore3) {
                                            try {
                                                //GESTIONE NOTIFICHE
                                                errore3 = false;
                                                System.out.println("\nGestione notifiche\n");
                                                System.out.println("1. Visualizza notifiche" +
                                                        "\n2. Invia notifica" +
                                                        "\n3. Elimina notifica" +
                                                        "\n4. Visualizza risposte\n" +
                                                        "\n5. Torna indietro");
                                                sceltaNotifiche = input.nextInt();

                                            } catch (InputMismatchException ime) {
                                                System.out.println("\nErrore! \nInserire un numero da 1 a 4\n");
                                                input.nextLine();
                                                errore3 = true;
                                            }
                                        }

                                        switch (sceltaNotifiche) {
                                            case 1:
                                                //VISUALIZZAZIONE NOTIFICHE
                                                System.out.println("————————————————————————————————————————————————————");
                                                System.out.println("                                                     ");
                                                System.out.println("               Visualizza Richieste                ");
                                                System.out.println("                                                     ");
                                                System.out.println("————————————————————————————————————————————————————");

                                                String[] richieste = RequestJSONModifier.visualizzaRichiesteUtente(utenteRegistrato.getNome());
                                                long[] idRichieste = RequestJSONModifier.visualizzaIDRichieste(utenteRegistrato.getNome());

                                                for (int i = 0; i < richieste.length; i++) {
                                                    int idRichiesta = i+1;
                                                    System.out.println("Richiesta #" + idRichieste[i] + "➤" + richieste[i]);
                                                }


                                                break;

                                            case 2:

                                                //INVIO NOTIFICA
                                                System.out.println("————————————————————————————————————————————————————");
                                                System.out.println("                                                     ");
                                                System.out.println("                  Invia Richiesta                    ");
                                                System.out.println("                                                     ");
                                                System.out.println("————————————————————————————————————————————————————");

                                                System.out.println("Inserire il messaggio da inserire nella richiesta: ");
                                                input.nextLine();
                                                String messaggio = input.nextLine();

                                                RequestJSONModifier.InviaRichiestaCommUser(messaggio, utenteRegistrato.getNome());

                                                break;

                                            case 3:

                                                //ELIMINAZIONE NOTIFICA
                                                String[] richiesteElim = RequestJSONModifier.visualizzaRichiesteUtente(utenteRegistrato.getNome());
                                                long[] idRichiesteElim = RequestJSONModifier.visualizzaIDRichieste(utenteRegistrato.getNome());

                                                for (int i = 0; i < richiesteElim.length; i++) {
                                                    int idRichiesta = i+1;
                                                    System.out.println("Richiesta #" + idRichiesteElim[i] + "➤" + richiesteElim[i]);
                                                }

                                                System.out.println("Inserire l'ID della richiesta da eliminare: ");
                                                int idRichiestaElim = input.nextInt();

                                                RequestJSONModifier.eliminaRichiesta(idRichiestaElim);

                                                break;

                                            case 4:

                                                //VISUALIZZAZIONE RISPOSTE
                                                System.out.println("————————————————————————————————————————————————————");
                                                System.out.println("                                                     ");
                                                System.out.println("               Visualizza Risposte                  ");
                                                System.out.println("                                                     ");
                                                System.out.println("————————————————————————————————————————————————————");

                                                String[] risposte = RequestJSONModifier.visualizzaRisposteUtente(utenteRegistrato.getNome());
                                                long[] idRisposte = RequestJSONModifier.visualizzaIDRisposte(utenteRegistrato.getNome());

                                                for (int i = 0; i < risposte.length; i++) {
                                                    int idRisposta = i+1;
                                                    System.out.println("Risposta alla Richiesta #" + idRisposte[i] + " ➤ " + risposte[i]);
                                                }

                                                break;

                                            case 5:

                                                //TORNA INDIETRO
                                                back = true;
                                                break;
                                        }
                                    }while(!back);
                                    break;

                                case 2:

                                    //VISUALIZZA LIBRI
                                    System.out.println("————————————————————————————————————————————————————");
                                    System.out.println("                                                     ");
                                    System.out.println("                 Visualizza Libri                    ");
                                    System.out.println("                                                     ");
                                    System.out.println("————————————————————————————————————————————————————");
                                    BookJSONModifier.visualizzaLibri();

                                    System.out.println("Vuoi visualizzare un libro? (1) si (2) no");
                                    int sceltaVisualizzaLibro = input.nextInt();

                                    if(sceltaVisualizzaLibro == 1){

                                        System.out.println("Inserire l'ID del libro da visualizzare: ");
                                        int idLibroVisualizzare = input.nextInt();
                                        BookJSONModifier.visualizzaLibro(idLibroVisualizzare);

                                    }else if(sceltaVisualizzaLibro == 2){

                                        System.out.println("\n\n");

                                    }

                                    break;

                                case 3:

                                    exit2 = true;
                                    System.out.println("Cambio Credenziali");
                                    System.out.println("1. Cambia nome ");
                                    System.out.println("2. Cambia password ");
                                    System.out.println("3. Torna indietro");

                                    int sceltaCredenziali = input.nextInt();

                                    switch(sceltaCredenziali){
                                        case 1:

                                            System.out.println("Inserire il nuovo nome utente: ");
                                            String newNome = input.next();
                                            cambiaNomeUtente(utenteRegistrato.getNome(), newNome);

                                            break;
                                        case 2:

                                            System.out.println("Inserire la nuova password: ");
                                            String newPsw = input.next();
                                            cambiaPassword(utenteRegistrato.getNome(), newPsw);

                                            break;
                                        case 3:
                                            break;
                                    }

                                    break;

                                case 4:
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

                    UserJSONModifier.creaUtente(username2, password2, "utente");

                    break;

                case 4:
                    //VISUALIZZA LIBRI
                    System.out.println("————————————————————————————————————————————————————");
                    System.out.println("                                                     ");
                    System.out.println("                 Visualizza Libri                    ");
                    System.out.println("                                                     ");
                    System.out.println("————————————————————————————————————————————————————");
                    BookJSONModifier.visualizzaLibri();

                    System.out.println("Vuoi visualizzare un libro? (1) si (2) no");
                    int sceltaVisualizzaLibro = input.nextInt();

                    if(sceltaVisualizzaLibro == 1){

                        System.out.println("Inserire l'ID del libro da visualizzare: ");
                        int idLibroVisualizzare = input.nextInt();
                        BookJSONModifier.visualizzaLibro(idLibroVisualizzare);

                    }else if(sceltaVisualizzaLibro == 2){

                        System.out.println("\n\n");

                    }
                    break;
                case 5:
                    //USCITA
                    exit = true;
                    System.out.println("Uscita...");
                    break;
                default:

                    if (scelta >= 6) {

                        System.out.println("\nScelta non valida\n");

                    }

                    break;

            }

        }while(!exit);

    }

}
