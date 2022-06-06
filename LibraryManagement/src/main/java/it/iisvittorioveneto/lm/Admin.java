package it.iisvittorioveneto.lm;

public class Admin implements UtenteGenerico{

    private String nomeUtente;
    private String password;
    private String type;

    /**
     * Costruttore della classe Admin
     * @param nomeUtente
     * @param password
     */
    public Admin(String nomeUtente, String password) {

        this.nomeUtente = nomeUtente;
        this.password = password;
        this.type = "admin";

    }

    /**
     * Setter per nome utente
     * @param nomeUtente
     */
    @Override
    public void setNomeUtente(String nomeUtente) {

        this.nomeUtente = nomeUtente;

    }

    /**
     * Getter per password
     * @return
     */
    @Override
    public void setPassword(String password) {

        this.password = password;

    }

    /**
     * Getter per nome utente
     * @return
     */
    @Override
    public String getNome() {

        return nomeUtente;

    }

    /**
     * Getter per password
     * @return
     */
    @Override
    public String getPassword() {

        return password;

    }

    /**
     * toString informazioni Admin
     * @return
     */
    @Override
    public String toString() {

        return "Admin \n" + "nomeUtente = " + nomeUtente + "\npassword=" + password;

    }

}
