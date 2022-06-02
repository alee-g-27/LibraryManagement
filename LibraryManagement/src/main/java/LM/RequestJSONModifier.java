package LM;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

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
     * @param Richiesta
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void InviaRispostaAdmin(String Richiesta, int ID) throws IOException, ParseException {

        //Verificare se l'utente esiste già
        try {

            System.out.println("Invio richiesta in corso...");

            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(".settings/adminResponse.json");
            JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

            //ottieni nome utente della richiesta
            String NomeUtente = "";
            for(int i = 0; i < richiestaObject.size(); i++){
                JSONObject obj = (JSONObject) richiestaObject.get(i);
                if(ID == (long) obj.get("ID")){
                    NomeUtente = (String) obj.get("Nome Utente");
                }
            }

            JSONObject richiesta = new JSONObject();
            richiesta.put("Richiesta", Richiesta);
            richiesta.put("ID", ID);

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

        eliminaRichiesta(ID);

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

    //Visualizza le richieste <-- DA SISTEMARE
    /*public static String[] visualizzaRichieste(String NomeUtente) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/UserRequest.json");
        JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

        String[] richieste = new String[richiestaObject.size()];

        for(int i = 0; i < richiestaObject.size(); i++) {

            JSONObject nomeUtente = (JSONObject) richiestaObject.get(i);
            String richiestaUtente = (String) nomeUtente.get("Nome Utente");
            richieste[i] = richiestaUtente;

        }

        return richieste;

    }*/

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
        long[] id = new long[richiestaObject.size()];

        for(int i = 0; i < richiestaObject.size(); i++) {

            JSONObject nomeUtente = (JSONObject) richiestaObject.get(i);
            String richiestaUtente = (String) nomeUtente.get("Richiesta");
            String user = (String) nomeUtente.get("Nome Utente");
            richieste[i] = richiestaUtente;
            users[i] = user;

        }

        id = visualizzaIDRichiesteAll();

        for (int i = 0; i < richieste.length; i++) {
            int idRichiesta = i+1;
            System.out.println("Richiesta #" + id[i] + " --> " + richieste[i] + " - " + users[i]);
        }


    }

    //Visualizzare le richieste in base al nome utente

    /**
     * Metodo che restituisce le richieste di un utente
     * @param NomeUtente
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static String[] visualizzaRichiesteUtente(String NomeUtente) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/userRequest.json");
        JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

        String[] richieste = new String[richiestaObject.size()];

        for(int i = 0; i < richiestaObject.size(); i++) {

            JSONObject nomeUtente = (JSONObject) richiestaObject.get(i);
            String richiestaUtente = (String) nomeUtente.get("Nome Utente");
            String richiesta = (String) nomeUtente.get("Richiesta");

            if(richiestaUtente.equals(NomeUtente)) {

                richieste[i] = richiesta;

            }

        }

        return richieste;

    }

    /**
     * Metodo che restituisce le risposte di un utente
     * @param NomeUtente
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static String[] visualizzaRisposteUtente(String NomeUtente) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/adminResponse.json");
        JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

        String[] risposte = new String[richiestaObject.size()];

        for(int i = 0; i < richiestaObject.size(); i++) {

            JSONObject nomeUtente = (JSONObject) richiestaObject.get(i);
            String rispostaUtente = (String) nomeUtente.get("Nome Utente");
            String risposta = (String) nomeUtente.get("Risposta");

            if(Objects.equals(rispostaUtente, NomeUtente)) {

                risposte[i] = risposta;

            }

        }

        return risposte;

    }

    /**
     * Metodo che restituisce l'ID delle risposte di un utente
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static long[] visualizzaIDRisposte(String NomeUtente) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/adminResponse.json");
        JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

        long[] id = new long[richiestaObject.size()];

        for(int i = 0; i < richiestaObject.size(); i++) {

            JSONObject nomeUtente = (JSONObject) richiestaObject.get(i);
            String richiestaUtente = (String) nomeUtente.get("Nome Utente");
            long idRichiesta = (long) nomeUtente.get("ID");

            if(Objects.equals(richiestaUtente, NomeUtente)) {

                id[i] = idRichiesta;

            }

        }

        return id;

    }

    //ottieni l'id delle richieste
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

    //ottieni l'id delle richieste
    public static long[] visualizzaIDRichiesteAll() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/UserRequest.json");
        JSONArray richiestaObject = (JSONArray)jsonParser.parse(reader);

        long[] id = new long[richiestaObject.size()];

        for(int i = 0; i < richiestaObject.size(); i++) {

            JSONObject nomeUtente = (JSONObject) richiestaObject.get(i);
            long idRichiesta = (long) nomeUtente.get("ID");

            id[i] = idRichiesta;

        }

        return id;

    }

}
