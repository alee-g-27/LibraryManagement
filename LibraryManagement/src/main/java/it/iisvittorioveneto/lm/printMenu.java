package it.iisvittorioveneto.lm;

public class printMenu {

    /**
     * Metodo che stampa il menu principale
     */
    public static void printMenuMain() {

        System.out.println("\n════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("                Library Management");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("\n1. Accesso Admin\n" +
                "2. Accesso Utente Registrato\n" +
                "3. Crea Account\n" +
                "4. Visualizza Libri\n" +
                "\n5. Uscita\n");
        System.out.println("════════════════════════════════════════════════════");

    }

    /**
     * Metodo che stampa il menu di accesso dell'admin
     */
    public static void printMenuAccessoAdmin() {

        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("                  Accesso Admin");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");

    }

    /**
     * Metodo che stampa il menu di benvenuto dell'admin
     */
    public static void printMenuBenvAdmin(String nome) {

        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("              Benvenuto " + nome + "!");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");

        System.out.println("\n1. Elimina account\n" +
                "2. Modifica catalogo\n" +
                "3. Visualizza libri\n" +
                "4. Gestisci notifiche\n" +
                "5. Cambia credenziali\n" +
                "\n6. Logout Admin");

        System.out.println("\n════════════════════════════════════════════════════");


    }

    /**
     * Metodo che stampa il menu di elimina account
     */
    public static void printMenuDeleteAccount() {

        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("                  Elimina Account");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");

    }

    /**
     * Metodo che stampa il menu di modifica catalogo
     */
    public static void printMenuModificaCatalogo() {

        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("                Modifica catalogo");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("\n1. Aggiungi libro\n" +
                "2. Elimina libro\n" +
                "3. Modifica libro\n" +
                "\n4. Torna Indietro\n");
        System.out.println("════════════════════════════════════════════════════");

        System.out.println("\nSelezionare un'opzione: ");

    }

    /**
     * Metodo che stampa il menu di inserimento libro
     */
    public static void printMenuInserimentoLibro() {

        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                    ");
        System.out.println("                 Inserisci libro");
        System.out.println("                                                    ");
        System.out.println("════════════════════════════════════════════════════");

    }

    /**
     * Metodo che stampa il menu di elimina libro
     */
    public static void printMenuEliminaLibro() {

        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                    ");
        System.out.println("                Eliminazione libro");
        System.out.println("                                                    ");
        System.out.println("════════════════════════════════════════════════════");

    }

    /**
     * Metodo che stampa il menu di modifica libro
     */
    public static void printMenuModificaLibro() {
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                    ");
        System.out.println("                 Modifica Libro");
        System.out.println("                                                    ");
        System.out.println("════════════════════════════════════════════════════");
    }

    /**
     * Metodo che stampa il menu di visualizzazione libri
     */
    public static void printMenuVisualizzaLibri() {
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                    ");
        System.out.println("                Visualizza Libri");
        System.out.println("                                                    ");
        System.out.println("════════════════════════════════════════════════════");
    }

    /**
     * Metodo che stampa il menu di gestione notifiche
     */
    public static void printMenuGestioneNotifiche() {
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("                 Gestione notifiche");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("\n1. Visualizza notifiche inviate" +
                "\n2. Rispondi notifica" +
                "\n3. Elimina notifica inviata" +
                "\n\n4. Torna indietro\n");
        System.out.println("════════════════════════════════════════════════════");

        System.out.println("\nSelezionare un'opzione: ");
    }

    /**
     * Metodo che stampa il menu di visualizzazione notifiche
     */
    public static void printMenuVisualizzaRichieste() {
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("               Visualizza Richieste                ");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");
    }

    /**
     * Metodo che stampa il menu di invio risposta
     */
    public static void printMenuInviaRisposta() {
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("                Rispondi Risposta                    ");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");
    }

    /**
     * Metodo che stampa il menu di eliminazione notifica
     */
    public static void printMenuEliminaNotifica() {
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("                Elimina Notifica                    ");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");
    }

    /**
     * Metodo che stampa il menu di accesso utente registrato
     */
    public static void printMenuAccessoUtenteRegistrato() {
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("          Registrazione Utente Registrato");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");
    }

    /**
     * Metodo che stampa il menu di benvenuto utente registrato
     */
    public static void printMenuBenvUtenteReg(String nome) {
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("              Benvenuto " + nome + "!");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════\n");
        System.out.println("1. Gestione Notifiche\n" +
                "2. Visualizza libri\n" +
                "3. Cambia credenziali\n" +
                "\n4. Logout\n");
        System.out.println("════════════════════════════════════════════════════\n");

    }

    /**
     * Metodo che stampa il menu gestione notifiche utente registrato
     */
    public static void printMenuGestNotificheUtenteReg(){
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("                 Gestione notifiche");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("\n1. Visualizza notifiche inviate" +
                "\n2. Invia notifica" +
                "\n3. Elimina notifica" +
                "\n4. Visualizza risposte ricevute\n" +
                "\n5. Torna indietro\n");
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("\nSelezionare un'opzione: ");
    }

    /**
     * Metodo che stampa il menu di invio notifica
     */
    public static void printMenuInviaRichiesta(){
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("                  Invia Richiesta                    ");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");
    }

    /**
     * Metodo che stampa il menu di visualizzazione risposte
     */
    public static void printMenuVisualizzaRisposte(){
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("                Visualizza Risposte                    ");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");
    }

    /**
     * Metodo che stampa il menu di cambio credenziali
     */
    public static void printMenuCambioCredenziali(){
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("                  Cambio Credenziali                 ");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");

        System.out.println("\n1. Cambia nome ");
        System.out.println("2. Cambia password \n");
        System.out.println("3. Torna indietro\n");

        System.out.println("════════════════════════════════════════════════════");

        System.out.println("\nSelezionare un'opzione: ");
    }

    /**
     * Metodo che stampa il menu di crea account
     */
    public static void printMenuCreaAccount() {

        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("                Crea il tuo account!");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");

    }

    /**
     * Metodo che stampa il menu di elimina account
     */
    public static void printEliminaAccount() {
        System.out.println("════════════════════════════════════════════════════");
        System.out.println("                                                     ");
        System.out.println("                Elimina Account                    ");
        System.out.println("                                                     ");
        System.out.println("════════════════════════════════════════════════════");
    }

}
