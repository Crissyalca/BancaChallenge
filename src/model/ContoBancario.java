package model;

import java.util.ArrayList;
import java.util.List;

public class ContoBancario {

    // TODO: prevedere classe/oggetto utente✅
private Utente utente;
    private double saldo;
    // TODO: rendere operazioni non stringhe ma classi
    private List<String> operazioni;

    public ContoBancario( Utente utente, double saldo) {
        this.utente=utente;
        this.saldo = saldo;
        operazioni = new ArrayList<>();

    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<String> getOperazioni() {
        return operazioni;
    }

    public void setOperazioni(List<String> operazioni) {
        this.operazioni = operazioni;
    }

    @Override
    public String toString() {
        return "Conto Bancario: " +
                "nome Utente='" + utente.getNomeUtente() + '\'' +
                ", numero Conto='" + utente.getNumeroConto() + '\'' +
                ", saldo=" + saldo +
                ", operazioni=" + operazioni +
                '.';
    }
}
