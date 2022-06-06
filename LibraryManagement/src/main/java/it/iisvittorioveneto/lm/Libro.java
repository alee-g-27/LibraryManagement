package it.iisvittorioveneto.lm;

import java.lang.String;

public class Libro {

    private String titolo;
    private String autore;
    private int nPagine;
    private String CasaEditrice;
    private int AnnoUscita;
    private String lingua;
    private int nCopie;
    private String ISBN;
    private int dewey;
    private int ID;

    /**
     * Costruttore di Libro
     * @param titolo
     * @param autore
     * @param nPagine
     * @param CasaEditrice
     * @param AnnoUscita
     * @param lingua
     * @param nCopie
     * @param ISBN
     * @param dewey
     */
    public Libro (String titolo, String autore, int nPagine, String CasaEditrice, int AnnoUscita, String lingua, int nCopie, String ISBN, int dewey){

        this.titolo = titolo;
        this.autore = autore;
        this.nPagine = nPagine;
        this.CasaEditrice = CasaEditrice;
        this.AnnoUscita = AnnoUscita;
        this.lingua = lingua;
        this.nCopie = nCopie;
        this.ISBN = ISBN;
        this.dewey = dewey;

    }

    /**
     * Costruttore di copia di Libro
     * @param libro
     */
    public Libro (Libro libro){

        this.titolo = libro.getTitolo();
        this.autore = libro.getAutore();
        this.nPagine = libro.getnPagine();
        this.CasaEditrice = libro.getCasaEditrice();
        this.AnnoUscita = libro.getAnnoUscita();
        this.lingua = libro.getLingua();
        this.nCopie = libro.getnCopie();
        this.ISBN = libro.getISBN();
        this.dewey = libro.getDewey();
        this.ID = libro.getID();

    }

    /**
     * Metodo per ottenere l'autore di un libro
     * @return
     */
    public String getAutore() {

        return autore;

    }

    /**
     * Metodo per settare l'autore di un libro
     * @return
     */
    private String setAutore() {

        return autore;

    }

    /**
     * Metodo per ottenere il titolo di un libro
     * @return
     */
    public String getTitolo() {

        return titolo;

    }

    /**
     * Metodo per settare il titolo di un libro
     * @return
     */
    public void setTitolo(String titolo) {

        this.titolo = titolo;

    }

    /**
     * Metodo per ottenere il numero di pagine di un libro
     * @return
     */
    public int getnPagine() {

        return nPagine;

    }

    /**
     * Metodo per settare il numero di pagine di un libro
     * @param nPagine
     */
    public void setnPagine(int nPagine) {

        this.nPagine = nPagine;

    }

    /**
     * Metodo per ottenere la casa editrice di un libro
     * @return
     */
    public String getCasaEditrice() {

        return CasaEditrice;

    }

    /**
     * Metodo per settare la casa editrice di un libro
     * @return
     */
    public void setCasaEditrice(String casaEditrice) {

        CasaEditrice = casaEditrice;

    }

    /**
     * Metodo per ottenere l'anno di uscita di un libro
     * @return
     */
    public int getAnnoUscita() {

        return AnnoUscita;

    }

    /**
     * Metodo per settare l'anno di uscita di un libro
     * @return
     */
    public void setAnnoUscita(int annoUscita) {

        AnnoUscita = annoUscita;

    }

    /**
     * Metodo per ottenere la lingua di un libro
     * @return
     */
    public String getLingua() {

        return lingua;

    }

    /**
     * Metodo per settare la lingua di un libro
     * @return
     */
    public void setLingua(String lingua) {

        this.lingua = lingua;

    }

    /**
     * Metodo per ottenere il numero di copie di un libro
     * @return
     */
    public int getnCopie() {

        return nCopie;

    }

    /**
     * Metodo per settare il numero di copie di un libro
     * @return
     */
    public void setnCopie(int nCopie) {

        this.nCopie = nCopie;

    }

    /**
     * Metodo per ottenere l'ISBN di un libro
     * @return
     */
    public String getISBN() {

        return ISBN;

    }

    /**
     * Metodo per settare l'ISBN di un libro
     * @return
     */
    public void setISBN(String ISBN) {

        this.ISBN = ISBN;

    }

    /**
     * Metodo per ottenere il dewey di un libro
     * @return
     */
    public int getDewey() {

        return dewey;

    }

    /**
     * Metodo per settare il dewey di un libro
     * @return
     */
    public void setDewey(int dewey) {

        this.dewey = dewey;

    }

    /**
     * Metodo per ottenere l'ID di un libro
     * @return
     */
    public int getID() {

    	return ID;

    }

    /**
     * Metodo per settare l'ID di un libro
     * @return
     */
    public void setID(int ID) {

    	this.ID = ID;

    }

}