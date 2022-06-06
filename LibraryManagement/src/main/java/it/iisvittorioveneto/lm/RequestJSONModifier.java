package it.iisvittorioveneto.lm;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RequestJSONModifier {

    //----------------------------------------------------
    //OPERAZIONI CON LE RICHIESTE e LE RISPOSTE
    //----------------------------------------------------

    /**
     * Metodo che permette di inviare una richiesta per un utente comune
     * @param Richiesta
     * @param NomeUtente
     * @throws IOException
     * @throws ParseException
     */
    public static void InviaRichiestaCommUser(String Richiesta, String NomeUtente) throws IOException, ParseException {

        //Verificare se l'utente esiste già
        try {
            System.out.println("Invio richiesta in corso...");

            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(".settings/userRequest.json");
            JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

            //ottieni ultimo ID dal file
            long id = 0;
            for(int i = 0; i < richiestaObject.size(); i++){

                JSONObject obj = (JSONObject) richiestaObject.get(i);
                long id_temp = (long) obj.get("ID");
                if(id_temp > id){

                    id = id_temp;

                }

            }

            JSONObject richiesta = new JSONObject();
            richiesta.put("Nome Utente", NomeUtente);
            richiesta.put("Richiesta", Richiesta);
            richiesta.put("Stato", "In attesa");
            richiesta.put("ID", id+1);

            richiestaObject.add(richiesta);

            FileWriter file = new FileWriter(".settings/userRequest.json");
            file.write(richiestaObject.toJSONString());
            file.flush();
            System.out.println("Richiesta inviata!");

        } catch (IOException e) {

            e.printStackTrace();

        } catch (ParseException e) {

            e.printStackTrace();

        }

    }

    /**
     * Metodo che permette di inviare una risposta per un utente admin
     * @param Risposta
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void InviaRispostaAdmin(String Risposta, int ID) throws IOException, ParseException {

        //Verificare se l'utente esiste già
        try {



            System.out.println("Invio richiesta in corso...");

            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(".settings/adminResponse.json");
            JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

            //ottieni nome utente della richiesta
            String NomeUtente = getNomeUtente(ID);
            String Richiesta = getRichiesta(ID);

            JSONObject richiesta = new JSONObject();
            richiesta.put("Risposta", Risposta);
            richiesta.put("ID", ID);
            richiesta.put("Nome Utente", NomeUtente);
            richiesta.put("Richiesta", Richiesta);

            richiestaObject.add(richiesta);

            FileWriter file = new FileWriter(".settings/adminResponse.json");
            file.write(richiestaObject.toJSONString());
            file.flush();
            System.out.println("Risposta inviata!");

        } catch (IOException e) {

            e.printStackTrace();

        } catch (ParseException e) {

            e.printStackTrace();

        }

        //eliminaRichiesta(ID);
        aggiornaStatoRichiesta(ID);

    }

    /**
     * Metodo per aggiornare lo stato di una richiesta
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void aggiornaStatoRichiesta(int ID){

        try {

            System.out.println("Aggiornamento stato richiesta in corso...");

            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(".settings/userRequest.json");
            JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

            for(int i = 0; i < richiestaObject.size(); i++){

                JSONObject obj = (JSONObject) richiestaObject.get(i);
                long id_temp = (long) obj.get("ID");
                if(id_temp == ID){

                    obj.put("Stato", "Risposta inviata");

                }

            }

            FileWriter file = new FileWriter(".settings/userRequest.json");
            file.write(richiestaObject.toJSONString());
            file.flush();
            System.out.println("Stato richiesta aggiornato!");

        } catch (IOException e) {

            e.printStackTrace();

        } catch (ParseException e) {

            e.printStackTrace();

        }

    }

    /**
     * Metodo per ottenere il nome utente di una richiesta
     * @param ID
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static String getNomeUtente(int ID) throws IOException, ParseException {

        //Verificare se l'utente esiste già
        try {

            System.out.println("Richiesta in corso...");

            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(".settings/userRequest.json");
            JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

            //ottieni nome utente della richiesta
            String NomeUtente = "";
            for(int i = 0; i < richiestaObject.size(); i++){

                JSONObject obj = (JSONObject) richiestaObject.get(i);

                if(ID == (long) obj.get("ID")){

                    NomeUtente = (String) obj.get("Nome Utente");

                }

            }

            return NomeUtente;

        } catch (IOException e) {

            e.printStackTrace();

        } catch (ParseException e) {

            e.printStackTrace();

        }

        return null;

    }

    /**
     * Metodo per verificare la presenza di una richiesta
     * @param ID
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static boolean checkRichiesta(int ID) throws IOException, ParseException {

        //Verificare se l'utente esiste già
        try {

            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(".settings/userRequest.json");
            JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

            //ottieni nome utente della richiesta
            boolean check = false;
            for(int i = 0; i < richiestaObject.size(); i++){

                JSONObject obj = (JSONObject) richiestaObject.get(i);

                if(ID == (long) obj.get("ID")){

                    check = true;

                }

            }

            return check;

        } catch (IOException e) {

            e.printStackTrace();

        } catch (ParseException e) {

            e.printStackTrace();

        }

        return false;

    }

    /**
     * Metodo per verificare la presenza di una risposta
     * @param ID
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static boolean checkRisposta(int ID) throws IOException, ParseException {

        //Verificare se l'utente esiste già
        try {

            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(".settings/adminResponse.json");
            JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

            //ottieni nome utente della richiesta
            boolean check = false;
            for(int i = 0; i < richiestaObject.size(); i++){

                JSONObject obj = (JSONObject) richiestaObject.get(i);

                if(ID == (long) obj.get("ID")){

                    check = true;

                }

            }

            return check;

        } catch (IOException e) {

            e.printStackTrace();

        } catch (ParseException e) {

            e.printStackTrace();

        }

        return false;

    }

    /**
     * Metodo che permette di eliminare una richiesta
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void eliminaRichiesta(long ID) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/userRequest.json");
        JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

        if (verificaRichiestaEsistente(ID)) {

            for (int i = 0; i < richiestaObject.size(); i++) {

                JSONObject richiesta = (JSONObject) richiestaObject.get(i);

                if (ID == (long) richiesta.get("ID")) {

                    richiestaObject.remove(i);
                    System.out.println("Richiesta eliminata!");

                }

            }

            FileWriter file = new FileWriter(".settings/userRequest.json");
            file.write(richiestaObject.toJSONString());
            file.flush();

        }else{

            System.out.println("Richiesta non esistente!");

        }

    }

    /**
     * Metodo che permette di verificare se una richiesta esiste
     * @param ID
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static boolean verificaRichiestaEsistente(long ID) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/userRequest.json");
        JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

        for (int i = 0; i < richiestaObject.size(); i++) {

            JSONObject richiesta = (JSONObject) richiestaObject.get(i);
            long id = (long) richiesta.get("ID");

            if (id==ID) {

                return true;

            }

        }

        return false;

    }

    /**
     * Metodo che permette di visualizzare le richieste di tutti gli utenti
     * @throws IOException
     * @throws ParseException
     */
    public static void visualizzaRichiesteAll() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/userRequest.json");
        JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

        String[] richieste = new String[richiestaObject.size()];
        String[] users = new String[richiestaObject.size()];
        String[] stati = new String[richiestaObject.size()];
        long[] id;

        for(int i = 0; i < richiestaObject.size(); i++) {

            JSONObject nomeUtente = (JSONObject) richiestaObject.get(i);
            String richiestaUtente = (String) nomeUtente.get("Richiesta");
            String user = (String) nomeUtente.get("Nome Utente");
            String stato = (String) nomeUtente.get("Stato");


            richieste[i] = richiestaUtente;
            users[i] = user;
            stati[i] = stato;

        }

        if (richieste.length == 0) {

            System.out.println("Nessuna richiesta presente!");

        }else{

            id = getIndiceRichiesteAll(richieste);

            for (int i = 0; i < richieste.length; i++) {

                System.out.println("Richiesta #" + id[i] + " --> " + richieste[i] + " - " + users[i] + " - " + stati[i]);

            }

        }



    }

    /**
     * Metodo che restituisce le richieste di un utente
     * @param NomeUtente
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static void visualizzaRichiesteUtente(String NomeUtente) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/userRequest.json");
        JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

        String[] richieste = new String[richiestaObject.size()];
        String[] stati = new String[richiestaObject.size()];

        for(int i = 0; i < richiestaObject.size(); i++) {

            JSONObject nomeUtente = (JSONObject) richiestaObject.get(i);
            String richiestaUtente = (String) nomeUtente.get("Nome Utente");
            String richiesta = (String) nomeUtente.get("Richiesta");
            String stato = (String) nomeUtente.get("Stato");

            if(richiestaUtente.equals(NomeUtente)) {

                richieste[i] = richiesta;
                stati[i] = stato;

            }

        }

        if (richieste.length == 0) {

            System.out.println("Non hai richieste in attesa");

        } else {

            long id[] = visualizzaIDRichieste(NomeUtente);

            for (int i = 0; i < richieste.length; i++) {

                System.out.println("Richiesta #" + id[i] + " --> " + richieste[i] + " - " + stati[i]);

            }

        }

    }

    /**
     * Metodo che permette di visualizzare le richieste di tutti gli utenti
     * @throws IOException
     * @throws ParseException
     */
    public static void visualizzaRisposte(String nomeUtente) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/adminResponse.json");
        JSONArray risposteObject = (JSONArray)jsonParser.parse(reader);

        String[] richieste = new String[risposteObject.size()];
        String[] risposte = new String[risposteObject.size()];
        long[] id = new long[risposteObject.size()];

        for(int i = 0; i < risposteObject.size(); i++) {


            JSONObject user = (JSONObject) risposteObject.get(i);
            String nomeUtenteRichiesta = (String) user.get("Nome Utente");
            String richiestaUtente = (String) user.get("Richiesta");
            String rispostaUtente = (String) user.get("Risposta");
            long idRichiesta = (long) user.get("ID");

            if (nomeUtenteRichiesta.equals(nomeUtente)) {

                risposte[i] = rispostaUtente;
                richieste[i] = richiestaUtente;
                id[i] = idRichiesta;

            }

        }

        if (risposte.length == 0) {
            System.out.println("Non ci sono risposte al momento");
        } else {

            for (int i = 0; i < risposte.length; i++) {
                System.out.println("ID: " + id[i] + " --> " + "Risposta: " + risposte[i] + "  Richiesta: " + richieste[i]);
            }

        }



    }

    /**
     * Metodo che permette di visualizzare le richieste di tutti gli utenti
     * @throws IOException
     * @throws ParseException
     */
    public static void visualizzaRisposteAll() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/adminResponse.json");
        JSONArray risposteObject = (JSONArray)jsonParser.parse(reader);

        String[] richieste = new String[risposteObject.size()];
        String[] risposte = new String[risposteObject.size()];
        String[] users = new String[risposteObject.size()];
        long[] id = new long[risposteObject.size()];

        for(int i = 0; i < risposteObject.size(); i++) {


            JSONObject user = (JSONObject) risposteObject.get(i);
            String nomeUtenteRichiesta = (String) user.get("Nome Utente");
            String richiestaUtente = (String) user.get("Richiesta");
            String rispostaUtente = (String) user.get("Risposta");
            long idRichiesta = (long) user.get("ID");

            users[i] = nomeUtenteRichiesta;
            risposte[i] = rispostaUtente;
            richieste[i] = richiestaUtente;
            id[i] = idRichiesta;


    }

        if (risposte.length == 0) {
            System.out.println("Non ci sono risposte al momento");
        } else {

            for (int i = 0; i < risposte.length; i++) {
                System.out.println("ID: " + id[i] + " --> " + "Risposta: " + risposte[i] + "  Richiesta: " + richieste[i] + " - " + users[i]);
            }

        }



    }

    /**
     * Metodo per ottenere gli ID delle richieste di un utente
     * @param NomeUtente
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static long[] visualizzaIDRichieste(String NomeUtente) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/userRequest.json");
        JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

        long[] id = new long[richiestaObject.size()];

        for(int i = 0; i < richiestaObject.size(); i++) {

            JSONObject nomeUtente = (JSONObject) richiestaObject.get(i);
            String richiestaUtente = (String) nomeUtente.get("Nome Utente");
            long idRichiesta = (long) nomeUtente.get("ID");

            if(richiestaUtente.equals(NomeUtente)) {

                id[i] = idRichiesta;

            }

        }

        return id;

    }

    /**
     * ottieni ID delle richieste di tutti gli utenti
     * @param req
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static long[] getIndiceRichiesteAll(String[] req) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/userRequest.json");
        JSONArray booksObject = (JSONArray)jsonParser.parse(reader);

        long[] indici = new long[booksObject.size()];

        //Scorro tutti i libri fino a quando non trovo l'ID del libro desiderato
        for(int i = 0;i < booksObject.size();i++) {

            JSONObject books = (JSONObject) booksObject.get(i);
            String richiesta = (String) books.get("Richiesta");
            String stato = (String) books.get("Stato");

            for(int j = 0; j < req.length; j++) {

                if(richiesta.equals(req[j])) {

                    indici[i] = (long) books.get("ID");

                }

            }

        }

        return indici;
    }

    /**
     * Metodo per ottenere la richiesta di un utente in base all'ID
     * @param id
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static String getRichiesta(long id) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/userRequest.json");
        JSONArray booksObject = (JSONArray)jsonParser.parse(reader);

        String richiesta = "";

        //Scorro tutti i libri fino a quando non trovo l'ID del libro desiderato
        for(int i = 0;i < booksObject.size();i++) {

            JSONObject books = (JSONObject) booksObject.get(i);
            long idRichiesta = (long) books.get("ID");

            if(idRichiesta == id) {

                richiesta = (String) books.get("Richiesta");

            }

        }

        return richiesta;

    }

    /**
     * Metodo per eliminare una richiesta di un admin
     * @param id
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static void eliminaRichiestaAdmin(long id) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/adminResponse.json");
        JSONArray booksObject = (JSONArray)jsonParser.parse(reader);

        //Scorro tutti i libri fino a quando non trovo l'ID del libro desiderato
        for(int i = 0;i < booksObject.size();i++) {

            JSONObject books = (JSONObject) booksObject.get(i);
            long idRichiesta = (long) books.get("ID");

            if(idRichiesta == id) {

                booksObject.remove(i);
                System.out.println("Richiesta eliminata");

            }

        }

        FileWriter file = new FileWriter(".settings/adminResponse.json");
        file.write(booksObject.toJSONString());
        file.flush();

    }

}
