package it.iisvittorioveneto.lm;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

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

        }else if (ID==0) {

            System.out.println("Uscita dal menu...");

        }else {

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

        long[] indici = new long[booksObject.size()];
        long[] ID = new long[booksObject.size()];

        titoli = prendiTitoli();
        ordinaLibri(titoli);
        ID=getIndiceLibri(titoli);

        System.out.println("\nTitoli dei libri disponibili:\n");

        if (booksObject.size()==0) {

            System.out.println("Nessun libro disponibile!");

        }else {

            for(int i = 0;i < booksObject.size();i++) {

                System.out.println((i+1) + " - " +  titoli[i] + " --> ID: " + ID[i] + "\n");

            }

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
        boolean res = false;

        for(int i = 0;i < booksObject.size();i++) {

            books = (JSONObject) booksObject.get(i);
            long id = (long) books.get("ID");

            if(indice==id){

                res = true;
                System.out.println("════════════════════════════════════════════════════");
                System.out.println("\nInformazioni sul libro:\n");
                System.out.println("════════════════════════════════════════════════════");
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
                System.out.println("════════════════════════════════════════════════════");


            }

        }

        if (res==false) {

            System.out.println("Libro non esistente!");

        }

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

    //Metodo per verificare che vi siano libri disponibili
    public static boolean verificaLibriDisponibili() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray)jsonParser.parse(reader);

        boolean res = false;

        if (booksObject.size()==0) {

            res = false;

        }else {

            res = true;

        }

        return res;

    }

    private static long[] getIndiceLibri(String[] titoli) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray)jsonParser.parse(reader);

        long[] indici = new long[booksObject.size()];

        //Scorro tutti i libri fino a quando non trovo l'ID del libro desiderato
        for(int i = 0;i < booksObject.size();i++) {

            JSONObject books = (JSONObject) booksObject.get(i);
            String titolo = (String) books.get("titolo");

            for(int j = 0; j < titoli.length; j++) {

                if(titolo.equals(titoli[j])) {

                    indici[j] = (long) books.get("ID");

                }

            }



        }

        return indici;
    }

    /**Metodo per gestire la modifica di un libro
     *
     * @param indice
     * @throws IOException
     * @throws ParseException
     */
    public static void modificaLibro(int indice) throws IOException, ParseException {

        Scanner input = new Scanner(System.in);
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray) jsonParser.parse(reader);
        JSONObject books;

        //Scorro tutti i libri fino a quando non trovo l'ID desiderato
        for (int i = 0; i < booksObject.size(); i++) {

            books = (JSONObject) booksObject.get(i);
            long id = (long) books.get("ID");

            if (indice == id) {

                visualizzaLibro((int)indice);

                int scelta = sceltaModifica();

                switch (scelta) {

                    case 1:
                        System.out.println("Inserisci il nuovo titolo: ");
                        String titolo = input.nextLine();

                        setTitolo(titolo, indice);

                        break;

                    case 2:
                        System.out.println("Inserisci il nuovo autore: ");
                        String autore = input.nextLine();

                        setAutore(autore, indice);

                        break;

                    case 3:
                        System.out.println("Inserisci il nuovo numero di pagine: ");
                        int nPagine = input.nextInt();

                        setNPagine(nPagine, indice);

                        break;

                    case 4:
                        System.out.println("Inserisci la nuova casa editrice: ");
                        String casaEditrice = input.nextLine();

                        setCasaEditrice(casaEditrice, indice);

                        break;

                    case 5:
                        System.out.println("Inserisci il nuovo anno di uscita: ");
                        int annoUscita = input.nextInt();

                        setAnnoUscita(annoUscita, indice);

                        break;

                    case 6:
                        System.out.println("Inserisci la nuova lingua: ");
                        String lingua = input.nextLine();

                        setLingua(lingua, indice);

                        break;

                    case 7:
                        System.out.println("Inserisci il nuovo numero di copie: ");
                        int nCopie = input.nextInt();

                        setNCopie(nCopie, indice);

                        break;

                    case 8:
                        System.out.println("Inserisci il nuovo ISBN: ");
                        String isbn = input.nextLine();

                        setISBN(isbn, indice);

                        break;

                    case 9:
                        System.out.println("Inserisci il nuovo Dewey: ");
                        String dewey = input.nextLine();

                        setDewey(dewey, indice);

                        break;

                    default:

                        System.out.println("Scelta non valida");

                        break;

                }

            }

        }

    }

    /**Metodo per scegliere cosa modificare
     *
     * @return
     */
    public static int sceltaModifica() {

        Scanner input = new Scanner(System.in);

        System.out.println("\n1. Titolo");
        System.out.println("2. Autore");
        System.out.println("3. Numero di pagine");
        System.out.println("4. Casa editrice");
        System.out.println("5. Anno di uscita");
        System.out.println("6. Lingua");
        System.out.println("7. Numero di copie");
        System.out.println("8. ISBN");
        System.out.println("9. Dewey");

        System.out.println("\nScegliere cosa modificare:\n");

        int res = input.nextInt();

        return res;

    }

    /**Metodo per settare il titolo di un libro nel file
     *
     * @param titolo
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void setTitolo(String titolo, int ID) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray) jsonParser.parse(reader);
        JSONObject books;

        //Scorro tutti i libri fino a quando non trovo l'ID desiderato
        for (int i = 0; i < booksObject.size(); i++) {

            books = (JSONObject) booksObject.get(i);
            long id = (long) books.get("ID");

            if (ID == id) {

                //Aggiorno i dati
                books.put("titolo", titolo);


            }

        }

        FileWriter file = new FileWriter(".settings/books.json");
        file.write(booksObject.toJSONString());
        file.flush();

        System.out.println("\nLibro modificato con successo!\n");

    }

    /**Metodo per settare l'autore di un libro nel file
     *
     * @param autore
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void setAutore(String autore, int ID) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray) jsonParser.parse(reader);
        JSONObject books;

        //Scorro tutti i libri fino a quando non trovo l'ID desiderato
        for (int i = 0; i < booksObject.size(); i++) {

            books = (JSONObject) booksObject.get(i);
            long id = (long) books.get("ID");

            if (ID == id) {

                //Aggiorno i dati
                books.put("autore", autore);

                //Scrivo i dati nel file
                FileWriter file = new FileWriter(".settings/books.json");
                file.write(booksObject.toJSONString());
                file.flush();

                System.out.println("\nLibro modificato con successo!\n");
            }

        }


    }

    /**Metodo per settare il numero di pagine di un libro nel file
     *
     * @param nPagine
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void setNPagine(int nPagine, int ID) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray) jsonParser.parse(reader);
        JSONObject books;

        //Scorro tutti i libri fino a quando non trovo l'ID desiderato
        for (int i = 0; i < booksObject.size(); i++) {

            books = (JSONObject) booksObject.get(i);
            long id = (long) books.get("ID");

            if (ID == id) {

                //Aggiorno i dati
                books.put("nPagine", nPagine);

                //Scrivo i dati nel file
                FileWriter file = new FileWriter(".settings/books.json");
                file.write(booksObject.toJSONString());
                file.flush();

                System.out.println("\nLibro modificato con successo!\n");

            }

        }

    }

    /**Metodo per settare la casa editrice di un libro nel file
     *
     * @param casaEditrice
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void setCasaEditrice(String casaEditrice, int ID) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray) jsonParser.parse(reader);
        JSONObject books;

        //Scorro tutti i libri fino a quando non trovo l'ID desiderato
        for (int i = 0; i < booksObject.size(); i++) {

            books = (JSONObject) booksObject.get(i);
            long id = (long) books.get("ID");

            if (ID == id) {

                //Aggiorno i dati
                books.put("CasaEditrice", casaEditrice);

                //Scrivo i dati nel file
                FileWriter file = new FileWriter(".settings/books.json");
                file.write(booksObject.toJSONString());
                file.flush();

                System.out.println("\nLibro modificato con successo!\n");

            }

        }

    }

    /**Metodo per settare l'anno di uscita di un libro nel file
     *
     * @param annoUscita
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void setAnnoUscita(int annoUscita, int ID) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray) jsonParser.parse(reader);
        JSONObject books;

        //Scorro tutti i libri fino a quando non trovo l'ID desiderato
        for (int i = 0; i < booksObject.size(); i++) {

            books = (JSONObject) booksObject.get(i);
            long id = (long) books.get("ID");

            if (ID == id) {

                //Aggiorno i dati
                books.put("AnnoUscita", annoUscita);

                //Scrivo i dati nel file
                FileWriter file = new FileWriter(".settings/books.json");
                file.write(booksObject.toJSONString());
                file.flush();

                System.out.println("\nLibro modificato con successo!\n");

            }

        }

    }

    /**Metodo per settare il numero di copie di un libro nel file
     * @param nCopie
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void setNCopie(int nCopie, int ID) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray) jsonParser.parse(reader);
        JSONObject books;

        //Scorro tutti i libri fino a quando non trovo l'ID desiderato
        for (int i = 0; i < booksObject.size(); i++) {

            books = (JSONObject) booksObject.get(i);
            long id = (long) books.get("ID");

            if (ID == id) {

                //Aggiorno i dati
                books.put("nCopie", nCopie);

                //Scrivo i dati nel file
                FileWriter file = new FileWriter(".settings/books.json");
                file.write(booksObject.toJSONString());
                file.flush();

                System.out.println("\nLibro modificato con successo!\n");

            }

        }

    }

    /**Metodo per settare la lingua di un libro nel file
     *
     * @param lingua
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void setLingua(String lingua, int ID) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray) jsonParser.parse(reader);
        JSONObject books;

        //Scorro tutti i libri fino a quando non trovo l'ID desiderato
        for (int i = 0; i < booksObject.size(); i++) {

            books = (JSONObject) booksObject.get(i);
            long id = (long) books.get("ID");

            if (ID == id) {

                //Aggiorno i dati
                books.put("lingua", lingua);

                //Scrivo i dati nel file
                FileWriter file = new FileWriter(".settings/books.json");
                file.write(booksObject.toJSONString());
                file.flush();

                System.out.println("\nLibro modificato con successo!\n");

            }

        }

    }

    /**
     * Metodo per settare l'ISBN di un libro nel file
     * @param ISBN
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void setISBN(String ISBN, int ID) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray) jsonParser.parse(reader);
        JSONObject books;

        //Scorro tutti i libri fino a quando non trovo l'ID desiderato
        for (int i = 0; i < booksObject.size(); i++) {

            books = (JSONObject) booksObject.get(i);
            long id = (long) books.get("ID");

            if (ID == id) {

                //Aggiorno i dati
                books.put("ISBN", ISBN);

                //Scrivo i dati nel file
                FileWriter file = new FileWriter(".settings/books.json");
                file.write(booksObject.toJSONString());
                file.flush();

                System.out.println("\nLibro modificato con successo!\n");
            }

        }

    }

    /**
     * Metodo per settare il dewey code di un libro nel file
     *
     * @param dewey
     * @param ID
     * @throws IOException
     * @throws ParseException
     */
    public static void setDewey(String dewey, int ID) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(".settings/books.json");
        JSONArray booksObject = (JSONArray) jsonParser.parse(reader);
        JSONObject books;

        //Scorro tutti i libri fino a quando non trovo l'ID desiderato
        for (int i = 0; i < booksObject.size(); i++) {

            books = (JSONObject) booksObject.get(i);
            long id = (long) books.get("ID");

            if (ID == id) {

                //Aggiorno i dati
                books.put("dewey", dewey);

                //Scrivo i dati nel file
                FileWriter file = new FileWriter(".settings/books.json");
                file.write(booksObject.toJSONString());
                file.flush();

                System.out.println("\nLibro modificato con successo!\n");

            }

        }

    }

}
