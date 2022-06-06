package it.iisvittorioveneto.lm;

public class UtenteRegistrato implements UtenteGenerico {

    private String nomeUtente;
    private String password;
    private final String type;

    /**
     * Costruttore della classe UtenteRegistrato
     *
     * @param nomeUtente nome dell'utente
     * @param password password dell'utente
     */
    public UtenteRegistrato(String nomeUtente, String password, String type) {

        this.nomeUtente = nomeUtente;
        this.password = password;
        this.type = "utente";

    }

    /**
     * Metodo che permette di settare il nome dell'utente
     * @param nomeUtente
     */
    @Override
    public void setNomeUtente(String nomeUtente) {

        this.nomeUtente = nomeUtente;

    }

    /**
     * Metodo che permette di settare la password dell'utente
     * @param password
     */
    @Override
    public void setPassword(String password) {

        this.password = password;

    }

    /**
     * Metodo che permette di ottenere il nome dell'utente
     * @return nome dell'utente
     */
    @Override
    public String getNome() {

        return nomeUtente;

    }

    /**
     * Metodo che permette di ottenere la password dell'utente
     * @return password dell'utente
     */
    @Override
    public String getPassword() {

        return password;

    }

}
