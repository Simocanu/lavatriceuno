import java.util.Scanner;

public class lavatrice {

    private boolean sportello = false, detersivoPresente = false;
    int temperatura = 20;
    stato st = stato.SPENTA;

    public boolean accendi() {
        if (st == stato.SPENTA) {
            st = stato.STANDBY;
            return true;
        }
        return false;
    }

    public boolean spegni() {
        if (st != stato.SPENTA) {
            st = stato.SPENTA;
            return true;
        }
        return false;
    }

    public void aprisportello() {
        if (stato.LAVAGGIO_IN_CORSO != st) {
            if (!sportello) {
                System.out.println(" ");
                System.out.println("Hai aperto lo sportello");
                System.out.println(" ");
                sportello = true;
            } else {
                System.out.println(" ");
                System.out.println("Lo sportello è già aperto.");
                System.out.println(" ");
            }

        } else {
            System.out.println(" ");
            System.out.println("La lavatrice non deve essere in corso di lavaggio se vuoi aprire lo sportello!");
            System.out.println(" ");
        }

    }

    public boolean chiudisportello() {
        if (sportello) {
            sportello = false;
            return true;
        }
        return false;

    }

    public boolean aggiungidetersivo() {
        if (!detersivoPresente) {
            detersivoPresente = true;
            return true;
        }
        return false;
    }

    public void temperatura(int temperaturapp) {
        if (st == stato.STANDBY) {
            if (temperaturapp >= 20 && temperaturapp <= 90) {
                temperatura = temperaturapp;
                System.out.println(" ");
                System.out.println("Hai impostato la temperatura a: " + temperatura + " gradi");
                System.out.println(" ");
            } else {
                System.out.println(" ");
                System.out.println("Inserisci una temperatura valida (tra i 20 e i 90 gradi)");
                System.out.println(" ");
            }
        } else {
            System.out.println(" ");
            System.out.println("La lavatrice dev'essere STANDBY per poter impostare la temperatura");
            System.out.println(" ");
        }

    }

    public void avvialavaggio() {
        if (st == stato.STANDBY) {
            if (detersivoPresente) {
                if (!sportello) {
                    System.out.println(" ");
                    System.out.println("Hai avviato il lavaggio a: " + temperatura + " gradi");
                    System.out.println(" ");

                    st = stato.LAVAGGIO_IN_CORSO;
                } else {
                    System.out.println(" ");
                    System.out.println("Per avviare il lavaggio lo sportello deve essere chiuso!");
                    System.out.println("");
                }
            } else {
                System.out.println(" ");
                System.out.println("Per avviare il lavaggio il detersivo deve essere presente!");
                System.out.println(" ");

            }
        } else {
            System.out.println(" ");
            System.out.println("Per avviare il lavaggio la lavatrice deve essere accesa!");
            System.out.println(" ");
        }
    }

    public boolean terminalavaggio() {
        if (st == stato.LAVAGGIO_IN_CORSO) {
            st = stato.STANDBY;
            return true;
        }
        return false;
    }

}
