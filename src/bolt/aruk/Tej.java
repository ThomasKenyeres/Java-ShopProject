package bolt.aruk;

import bolt.aruk.Elelmiszer;

import java.util.Date;

public abstract class Tej extends Elelmiszer {
    private long vonalKod;

    private final int LITER = 4;
    private final int FELLITER = 2;
    private final int POHAR = 1;
    private final double ZSIROS = 3.5;
    private final double FELZSIROS = 1.5;

    private int urtartalom;
    private String gyarto;
    private Date szavatossagiIdo;
    private double zsirtartalom;



    public Tej(long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
        super(vonalKod, gyarto, szavatossagiIdo);
        this.urtartalom = urtartalom;
        this.zsirtartalom = zsirtartalom;

    }

    public boolean joMeg() {
        Date date = new Date();
        if (date.after(szavatossagiIdo)) {
            return false;
        }
        return true;
    }

    public int getUrtartalom() {
        return urtartalom;
    }

    public String getGyarto() {
        return gyarto;
    }

    public Date getSzavatossagiIdo() {
        return szavatossagiIdo;
    }

    public double getZsirtartalom() {
        return zsirtartalom;
    }

    public long getVonalKod() {
        return vonalKod;
    }

    @Override
    public String toString() {
        String result = "Jó még: " + joMeg();
        result += "; Űrtartalom: " + getUrtartalom();
        result += "; Gyártó: " + getGyarto();
        result += "; Szavatossági idő: " + getSzavatossagiIdo();
        result += "; Zsírtartalom: " + getZsirtartalom();
        return result;
    }
}
