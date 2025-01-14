import java.util.HashMap;

public class Lingue {
    String linguaCorrente;
    HashMap<String, HashMap<String, String>> contenuto = new HashMap<>();

    public Lingue(String linguaCorrente) {

        this.linguaCorrente = linguaCorrente;
        HashMap<String, String> italiano = new HashMap<>();

        italiano.put("menu", "Eccoci alla lavatrice! Che azione vuoi compiere?\n" +
                "1) Accendi la lavatrice\n" +
                "2) Spegni la lavatrice\n" +
                "3) Apri lo sportello\n" +
                "4) Chiudi lo sportello\n" +
                "5) Aggiungi il detersivo\n" +
                "6) Imposta la temperatura\n" +
                "7) Avvia il lavaggio\n" +
                "8) Termina il lavaggio\n" +
                "9) Esci");

        italiano.put("acceso", "Hai acceso la lavatrice");
        italiano.put("gia_acceso", "Lavatrice già accesa");
        italiano.put("spento", "Hai spento la lavatrice");
        italiano.put("gia_spento", "Lavatrice già spenta");
        italiano.put("sportello_aperto", "Hai aperto lo sportello");
        italiano.put("sportello_gia_aperto", "Lo sportello è già aperto.");
        italiano.put("lavaggio_in_corso",
                "La lavatrice non deve essere in corso di lavaggio se vuoi aprire lo sportello!");
        italiano.put("sportello_chiuso", "Hai chiuso lo sportello");
        italiano.put("sportello_gia_chiuso", "Lo sportello è già chiuso");
        italiano.put("detersivo_aggiunto", "Hai aggiunto il detersivo");
        italiano.put("detersivo_gia_aggiunto", "Il detersivo è già stato aggiunto!");
        italiano.put("lavaggio_avviato", "Hai avviato il lavaggio");
        italiano.put("sportello_lavaggio", "Per avviare il lavaggio lo sportello deve essere chiuso!");
        italiano.put("detersivo_lavaggio", "Per avviare il lavaggio il detersivo deve essere presente!");
        italiano.put("acceso_lavaggio", "Per avviare il lavaggio la lavatrice deve essere accesa!");
        italiano.put("lavaggio_terminato", "Hai terminato il lavaggio");
        italiano.put("lavaggio_gia_terminato", "Il lavaggio dev'essere in corso per poterlo terminare");
        italiano.put("temperatura_impostata", "Hai impostato la temperatura a: {temperatura} gradi");
        italiano.put("temperatura_non_valida", "Inserisci una temperatura valida (tra i 20 e i 90 gradi)");
        italiano.put("temperatura_non_impostabile",
                "La lavatrice dev'essere STANDBY per poter impostare la temperatura");
        contenuto.put("italiano", italiano);

        HashMap<String, String> inglese = new HashMap<>();

        inglese.put("menu", "Welcome to the washing machine! What action would you like to perform?\n" +
                "1) Turn on the washing machine\n" +
                "2) Turn off the washing machine\n" +
                "3) Open the door\n" +
                "4) Close the door\n" +
                "5) Add detergent\n" +
                "6) Set the temperature\n" +
                "7) Start the washing cycle\n" +
                "8) End the washing cycle\n" +
                "9) Exit");

        inglese.put("acceso", "You have turned on the washing machine");
        inglese.put("gia_acceso", "The washing machine is already on");
        inglese.put("spento", "You have turned off the washing machine");
        inglese.put("gia_spento", "The washing machine is already off");
        inglese.put("sportello_aperto", "You have opened the door");
        inglese.put("sportello_gia_aperto", "The door is already open.");
        inglese.put("lavaggio_in_corso", "The washing machine must not be running if you want to open the door!");
        inglese.put("sportello_chiuso", "You have closed the door");
        inglese.put("sportello_gia_chiuso", "The door is already closed");
        inglese.put("detersivo_aggiunto", "You have added detergent");
        inglese.put("detersivo_gia_aggiunto", "Detergent has already been added!");
        inglese.put("lavaggio_avviato", "You have started the wash");
        inglese.put("sportello_lavaggio", "To start the wash, the door must be closed!");
        inglese.put("detersivo_lavaggio", "To start the wash, detergent must be present!");
        inglese.put("acceso_lavaggio", "To start the wash, the washing machine must be on!");
        inglese.put("lavaggio_terminato", "You have finished the wash");
        inglese.put("lavaggio_gia_terminato", "The wash must be in progress to finish it");
        inglese.put("temperatura_impostata", "You have set the temperature to: {temperatura} degrees");
        inglese.put("temperatura_non_valida", "Enter a valid temperature (between 20 and 90 degrees)");
        inglese.put("temperatura_non_impostabile",
                "The washing machine must be in STANDBY mode to set the temperature");
        contenuto.put("inglese", inglese);
    }

    //Faccio un'altro metodo translate per comodità, specifico per temperatura, avremmo dovuto fare un intero sistema
    //per il placeholder a parte perché appunto metti che sta un pò ovunque e non è solo temperatura, ma evitiamo di
    //complicarci la vita con un intero sistema a parte
    public String translatePlaceholder(String key, String placeholder) {
        return translate(key).replace("{temperatura}", placeholder);
    }

    //Qui rimuovo il placeholder perché lo voglio lasciare come metodo translate semplice per dove non serve
    //anche se andava bene tenerlo per tutto in generale
    public String translate(String key) {
        return contenuto.get(linguaCorrente).get(key);
    }

    public boolean impostalingua(String lingua) {
        if (contenuto.containsKey(lingua)) {
            linguaCorrente = lingua;
            return true;
        }
        return false;
    }
}
