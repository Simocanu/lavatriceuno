public class Lavatrice {
    int temperatura = 20;
    StatoLavatrice st = StatoLavatrice.SPENTA;
    private boolean sportello = false, detersivoPresente = false;

    public Opzioni accendi() {
        if (st == StatoLavatrice.SPENTA) {
            st = StatoLavatrice.STANDBY;
            return Opzioni.ACCESO;
        }
        return Opzioni.GIA_ACCESO;
    }

    public Opzioni spegni() {
        if (st != StatoLavatrice.SPENTA) {
            st = StatoLavatrice.SPENTA;
            return Opzioni.SPENTO;
        }
        return Opzioni.GIA_SPENTO;
    }

    public Opzioni aprisportello() {
        if (StatoLavatrice.LAVAGGIO_IN_CORSO != st) {
            if (!sportello) {
                sportello = true;
                return Opzioni.SPORTELLO_APERTO;
            } else {
                return Opzioni.SPORTELLO_GIA_APERTO;
            }

        } else {
            return Opzioni.LAVAGGIO_IN_CORSO;
        }

    }

    public Opzioni chiudisportello() {
        if (sportello) {
            sportello = false;
            return Opzioni.SPORTELLO_CHIUSO;
        }
        return Opzioni.SPORTELLO_GIA_CHIUSO;

    }

    public Opzioni aggiungidetersivo() {
        if (!detersivoPresente) {
            detersivoPresente = true;
            return Opzioni.DETERSIVO_AGGIUNTO;
        }
        return Opzioni.DETERSIVO_GIA_AGGIUNTO;
    }

    public Opzioni temperatura(int temperaturapp) {
        if (st == StatoLavatrice.STANDBY) {
            if (temperaturapp >= 20 && temperaturapp <= 90) {
                temperatura = temperaturapp;

                return Opzioni.TEMPERATURA_IMPOSTATA;
            } else {

                return Opzioni.TEMPERATURA_NON_VALIDA;
            }
        } else {
            return Opzioni.TEMPERATURA_NON_IMPOSTABILE;
        }

    }

    public Opzioni avvialavaggio() {
        if (st == StatoLavatrice.STANDBY) {
            if (detersivoPresente) {
                if (!sportello) {
                    st = StatoLavatrice.LAVAGGIO_IN_CORSO;
                    return Opzioni.LAVAGGIO_AVVIATO;
                } else {
                    return Opzioni.SPORTELLO_LAVAGGIO;
                }
            } else {

                return Opzioni.DETERSIVO_LAVAGGIO;
            }
        } else {
            return Opzioni.ACCESO_LAVAGGIO;
        }
    }

    public Opzioni terminalavaggio() {
        if (st == StatoLavatrice.LAVAGGIO_IN_CORSO) {
            st = StatoLavatrice.STANDBY;
            return Opzioni.LAVAGGIO_TERMINATO;
        }
        return Opzioni.LAVAGGIO_GIA_TERMINATO;
    }
}
