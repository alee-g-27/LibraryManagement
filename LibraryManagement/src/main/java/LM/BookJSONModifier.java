package LM;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class BookJSONModifier {

    //----------------------------------------------------
    //OPERAZIONI SUI LIBRI
    //----------------------------------------------------

    /**
     * Metodo per creare un libro
     * @param libro
     */
    public static void creaLibro (Libro libro) {

        try {

            String titolodaTrovare = libro.getTitolo();

            if (verificaLibro(titolodaTrovare)==false) {

                System.out.println("Creazione libro in corso...");
                JSONParser jsonParser = new JSONParser();
                FileReader reader = new FileReader(".settings/books.json");
                //Read JSON file
                JSONArray bookObject = (JSONArray)jsonParser.parse(reader);

                //ottieni ultimo ID dal file
                long id = 0;
                for(int i = 0; i < bookObject.size(); i++){
                    JSONObject obj = (JSONObject) bookObject.get(i);
                    long id_temp = (long) obj.get("ID");
                    if(id_temp > id){
                        id = id_temp;
                    }
                }

                //Create JSON Object
                JSONObject book = new JSONObject();
                book.put("titolo", libro.getTitolo());
                book.put("autore", libro.getAutore());
                book.put("nPagine", libro.getnPagine());
                book.put("CasaEditrice", libro.getCasaEditrice());
                book.put("AnnoUscita", libro.getAnnoUscita());
                book.put("lingua", libro.getLingua());
                book.put("nCopie", libro.getnCopie());
                book.put("ISBN", libro.getISBN());
                book.put("dewey", libro.getDewey());
                book.put("ID", id+1);

                //Add JSON Object to JSON Array
                bookObject.add(book);

                //Write JSON file
                FileWriter file = new FileWriter(".settings/books.json");
                file.write(bookObject.toJSONString());
                file.flush();
                System.out.println("Libro inserito con successo!");

            }

        } catch (IOException e) {

            e.printStackTrace();

        } catch (ParseException e) {

            e.printStackTrace();

        }

    }

    /**
     * Metodo per verificare se un libro esiste
     * @param titolodaTrovare
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static boolean verificaLibro(String titolodaTrovare) throws IOException, ParseException {

        boolean res = false;

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray books = (JSONArray)jsonParser.parse(reader);

        for (int i = 0; i < books.size(); i++) {

            JSONObject book = (JSONObject) books.get(i);

            String titolo = (String) book.get("titolo");

            System.out.println("titolo: " + titolo);

            if (titolodaTrovare.equals(titolo)) {

                res = true;
                System.out.println("Libro già esistente!");

            }

        }

        return res;

    }

    /**
     * Metodo per eliminare un libro
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void eliminaLibro(int ID) throws IOException, ParseException{

        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray books = (JSONArray) parser.parse(reader);

        if (verificaLibroEsistente(ID)) {

            for (int i = 0; i < books.size(); i++) {

                JSONObject book = (JSONObject) books.get(i);
                long id = (long) book.get("ID");

                if (ID==id) {

                    books.remove(i);
                    System.out.println("Libro eliminato!");

                }

            }

            FileWriter file = new FileWriter(".settings/books.json");
            file.write(books.toJSONString());
            file.flush();

        }else{

            System.out.println("Libro non esistente!");

        }


    }

    /**
     * Metodo per verificare se un libro esiste
     * @param ID
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static boolean verificaLibroEsistente(int ID) throws IOException, ParseException {

        boolean res = false;

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray)jsonParser.parse(reader);

        for (int i = 0; i < booksObject.size(); i++) {

            JSONObject user = (JSONObject) booksObject.get(i);

            long id = (long) user.get("ID");

            if (ID==id) {

                res = true;

            }

        }
        System.out.println(res);
        return res;

    }

    /**
     * Metodo per visualizzare i libri in base al titolo
     * @throws IOException
     * @throws ParseException
     */
    public static void visualizzaLibri() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray)jsonParser.parse(reader);

        String[] titoli = new String[booksObject.size()];
        //long[] ID = new long[booksObject.size()];

        long[] indici = new long[booksObject.size()];
        long[] ID = new long[booksObject.size()];

        titoli = prendiTitoli();
        ordinaLibri(titoli);
        //setIndiceLibri(titoli, indici);
        ID=getIndiceLibri();

        System.out.println("\nTitoli dei libri disponibili:\n");

        for(int i = 0;i < booksObject.size();i++) {

            System.out.println((i+1) + " - " +  titoli[i] + " ➤ ID: " + ID[i] + "\n");

        }

    }

    /**
     * Metodo per prendere visualizzare le informazioni di un libro
     * @return
     * @throws IOException
     * @throws ParseException
     */
    public static void visualizzaLibro(int indice) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray)jsonParser.parse(reader);
        JSONObject books;

        //Scorro tutti i libri fino a quando non trovo l'ID desiderato
        for(int i = 0;i < booksObject.size();i++) {

            books = (JSONObject) booksObject.get(i);
            long id = (long) books.get("ID");

            if(indice==id){

                System.out.println("\nInformazioni sul libro:\n");
                System.out.println("Titolo: " + books.get("titolo"));
                System.out.println("Autore: " + books.get("autore"));
                System.out.println("Numero di pagine: " + books.get("nPagine"));
                System.out.println("Casa editrice: " + books.get("CasaEditrice"));
                System.out.println("Anno di uscita: " + books.get("AnnoUscita"));
                System.out.println("Lingua: " + books.get("lingua"));
                System.out.println("Numero di copie: " + books.get("nCopie"));
                System.out.println("ISBN: " + books.get("ISBN"));
                System.out.println("Dewey: " + books.get("dewey"));
                System.out.println("ID: " + books.get("ID"));

            }

        }

        /*books = (JSONObject) booksObject.get(indice);
        System.out.println("\nTitolo: " + books.get("titolo") + "\n");
        System.out.println("Autore: " + books.get("autore") + "\n");
        System.out.println("Lingua: " + books.get("lingua") + "\n");
        System.out.println("Numero pagine: " + books.get("nPagine") + "\n");
        System.out.println("Anno di pubblicazione: " + books.get("AnnoUscita") + "\n");
        System.out.println("ISBN: " + books.get("ISBN") + "\n");
        System.out.println("Casa Editrice: " + books.get("CasaEditrice") + "\n");
        System.out.println("Dewey: " + books.get("dewey") + "\n");
        System.out.println("Numero copie disponibili: " + books.get("nCopie") + "\n");
        System.out.println("ID: " + books.get("ID") + "\n");*/

    }

    /**
     * Metodo per prendere i titoli dei libri
     * @return
     * @throws IOException
     * @throws ParseException
     */
    private static String[] prendiTitoli() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray)jsonParser.parse(reader);

        String[] titoli = new String[booksObject.size()];

        for(int i = 0; i < booksObject.size(); i++) {

            JSONObject books = (JSONObject) booksObject.get(i);
            String titolo = (String) books.get("titolo");
            titoli[i] = titolo;

        }

        return titoli;

    }

    /**
     * Metodo per ordinare i libri in base al titolo
     * @param Arr
     */
    private static String[] ordinaLibri (String[] Arr) {

        Arrays.sort(Arr);

        return Arr;

    }

    /**
     * Metodo per prendere gli ID dei libri
     * @return
     * @throws IOException
     * @throws ParseException
     */
    private static long[] getIndiceLibri() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray)jsonParser.parse(reader);
        //Create JSON Object
        JSONObject book = new JSONObject();
        long arrIndici[] = new long[booksObject.size()];

        for(int i = 0; i < booksObject.size(); i++) {

            book = (JSONObject) booksObject.get(i);
            arrIndici[i] = (long) book.get("ID");

        }

        return arrIndici;

    }

    /*public static void changeBooksID() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray)jsonParser.parse(reader);
        //Create JSON Object
        JSONObject book = new JSONObject();

        int arrIndici[] = new int[booksObject.size()];

        for(int i = 0; i < booksObject.size(); i++) {

            //arrIndici[i] = i+1;
            book.remove("ID");

        }

        booksObject.remove(book);

        //Write JSON file
        FileWriter file = new FileWriter(".settings/books.json");
        file.write(booksObject.toJSONString());
        file.flush();

    }*/

}
