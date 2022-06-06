package it.iisvittorioveneto.lm;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static it.iisvittorioveneto.lm.BookJSONModifier.modificaLibro;
import static it.iisvittorioveneto.lm.BookJSONModifier.verificaLibriDisponibili;
import static it.iisvittorioveneto.lm.UserJSONModifier.*;
import static it.iisvittorioveneto.lm.printMenu.*;

public class Main {

    public static void main(String[] args) throws IOException, ParseException, InterruptedException {

        Scanner input = new Scanner(System.in);

        boolean exit = false;

        boolean res = false;

        do{

            /*System.out.print("\033[H\033[2J");
            System.out.flush();*/

            System.out.println("\n\n\n");

            int scelta = 0;
            boolean errore = true;

            while (errore) {

                try {

                    errore = false;

                    printMenuMain();

                    System.out.println("\nSelezionare un numero: ");
                    scelta = input.nextInt();

                } catch (InputMismatchException ime) {

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("\nErrore! \nInserire un numero da 1 a 5\n");
                    input.nextLine();

                    errore = true;

                }

            }

            switch (scelta) {

                case 1:

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    printMenuAccessoAdmin();

                    System.out.println("\nInserire username: ");
                    String username = input.next();
                    System.out.println("Inserire password: ");
                    String password = input.next();

                    VerificaCredenziali(username, password, "admin");

                    boolean exit1 = false;

                    if (userReader(username, password, "admin")) {

                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        Admin admin = new Admin(username, password);

                        do {

                            boolean errore1 = true;
                            int sceltaAdmin = 0;

                            while (errore1) {

                                try {

                                    errore1 = false;
                                    printMenuBenvAdmin(admin.getNome());

                                    System.out.println("\nSelezionare un'opzione: ");
                                    sceltaAdmin = input.nextInt();

                                } catch (InputMismatchException ime) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println("\nErrore! \nInserire un numero da 1 a 6\n");
                                    input.nextLine();

                                    errore1 = true;

                                }

                            }

                            switch (sceltaAdmin) {

                                case 1:

                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    printEliminaAccount();

                                    int conferma = 0;
                                    boolean errorConfirm = true;

                                    while (errorConfirm){

                                        try {

                                            errorConfirm = false;

                                            System.out.println("Sei sicuro di voler eliminare un account? \n(1) si (2) no");
                                            conferma = input.nextInt();

                                        }catch (InputMismatchException ime) {

                                            System.out.println("\nErrore! \nInserire 1 o 2\n");
                                            input.nextLine();

                                            errorConfirm = true;

                                        }

                                    }

                                    if (conferma == 1){

                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();

                                        printMenuDeleteAccount();

                                        System.out.println("\nLista utenti: \n");
                                        visualizzaUtenti();

                                        System.out.println("Inserire il nome utente da eliminare: ");
                                        String usernamedaEliminare = input.next();

                                        eliminaUtente(usernamedaEliminare, admin.getNome());

                                    }else if (conferma == 2){

                                        System.out.println("\nOperazione annullata\n");
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();

                                    }

                                    break;

                                case 2:

                                    boolean back3 = false;

                                    do {

                                        boolean errore5 = true;
                                        int sceltaModifica = 0;

                                        while(errore5){

                                            try {

                                                errore5 = false;

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                printMenuModificaCatalogo();

                                                sceltaModifica = input.nextInt();

                                            } catch (InputMismatchException ime) {

                                                System.out.println("\nErrore! \nInserire un numero da 1 a 4\n");
                                                input.nextLine();

                                                errore5 = true;

                                            }

                                        }

                                        switch (sceltaModifica) {

                                            case 1:

                                                int conferma1 = 0;
                                                boolean errorConfirm1 = true;

                                                while (errorConfirm1){

                                                    try {

                                                        errorConfirm1 = false;
                                                        System.out.println("Sei sicuro di voler inserire un nuovo libro? \n(1) si (2) no");
                                                        conferma1 = input.nextInt();

                                                    }catch (InputMismatchException ime) {

                                                        System.out.println("\nErrore! \nInserire 1 o 2\n");
                                                        input.nextLine();

                                                        errorConfirm1 = true;

                                                    }

                                                }

                                                if (conferma1==1){

                                                    System.out.print("\033[H\033[2J");
                                                    System.out.flush();

                                                    printMenuInserimentoLibro();

                                                    System.out.println("\nInserire il titolo del libro: ");
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

                                                }else if (conferma1==2){

                                                    System.out.println("\nOperazione annullata\n");

                                                }

                                                break;

                                            case 2:

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                boolean errorIDlibro = true;
                                                int idLibroEliminare = 0;

                                                while (errorIDlibro) {

                                                    try {

                                                        errorIDlibro = false;

                                                        printMenuEliminaLibro();
                                                        BookJSONModifier.visualizzaLibri();

                                                        System.out.println("\nSe si ha sbagliato la scelta, \ninserire 0 per tornare al menu precedente\n");
                                                        System.out.println("Inserire l'ID del libro da eliminare: ");
                                                        idLibroEliminare = input.nextInt();

                                                    } catch (InputMismatchException ime) {

                                                        System.out.println("\nErrore! \nInserire un numero\n");
                                                        input.nextLine();

                                                        errorIDlibro = true;

                                                    }

                                                }

                                                if (errorIDlibro==false) {

                                                    BookJSONModifier.eliminaLibro(idLibroEliminare);

                                                }

                                                break;

                                            case 3:

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                boolean errorModLibro = true;
                                                int idLibroModificare = 0;

                                                while (errorModLibro) {

                                                    try {

                                                        errorModLibro = false;
                                                        printMenuModificaLibro();

                                                        BookJSONModifier.visualizzaLibri();

                                                        System.out.println("\nSe si ha sbagliato la scelta, \ninserire 0 per tornare al menu precedente\n");
                                                        System.out.println("Inserire l'ID del libro da modificare: ");
                                                        idLibroModificare = input.nextInt();

                                                    }catch (InputMismatchException ime) {

                                                        System.out.println("\nErrore! \nInserire un numero\n");
                                                        input.nextLine();

                                                        errorModLibro = true;

                                                    }
                                                }

                                                if (errorModLibro==false) {

                                                    modificaLibro(idLibroModificare);

                                                }

                                                break;

                                            case 4:

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                back3 = true;
                                                break;

                                        }

                                    }while(!back3);

                                    break;

                                case 3:

                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    printMenuVisualizzaLibri();

                                    BookJSONModifier.visualizzaLibri();
                                    if (verificaLibriDisponibili()){

                                        int sceltaVisualizzaLibro = 0;
                                        boolean errorVisualizzaLibro = true;

                                        while (errorVisualizzaLibro){

                                            try {

                                                errorVisualizzaLibro = false;

                                                System.out.println("Vuoi visualizzare un libro? (1) si (2) no");
                                                sceltaVisualizzaLibro = input.nextInt();

                                            }catch (InputMismatchException ime){

                                                errorVisualizzaLibro = true;

                                                System.out.println("\nErrore! \nInserire i numeri 1 o 2\n");
                                                input.nextLine();

                                            }
                                        }

                                        if(sceltaVisualizzaLibro == 1){

                                            boolean errorIDlibro = true;
                                            int idLibroVisualizzare = 0;

                                            while (errorIDlibro){

                                                try {

                                                    errorIDlibro = false;
                                                    System.out.println("Inserire l'ID del libro da visualizzare: ");
                                                    idLibroVisualizzare = input.nextInt();

                                                    System.out.print("\033[H\033[2J");
                                                    System.out.flush();

                                                }catch (InputMismatchException ime){

                                                    System.out.print("\033[H\033[2J");
                                                    System.out.flush();

                                                    System.out.println("\nErrore! \nInserire un numero, riselezionare l'opzione\n");
                                                    input.nextLine();

                                                }
                                            }

                                            if (errorIDlibro==false) {

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                BookJSONModifier.visualizzaLibro(idLibroVisualizzare);;

                                            }


                                        }else if(sceltaVisualizzaLibro == 2){

                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();

                                            System.out.println("\n\n");

                                        }

                                    }

                                    break;

                                case 4:

                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    boolean back2 = false;

                                    do {

                                        int sceltaNotifiche2 = 0;
                                        boolean errore4 = true;

                                        while(errore4) {

                                            try {

                                                errore4 = false;

                                                printMenuGestioneNotifiche();
                                                sceltaNotifiche2 = input.nextInt();

                                            }catch (InputMismatchException ime) {

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                System.out.println("\nErrore! \nInserire un numero da 1 a 4\n");
                                                input.nextLine();

                                                errore4 = true;

                                            }

                                        }

                                        switch (sceltaNotifiche2) {

                                            case 1:

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                printMenuVisualizzaRichieste();

                                                RequestJSONModifier.visualizzaRisposteAll();

                                                break;

                                            case 2:

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                printMenuInviaRisposta();

                                                RequestJSONModifier.visualizzaRichiesteAll();

                                                if (RequestJSONModifier.checkRisposta(1)){

                                                    System.out.println("\nInserire l'ID della richiesta: ");
                                                    int idRichiesta = input.nextInt();

                                                    System.out.println("Inserire il messaggio da inserire nella risposta: ");
                                                    input.nextLine();
                                                    String messaggio = input.nextLine();

                                                    RequestJSONModifier.InviaRispostaAdmin(messaggio, idRichiesta);

                                                }

                                                break;

                                            case 3:

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                printMenuEliminaNotifica();

                                                printMenuVisualizzaRichieste();

                                                RequestJSONModifier.visualizzaRisposteAll();

                                                if (RequestJSONModifier.checkRisposta(1)){

                                                    System.out.println("\nInserire l'ID della richiesta da eliminare: ");
                                                    int idRichiestaElim = input.nextInt();

                                                    RequestJSONModifier.eliminaRichiestaAdmin(idRichiestaElim);

                                                }

                                                break;

                                            case 4:

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                back2 = true;

                                                break;

                                        }

                                    }while(!back2);

                                    break;

                                case 5:

                                    int sceltaCredenziali = 0;

                                    do{

                                        boolean error5 = true;

                                        while (error5) {

                                            try {

                                                error5 = false;

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                printMenuCambioCredenziali();
                                                sceltaCredenziali = input.nextInt();

                                            }catch (InputMismatchException ime){

                                                error5 = true;

                                                System.out.println("\nErrore! \nInserire un numero da 1 a 3\n");
                                                input.nextLine();

                                            }

                                        }

                                        if (sceltaCredenziali == 1) {

                                            System.out.println("\nInserire il nuovo nome utente: ");
                                            String newNome = input.next();
                                            cambiaNomeUtente(admin.getNome(), newNome);
                                            admin.setNomeUtente(newNome);

                                        }else if (sceltaCredenziali == 2) {

                                            System.out.println("\nInserire il nuovo password: ");
                                            String newPassword = input.next();
                                            cambiaPassword(admin.getNome(), newPassword);
                                            admin.setPassword(newPassword);

                                        }else if (sceltaCredenziali == 3) {

                                            System.out.println("\nOperazione annullata");

                                        }else{

                                            System.out.println("\nErrore! \nInserire un numero da 1 a 3\n");

                                        }

                                    }while (sceltaCredenziali > 3);

                                    break;

                                case 6:

                                    exit1 = true;
                                    System.out.println("Logout...");
                                    System.out.println("\n\n");
                                    System.out.println("\n\n");

                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    break;

                                default:

                                    System.out.println("Opzione non valida!");

                                    break;
                            }

                        }while(!exit1);

                    }

                    break;

                case 2:

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    printMenuAccessoUtenteRegistrato();

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

                        do {

                            int sceltaUtenteReg = 0;
                            boolean errore2 = true;

                            while(errore2) {

                                try {

                                    errore2 = false;

                                    printMenuBenvUtenteReg(utenteRegistrato.getNome());

                                    System.out.println("\nSelezionare un'opzione: ");
                                    sceltaUtenteReg = input.nextInt();

                                } catch (InputMismatchException ime) {

                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println("\nErrore! \nInserire un numero da 1 a 4\n");
                                    input.nextLine();

                                    errore2 = true;

                                }

                            }

                            switch (sceltaUtenteReg) {

                                case 1:

                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    boolean back = false;

                                    do {

                                        int sceltaNotifiche = 0;
                                        boolean errore3 = true;

                                        while (errore3) {

                                            try {

                                                errore3 = false;

                                                printMenuGestNotificheUtenteReg();

                                                sceltaNotifiche = input.nextInt();

                                            } catch (InputMismatchException ime) {

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                System.out.println("\nErrore! \nInserire un numero da 1 a 5\n");
                                                input.nextLine();
                                                errore3 = true;

                                            }
                                        }

                                        switch (sceltaNotifiche) {

                                            case 1:

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                back = false;
                                                printMenuVisualizzaRichieste();

                                                RequestJSONModifier.visualizzaRichiesteUtente(utenteRegistrato.getNome());

                                                break;

                                            case 2:

                                                back = false;

                                                int conferma = 0;
                                                boolean errorConfirm = true;

                                                while (errorConfirm){

                                                    try {

                                                        errorConfirm = false;

                                                        System.out.println("Sei sicuro di voler inviare una notifica? \n(1) si (2) no");
                                                        conferma = input.nextInt();

                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();

                                                    }catch (InputMismatchException ime) {

                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();

                                                        System.out.println("\nErrore! \nInserire 1 o 2\n");
                                                        input.nextLine();

                                                        errorConfirm = true;

                                                    }

                                                }

                                                if (conferma == 1){

                                                    System.out.print("\033[H\033[2J");
                                                    System.out.flush();

                                                    printMenuInviaRichiesta();

                                                    System.out.println("Inserire il messaggio da inserire nella richiesta: ");
                                                    input.nextLine();
                                                    String messaggio = input.nextLine();

                                                    RequestJSONModifier.InviaRichiestaCommUser(messaggio, utenteRegistrato.getNome());

                                                }else if (conferma == 2){

                                                    System.out.print("\033[H\033[2J");
                                                    System.out.flush();

                                                    System.out.println("Operazione annullata");

                                                }

                                                break;

                                            case 3:

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                back = false;

                                                printMenuEliminaNotifica();

                                                RequestJSONModifier.visualizzaRichiesteUtente(utenteRegistrato.getNome());

                                                if (RequestJSONModifier.checkRichiesta(1)){

                                                    System.out.println("Inserire l'ID della richiesta da eliminare: ");
                                                    int idRichiestaElim = input.nextInt();

                                                    RequestJSONModifier.eliminaRichiesta(idRichiestaElim);

                                                }

                                                break;

                                            case 4:

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                back = false;

                                                printMenuVisualizzaRisposte();

                                                RequestJSONModifier.visualizzaRisposte(utenteRegistrato.getNome());

                                                break;

                                            case 5:

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                back = true;

                                                break;

                                        }

                                    } while (!back);

                                    break;

                                case 2:

                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    printMenuVisualizzaLibri();

                                    BookJSONModifier.visualizzaLibri();

                                    if (verificaLibriDisponibili()){

                                        int sceltaVisualizzaLibro = 0;
                                        boolean errorVisualizzaLibro = true;

                                        while (errorVisualizzaLibro){

                                            try {

                                                errorVisualizzaLibro = false;

                                                System.out.println("Vuoi visualizzare un libro? (1) si (2) no");
                                                sceltaVisualizzaLibro = input.nextInt();


                                            }catch (InputMismatchException ime){

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                errorVisualizzaLibro = true;

                                                System.out.println("\nErrore! \nInserire i numeri 1 o 2\n");
                                                input.nextLine();

                                            }

                                        }

                                        if(sceltaVisualizzaLibro == 1){

                                            boolean errorIDlibro = true;
                                            int idLibroVisualizzare = 0;

                                            while (errorIDlibro){

                                                try {

                                                    errorIDlibro = false;

                                                    System.out.println("Inserire l'ID del libro da visualizzare: ");
                                                    idLibroVisualizzare = input.nextInt();

                                                }catch (InputMismatchException ime){

                                                    System.out.print("\033[H\033[2J");
                                                    System.out.flush();

                                                    System.out.println("\nErrore! \nInserire un numero, riselezionare l'opzione\n");
                                                    input.nextLine();

                                                }
                                            }

                                            if (errorIDlibro==false) {

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                BookJSONModifier.visualizzaLibro(idLibroVisualizzare);;

                                            }


                                        }else if(sceltaVisualizzaLibro == 2){

                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();

                                            System.out.println("\n\n");

                                        }
                                    }


                                    break;

                                case 3:

                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    int sceltaCredenziali = 0;

                                    do{

                                        boolean error5 = true;

                                        while (error5) {

                                            try {

                                                error5 = false;

                                                printMenuCambioCredenziali();
                                                sceltaCredenziali = input.nextInt();


                                            }catch (InputMismatchException ime){

                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();

                                                error5 = true;

                                                System.out.println("\nErrore! \nInserire un numero da 1 a 3\n");
                                                input.nextLine();

                                            }

                                        }

                                        if (sceltaCredenziali == 1) {

                                            System.out.println("Inserire il nuovo nome utente: ");
                                            String newNome = input.next();
                                            cambiaNomeUtente(utenteRegistrato.getNome(), newNome);
                                            utenteRegistrato.setNomeUtente(newNome);

                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();

                                        }else if (sceltaCredenziali == 2) {

                                            System.out.println("Inserire il nuovo password: ");
                                            String newPassword = input.next();
                                            cambiaPassword(utenteRegistrato.getNome(), newPassword);
                                            utenteRegistrato.setPassword(newPassword);

                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();

                                        }else if (sceltaCredenziali == 3) {

                                            System.out.println("Operazione annullata");

                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();

                                        }else{

                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();

                                            System.out.println("\nErrore! \nInserire un numero da 1 a 3\n");

                                        }

                                    }while (sceltaCredenziali > 3);

                                    break;

                                case 4:

                                    exit2 = true;
                                    System.out.println("Logout...");

                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    break;

                                default:

                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println("\nScelta non valida\n");

                                    break;
                            }

                        }while(!exit2);

                    }

                    break;

                case 3:

                    //CREAZIONE DEL NUOVO ACCOUNT
                    boolean exit3 = true;
                    int sceltaCreaAccount = 0;

                    while (exit3) {

                        try {

                            exit3 = false;

                            System.out.println("Sei sicuro di voler creare un nuovo account? (1) si (2) no");
                            sceltaCreaAccount = input.nextInt();

                        } catch (InputMismatchException ime) {

                            System.out.print("\033[H\033[2J");
                            System.out.flush();

                            exit3 = true;

                            System.out.println("\nErrore! \nInserire i numeri 1 o 2\n");
                            input.nextLine();


                        }

                    }

                    if (sceltaCreaAccount == 1) {

                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        printMenuCreaAccount();

                        System.out.println("Inserire username: ");
                        String username2 = input.next();

                        System.out.println("Inserire password: ");
                        String password2 = input.next();

                        UserJSONModifier.creaUtente(username2, password2, "utente");

                        Thread.sleep(1500);

                    }else if (sceltaCreaAccount == 2){

                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        System.out.println("Operazione annullata");

                        System.out.println("\n\n");

                    }

                    break;

                case 4:

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    printMenuVisualizzaLibri();

                    BookJSONModifier.visualizzaLibri();
                    if (verificaLibriDisponibili()){

                        int sceltaVisualizzaLibro = 0;
                        boolean errorVisualizzaLibro = true;

                        while (errorVisualizzaLibro){

                            try {

                                errorVisualizzaLibro = false;

                                System.out.println("Vuoi visualizzare un libro? (1) si (2) no");
                                sceltaVisualizzaLibro = input.nextInt();

                            }catch (InputMismatchException ime){

                                errorVisualizzaLibro = true;

                                System.out.println("\nErrore! \nInserire i numeri 1 o 2\n");
                                input.nextLine();

                            }
                        }

                        if(sceltaVisualizzaLibro == 1){

                            boolean errorIDlibro = true;
                            int idLibroVisualizzare = 0;

                            while (errorIDlibro){

                                try {

                                    errorIDlibro = false;
                                    System.out.println("Inserire l'ID del libro da visualizzare: ");
                                    idLibroVisualizzare = input.nextInt();

                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                }catch (InputMismatchException ime){

                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println("\nErrore! \nInserire un numero, riselezionare l'opzione\n");
                                    input.nextLine();

                                }
                            }

                            if (errorIDlibro==false) {

                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                BookJSONModifier.visualizzaLibro(idLibroVisualizzare);;

                            }


                        }else if(sceltaVisualizzaLibro == 2){

                            System.out.print("\033[H\033[2J");
                            System.out.flush();

                            System.out.println("\n\n");

                        }

                    }

                    break;

                case 5:

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    exit = true;

                    System.out.println("Uscita...Buona Giornata");

                    break;

                default:

                    if (scelta >= 6) {

                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        System.out.println("\nScelta non valida\n");

                    }

                    break;

            }

        }while(!exit);

    }

}
