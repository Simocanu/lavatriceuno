import java.util.Scanner;

public class App {
    public static Lingue li;

    public static void main(String[] args) throws Exception {

        li = new Lingue("inglese");
        Lavatrice la = new Lavatrice();
        Scanner sc = new Scanner(System.in);
        boolean esci = false;

        while (!esci) {
            System.out.println(li.translate("menu"));

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
                    if (la.st == StatoLavatrice.STANDBY) {
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

    public static void mostraMessaggio(Opzioni opzione) {
        System.out.println(li.translate(opzione.name().toLowerCase()));
    }

    //avevo dimenticato che avevamo una funzione a parte per la temperatura
    public static void mostraTemperatura(int temperatura, Opzioni opzione) {
        System.out.println(li.translatePlaceholder(opzione.name().toLowerCase(), temperatura + ""));
    }
}
