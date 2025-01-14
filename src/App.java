import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Lingue lingue = new Lingue("inglese");
        Lavatrice la = new Lavatrice();
        Scanner sc = new Scanner(System.in);
        boolean esci = false;

        while (!esci) {
            System.out.println(lingue.translate("menu"));

            int scelta = sc.nextInt();
            sc.nextLine();

            switch (scelta) {
                case 1:
                    lingue.translate(la.accendi().name().toLowerCase());
                    break;
                case 2:
                    lingue.translate(la.spegni().name().toLowerCase());
                    break;
                case 3:
                    lingue.translate(la.aprisportello().name().toLowerCase());
                    break;
                case 4:
                    lingue.translate(la.chiudisportello().name().toLowerCase());
                    break;
                case 5:
                    lingue.translate(la.aggiungidetersivo().name().toLowerCase());
                    break;
                case 6:
                    if (la.st == StatoLavatrice.STANDBY) {
                        System.out.println(lingue.translate("chiedi_temperatura"));
                        scelta = sc.nextInt();
                    }
                    lingue.translatePlaceholder(la.temperatura(scelta).name().toLowerCase(), scelta + "");

                    break;
                case 7:
                    lingue.translate(la.avvialavaggio().name().toLowerCase());
                    break;
                case 8:
                    lingue.translate(la.terminalavaggio().name().toLowerCase());
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

}
