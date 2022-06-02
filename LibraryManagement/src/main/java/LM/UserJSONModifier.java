package LM;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class UserJSONModifier {

    //----------------------------------------------------
    //OPERAZIONI SULL'ACCOUNT
    //----------------------------------------------------

    /**
     * Metodo per creare un account
     * @param NomeUtente
     * @param PSW
     * @param tipoUtente
     */
    public static void creaUtente(String NomeUtente, String PSW, String tipoUtente){

        try {

            if (verificaUtenteEsistente(NomeUtente) == false) {

                System.out.println("Registrazione in corso...");

                JSONParser jsonParser = new JSONParser();
                FileReader reader = new FileReader(".settings/users.json");
                JSONArray usersObject = (JSONArray)jsonParser.parse(reader);
                JSONObject user = new JSONObject();

                user.put("Nome Utente", NomeUtente);
                user.put("PSW", PSW);
                user.put("Tipoutente", tipoUtente);

                //Add JSON Object to JSON Array
                usersObject.add(user);

                //Write JSON file
                FileWriter file = new FileWriter(".settings/users.json");
                file.write(usersObject.toJSONString());
                file.flush();

                System.out.println("Registrazione completata!");

            }else{

                System.out.println("Utente già esistente!");

            }

        } catch (IOException e) {

            e.printStackTrace();

        } catch (ParseException e) {

            e.printStackTrace();

        }

    }

    /**
     * Metodo di supporto per verificare se un utente esiste leggendo il file json
     * @param NomeUtente
     * @param PSW
     * @param tipoUtente
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static boolean userReader(String NomeUtente, String PSW, String tipoUtente) throws IOException, ParseException {

        boolean res = false;

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/users.json");
        JSONArray usersObject = (JSONArray)jsonParser.parse(reader);

        for (int i = 0; i < usersObject.size(); i++) {

            JSONObject user = (JSONObject) usersObject.get(i);

            String nomeUtente = (String) user.get("Nome Utente");

            String psw = (String) user.get("PSW");

            String type = (String) user.get("Tipoutente");

            if (NomeUtente.equals(nomeUtente) && PSW.equals(psw) && tipoUtente.equals(type)) {

                res = true;

            }

        }

        return res;

    }

    /**
     * Metodo per verificare se un utente esiste verificando le credenziali
     * @param NomeUtente
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static void VerificaCredenziali(String NomeUtente, String PSW, String tipoUtente) throws IOException, ParseException {

        boolean res = false;

        res = userReader(NomeUtente, PSW, tipoUtente);

        System.out.println("\nVerifica delle credenziali in corso...");


        if (res) {

            System.out.println("Accesso riuscito!\n");

        }else{

            System.out.println("Accesso non riuscito!\n");

        }

    }

    /**
     * Metodo per verificare se un utente esiste attraverso il nome utente
     * @param NomeUtente
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static boolean verificaUtenteEsistente(String NomeUtente) throws IOException, ParseException {

        boolean res = false;

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/users.json");
        JSONArray usersObject = (JSONArray)jsonParser.parse(reader);

        for (int i = 0; i < usersObject.size(); i++) {

            JSONObject user = (JSONObject) usersObject.get(i);

            String nomeUtente = (String) user.get("Nome Utente");

            if (NomeUtente.equals(nomeUtente)) {

                res = true;

            }

        }

        return res;

    }

    /**
     * Metodo per eliminare un utente dal file json
     * @param nomeUtente
     * @throws IOException
     * @throws ParseException
     */
    public static void eliminaUtente(String nomeUtente) throws IOException, ParseException{

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(".settings/users.json");
        JSONArray users = (JSONArray) parser.parse(reader);

        if (verificaUtenteEsistente(nomeUtente)) {

            for (int i = 0; i < users.size(); i++) {

                JSONObject user = (JSONObject) users.get(i);
                String userName = (String) user.get("Nome Utente");

                if (userName.equals(nomeUtente)) {

                    users.remove(i);
                    System.out.println("Utente eliminato!");

                }

            }

            FileWriter file = new FileWriter(".settings/users.json");
            file.write(users.toJSONString());
            file.flush();

        }else{

            System.out.println("Utente non esistente!");

        }

    }

    /**
     * Metodo per modificare la password di un utente
     * @param nomeUtente
     * @param nuovaPassword
     * @throws IOException
     * @throws ParseException
     */
    public static void cambiaPassword(String nomeUtente, String nuovaPassword) throws IOException, ParseException{

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(".settings/users.json");
        JSONArray users = (JSONArray) parser.parse(reader);

        if (verificaUtenteEsistente(nomeUtente)) {

            for (int i = 0; i < users.size(); i++) {

                JSONObject user = (JSONObject) users.get(i);
                String userName = (String) user.get("Nome Utente");

                if (userName.equals(nomeUtente)) {

                    user.put("PSW", nuovaPassword);
                    System.out.println("Password cambiata!");

                }

            }

            FileWriter file = new FileWriter(".settings/users.json");
            file.write(users.toJSONString());
            file.flush();

        }else{

            System.out.println("Utente non esistente!");

        }

    }

    /**
     * Metodo per cambiare il nome utente di un utente
     * @param nomeUtente
     * @param nuovoNomeUtente
     * @throws IOException
     * @throws ParseException
     */
    public static void cambiaNomeUtente(String nomeUtente, String nuovoNomeUtente) throws IOException, ParseException{

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(".settings/users.json");
        JSONArray users = (JSONArray) parser.parse(reader);

        if (verificaUtenteEsistente(nomeUtente)) {
            System.out.println("Utente esistente!");
            for (int i = 0; i < users.size(); i++) {

                JSONObject user = (JSONObject) users.get(i);
                String userName = (String) user.get("Nome Utente");

                if (userName.equals(nomeUtente)) {

                    user.put("Nome Utente", nuovoNomeUtente);
                    System.out.println("Nome utente cambiato!");

                }

            }

            FileWriter file = new FileWriter(".settings/users.json");
            file.write(users.toJSONString());
            file.flush();

        }else{

            System.out.println("Utente non esistente!");

        }

    }

    /**
     * Metodo per visualizzare tutti gli utenti
     * @throws IOException
     * @throws ParseException
     * @throws FileNotFoundException
     */
    public static void visualizzaUtenti() throws IOException, ParseException, FileNotFoundException {

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(".settings/users.json");
        JSONArray users = (JSONArray) parser.parse(reader);

        for (int i = 0; i < users.size(); i++) {

            JSONObject user = (JSONObject) users.get(i);
            String userName = (String) user.get("Nome Utente");
            String userType = (String) user.get("Tipoutente");

            System.out.println("Nome Utente: " + userName + " ➤ Tipo Utente: " + userType);


        }
    }
}
