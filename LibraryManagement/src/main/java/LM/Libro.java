package LM;

public class Libro {

    private String titolo;
    private int nPagine;
    private String CasaEditrice;
    private int AnnoUscita;
    private String lingua;
    private int nCopie;
    private String ISBN;
    private int dewey;


    public Libro (String titolo, int nPagine, String CasaEditrice, int AnnoUscita, String lingua, int nCopie, String ISBN, int dewey){

        this.titolo = titolo;
        this.nPagine = nPagine;
        this.CasaEditrice = CasaEditrice;
        this.AnnoUscita = AnnoUscita;
        this.lingua = lingua;
        this.nCopie = nCopie;
        this.ISBN = ISBN;
        this.dewey = dewey;

    }

    public String getTitolo() {

        return titolo;

    }

    public void setTitolo(String titolo) {

        this.titolo = titolo;

    }

    public int getnPagine() {

        return nPagine;

    }

    public void setnPagine(int nPagine) {

        this.nPagine = nPagine;

    }

    public String getCasaEditrice() {

        return CasaEditrice;

    }

    public void setCasaEditrice(String casaEditrice) {

        CasaEditrice = casaEditrice;

    }

    public int getAnnoUscita() {

        return AnnoUscita;

    }

    public void setAnnoUscita(int annoUscita) {

        AnnoUscita = annoUscita;

    }

    public String getLingua() {

        return lingua;

    }

    public void setLingua(String lingua) {

        this.lingua = lingua;

    }

    public int getnCopie() {

        return nCopie;

    }

    public void setnCopie(int nCopie) {

        this.nCopie = nCopie;

    }

    public String getISBN() {

        return ISBN;

    }

    public void setISBN(String ISBN) {

        this.ISBN = ISBN;

    }

    public int getDewey() {

        return dewey;

    }

    public void setDewey(int dewey) {

        this.dewey = dewey;

    }

    @Override
    public String toString() {

        return "Libro:" +
                "\ntitolo : " + titolo +
                "\nnPagine : " + nPagine +
                "\nCasaEditrice : " + CasaEditrice +
                "\nAnnoUscita : " + AnnoUscita +
                "\nlingua : " + lingua +
                "\nnCopie : " + nCopie +
                "\nISBN : " + ISBN +
                "\ndewey : " + dewey;

    }
}
