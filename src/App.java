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
                    if (la.accendi()) {
                        System.out.println(" ");
                        System.out.println("Hai acceso la lavatrice");
                        System.out.println(" ");
                    } else {
                        System.out.println(" ");
                        System.out.println("Lavatrice già accesa");
                        System.out.println(" ");
                    }

                    break;
                case 2:
                    if (la.spegni()) {
                        System.out.println(" ");
                        System.out.println("Hai spento la lavatrice");
                        System.out.println(" ");
                    } else {
                        System.out.println(" ");
                        System.out.println("Lavatrice già spenta");
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    la.aprisportello();
                    break;
                case 4:
                    if (la.chiudisportello()) {
                        System.out.println(" ");
                        System.out.println("Hai chiuso lo sportello");
                        System.out.println(" ");
                    } else {
                        System.out.println(" ");
                        System.out.println("Lo sportello è già chiuso");
                        System.out.println(" ");
                    }
                    break;
                case 5:
                    if (la.aggiungidetersivo()) {
                        System.out.println("Hai aggiunto il detersivo");
                    } else {
                        System.out.println("Il detersivo è già stato aggiunto!");
                    }

                    break;
                case 6:
                    System.out.println(" ");
                    System.out.println("Imposta la temperatura (tra i 20 e i 90 gradi)");
                    System.out.println(" ");
                    int temperaturapp = sc.nextInt();
                    sc.nextLine();
                    la.temperatura(temperaturapp);
                    break;
                case 7:
                    la.avvialavaggio();
                    break;
                case 8:
                    if (la.terminalavaggio()) {
                        System.out.println(" ");
                        System.out.println("Hai terminato il lavaggio");
                        System.out.println(" ");
                    } else {
                        System.out.println(" ");
                        System.out.println("Il lavaggio dev'essere in corso per poterlo terminare");
                        System.out.println(" ");
                    }
                    break;
                case 9:
                    System.out.println("Arrivederci.");
                    esci = true;
                    break;

            }
        }

    }
}
