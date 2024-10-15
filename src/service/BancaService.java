package service;
import model.ContoBancario;
import model.Utente;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BancaService {

    private List<ContoBancario> contiBancari;

    public BancaService() {
        contiBancari = new ArrayList<>();
    }

    public ContoBancario creaContoBancario(Utente utente, double saldo) {

        ContoBancario contoBancario = new ContoBancario(utente, saldo);
        contiBancari.add(contoBancario);

        return contoBancario;
    }

    public void stampaTuttiContiBancari() {
        for (ContoBancario cc : contiBancari) {
            System.out.println(cc);
        }
    }

    public ContoBancario trovaContoByNumero(String numeroConto) {
        for (ContoBancario cc : contiBancari) {
            if (cc.getUtente().getNumeroConto().equals(numeroConto)) {
                return cc;
            }
        }
        return null;
    }
    public void visualizzaSaldo(String numeroConto) {
        // TODO: implementare metodo "trovaContoByNumero"

        ContoBancario cc = trovaContoByNumero(numeroConto);
        if(cc!=null){
            System.out.println("Il saldo è: " + cc.getSaldo());
        }else{
            System.out.println("Numero di conto errato");
        }
    }

    public void movimentiConto(String numeroConto, double importo){
        ContoBancario cc=trovaContoByNumero(numeroConto);
        if (cc!=null){

            if (importo!=0){
                double saldoAttuale = cc.getSaldo();
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String dataFormattata = now.format(formatter);
                if(importo <0 && saldoAttuale<=0){
                    System.out.println("Non puoi prelevare denaro. Se vuoi puoi fare un versamento");

                }else{
                    double nuovoSaldo = saldoAttuale+importo;
                   if(nuovoSaldo<0){
                       System.out.println("L'importo da prelevare è superiore al saldo");
                   }else{
                       cc.setSaldo(nuovoSaldo);
                       String operazione = "Denaro versato in data " + dataFormattata+ " per importo: " + importo;
                       cc.getOperazioni().add(operazione);
                       System.out.println((importo>0) ? "Hai depositato " + importo + " €. Il tuo saldo attuale è " + nuovoSaldo + " €":"Hai prelevato " + importo + " €. Il tuo saldo attuale è " + nuovoSaldo + "€");
                   }
                }
            }else{
                System.out.println("L'importo selezionato è " + importo);
            }
        }else{
            System.out.println("Conto corrente errato");
        }

    }
    public void visualizzaStorico(String numeroConto) {
        ContoBancario cc=trovaContoByNumero(numeroConto);
        if(cc!=null){

            System.out.println(cc.getOperazioni());

        }else{
            System.out.println("Conto non trovato");
        }
    }

}


   /*  // TODO: controllo che denaroDaVersare sia maggiore di 0. Eccezione altrimenti✅
    public void versaDenaro(String numeroConto, double denaroDaVersare) {

        // TODO: implementare metodo "trovaContoByNumero"
       for (ContoBancario cc : contiBancari) {
            if (cc.getUtente().getNumeroConto().equals(numeroConto)) {
                double saldoAttuale = cc.getSaldo();
                if (denaroDaVersare>0){
                    saldoAttuale += denaroDaVersare;
                    cc.setSaldo(saldoAttuale);
                    // TODO: Formattare data
                    String operazione = "Denaro versato in data " + LocalDateTime.now() + " per importo: " + denaroDaVersare;
                    cc.getOperazioni().add(operazione);
                }else{
                    System.out.println("Hai versato " + denaroDaVersare + ". Il tuo saldo attuale è " + saldoAttuale);}
                break;
            }
        }
    }


    // TODO: Mettere a "fattor comune" codice di preleva e versa

    public void prelevaDenaro(String numeroConto, double denaroDaPrelevare) {
        for (ContoBancario cc : contiBancari) {
            if (cc.getUtente().getNumeroConto().equals(numeroConto)) {
                double saldoAttuale = cc.getSaldo();
                if (saldoAttuale>denaroDaPrelevare){


                saldoAttuale -= denaroDaPrelevare;
                cc.setSaldo(saldoAttuale);

                String operazione = "Denaro prelevato in data " + LocalDateTime.now() + " per importo: " + denaroDaPrelevare;

                cc.getOperazioni().add(operazione);
                System.out.println("Hai prelevato " + denaroDaPrelevare + ". Il tuo saldo attuale è " +
                        saldoAttuale);}else{
                    System.out.println("Non hai potuto prelevare " + denaroDaPrelevare + " perchè il tuo saldo attuale è " +
                            saldoAttuale);
                }

                break;
            }
        }
    }*/


/*saldoAttuale += importo;
                    cc.setSaldo(saldoAttuale);
String operazione = "Denaro prelevato in data " + dataFormattata + " per importo: " + importo;
                    cc.getOperazioni().add(operazione);
                    System.out.println("Hai prelevato " + importo + " €. Il tuo saldo attuale è " + saldoAttuale + "€");*/