package model;

public class Utente {
    private String nomeUtente;
    private String numeroConto;

    public Utente(String nomeUtente, String numeroConto) {
        this.nomeUtente = nomeUtente;
        this.numeroConto = numeroConto;
    }

    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getNumeroConto() {
        return numeroConto;
    }

    public void setNumeroConto(String numeroConto) {
        this.numeroConto = numeroConto;
    }
}
