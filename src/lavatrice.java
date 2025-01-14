public class lavatrice {
    int temperatura = 20;
    stato st = stato.SPENTA;
    private boolean sportello = false, detersivoPresente = false;

    public opzioni accendi() {
        if (st == stato.SPENTA) {
            st = stato.STANDBY;
            return opzioni.ACCESO;
        }
        return opzioni.GIA_ACCESO;
    }

    public opzioni spegni() {
        if (st != stato.SPENTA) {
            st = stato.SPENTA;
            return opzioni.SPENTO;
        }
        return opzioni.GIA_SPENTO;
    }

    public opzioni aprisportello() {
        if (stato.LAVAGGIO_IN_CORSO != st) {
            if (!sportello) {
                sportello = true;
                return opzioni.SPORTELLO_APERTO;
            } else {
                return opzioni.SPORTELLO_GIA_APERTO;
            }

        } else {
            return opzioni.LAVAGGIO_IN_CORSO;
        }

    }

    public opzioni chiudisportello() {
        if (sportello) {
            sportello = false;
            return opzioni.SPORTELLO_CHIUSO;
        }
        return opzioni.SPORTELLO_GIA_CHIUSO;

    }

    public opzioni aggiungidetersivo() {
        if (!detersivoPresente) {
            detersivoPresente = true;
            return opzioni.DETERSIVO_AGGIUNTO;
        }
        return opzioni.DETERSIVO_GIA_AGGIUNTO;
    }

    public opzioni temperatura(int temperaturapp) {
        if (st == stato.STANDBY) {
            if (temperaturapp >= 20 && temperaturapp <= 90) {
                temperatura = temperaturapp;

                return opzioni.TEMPERATURA_IMPOSTATA;
            } else {

                return opzioni.TEMPERATURA_NON_VALIDA;
            }
        } else {
            return opzioni.TEMPERATURA_NON_IMPOSTABILE;
        }

    }

    public opzioni avvialavaggio() {
        if (st == stato.STANDBY) {
            if (detersivoPresente) {
                if (!sportello) {
                    st = stato.LAVAGGIO_IN_CORSO;
                    return opzioni.LAVAGGIO_AVVIATO;
                } else {
                    return opzioni.SPORTELLO_LAVAGGIO;
                }
            } else {

                return opzioni.DETERSIVO_LAVAGGIO;
            }
        } else {
            return opzioni.ACCESO_LAVAGGIO;
        }
    }

    public opzioni terminalavaggio() {
        if (st == stato.LAVAGGIO_IN_CORSO) {
            st = stato.STANDBY;
            return opzioni.LAVAGGIO_TERMINATO;
        }
        return opzioni.LAVAGGIO_GIA_TERMINATO;
    }
}
