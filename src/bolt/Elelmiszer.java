package bolt;

import java.util.Date;

public abstract class Elelmiszer {
    long vonalKod;
    String gyarto;
    Date szavatossagiIdo;

    public Elelmiszer(long vonalKod, String gyarto, Date szavatossagiIdo) {
        this.vonalKod = vonalKod;
        this.gyarto = gyarto;
        this.szavatossagiIdo = szavatossagiIdo;
    }

    public boolean joMeg() {
        Date date = new Date();
        if (date.after(szavatossagiIdo)) {
            return false;
        }
        return true;
    }

    public long getVonalKod() {
        return vonalKod;
    }

    public String getGyarto() {
        return gyarto;
    }

    public Date getSzavatossagiIdo() {
        return szavatossagiIdo;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
