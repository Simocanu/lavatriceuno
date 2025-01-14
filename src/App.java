import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        lavatrice la = new lavatrice();
        Scanner sc = new Scanner(System.in);
        boolean esci = false;

        while (!esci) {
            System.out.println("Eccoci alla lavatrice! Che azione vuoi compiere?");
            System.out.println("1) Accendi lavatrice");
            System.out.println("2) Spegni lavatrice");
            System.out.println("3) Apri sportello");
            System.out.println("4) Chiudi sportello");
            System.out.println("5) Aggiungi detersivo");
            System.out.println("6) Imposta la temperatura");
            System.out.println("7) Avvia il lavaggio");
            System.out.println("8) Termina il lavaggio");
            System.out.println("9) Esci");

            int scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {
                case 1:
                    mostraMessaggio(la.accendi());
                    break;
                case 2:
                    mostraMessaggio(la.spegni());
                    break;
                case 3:
                    mostraMessaggio(la.aprisportello());
                    break;
                case 4:
                    mostraMessaggio(la.chiudisportello());
                    break;
                case 5:
                    mostraMessaggio(la.aggiungidetersivo());
                    break;
                case 6:
                    if (la.st == stato.STANDBY) {
                        System.out.println("Inserisci la temperatura tra 20 e 90 gradi");
                        scelta = sc.nextInt();                       
                    }
                    mostraTemperatura(scelta, la.temperatura(scelta));

                    break;
                case 7:
                    mostraMessaggio(la.avvialavaggio());
                    break;
                case 8:
                    mostraMessaggio(la.terminalavaggio());
                    break;
                case 9:
                    System.out.println("Arrivederci.");
                    esci = true;
                    break;

            }
            System.out.println();
        }
        sc.close();
    }

    public static void mostraMessaggio(opzioni opzione) {
        switch (opzione) {
            case ACCESO -> System.out.println("Hai acceso la lavatrice");
            case GIA_ACCESO -> System.out.println("Lavatrice già accesa");
            case SPENTO -> System.out.println("Hai spento la lavatrice");
            case GIA_SPENTO -> System.out.println("Lavatrice già spenta");
            case SPORTELLO_APERTO -> System.out.println("Hai aperto lo sportello");
            case SPORTELLO_GIA_APERTO -> System.out.println("Lo sportello è già aperto.");
            case LAVAGGIO_IN_CORSO ->
                System.out.println("La lavatrice non deve essere in corso di lavaggio se vuoi aprire lo sportello!");
            case SPORTELLO_CHIUSO -> System.out.println("Hai chiuso lo sportello");
            case SPORTELLO_GIA_CHIUSO -> System.out.println("Lo sportello è già chiuso");
            case DETERSIVO_AGGIUNTO -> System.out.println("Hai aggiunto il detersivo");
            case DETERSIVO_GIA_AGGIUNTO -> System.out.println("Il detersivo è già stato aggiunto!");
            case LAVAGGIO_AVVIATO -> System.out.println("Hai avviato il lavaggio");
            case SPORTELLO_LAVAGGIO -> System.out.println("Per avviare il lavaggio lo sportello deve essere chiuso!");
            case DETERSIVO_LAVAGGIO -> System.out.println("Per avviare il lavaggio il detersivo deve essere presente!");
            case ACCESO_LAVAGGIO -> System.out.println("Per avviare il lavaggio la lavatrice deve essere accesa!");
            case LAVAGGIO_TERMINATO -> System.out.println("Hai terminato il lavaggio");
            case LAVAGGIO_GIA_TERMINATO -> System.out.println("Il lavaggio dev'essere in corso per poterlo terminare");
            default -> System.out.println("Opzione non valida.");
        }
    }

    public static void mostraTemperatura(int temperatura, opzioni opzione) {
        switch (opzione) {
            case TEMPERATURA_IMPOSTATA ->
                System.out.println("Hai impostato la temperatura a: " + temperatura + " gradi");
            case TEMPERATURA_NON_VALIDA ->
                System.out.println("Inserisci una temperatura valida (tra i 20 e i 90 gradi)");
            case TEMPERATURA_NON_IMPOSTABILE ->
                System.out.println("La lavatrice dev'essere STANDBY per poter impostare la temperatura");
            default ->
                System.out.println("No.");
        }

    }
}
