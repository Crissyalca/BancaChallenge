import model.ContoBancario;
import model.Utente;
import service.BancaService;

public class Main {
    public static void main(String[] args) {
        BancaService bancaService = new BancaService();
        String numeroContoTest = "A0001";
        String nomeUtente= "Andrea";
        Utente utente= new Utente(nomeUtente, numeroContoTest);
        ContoBancario cb= bancaService.creaContoBancario(utente, 0.00);
        String numeroContoTest1 = "A0002";
        String nomeUtente1= "Antonio";
        Utente utente1= new Utente(nomeUtente1, numeroContoTest1);
        ContoBancario cb1= bancaService.creaContoBancario(utente1, 2000000.00);
        String numeroContoTest2 = "A0003";
        String nomeUtente2= "Cristina";
        Utente utente2= new Utente(nomeUtente2, numeroContoTest2);
        ContoBancario cb2= bancaService.creaContoBancario(utente2, 2000000.00);


        /*ContoBancario cb = bancaService.creaContoBancario("Davide", numeroContoTest, 0.0 );*/

        bancaService.stampaTuttiContiBancari();
        System.out.println(cb);

        bancaService.visualizzaSaldo(numeroContoTest);

        bancaService.movimentiConto(numeroContoTest1, 100.00);
        bancaService.movimentiConto(numeroContoTest, -200.00);
        bancaService.movimentiConto("A0007", 0);

        bancaService.movimentiConto(numeroContoTest, 200.00);
        bancaService.movimentiConto(numeroContoTest2, -200.00);

        System.out.println("***** STAMPA DI TEST *****");
        System.out.println("Saldo atteso: 100.00");
        bancaService.stampaTuttiContiBancari();

        System.out.println("***** STAMPA STORICO *****");
        bancaService.visualizzaStorico(numeroContoTest);


    }
}