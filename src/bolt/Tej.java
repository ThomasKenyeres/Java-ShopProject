package bolt;

import java.util.Date;

public class Tej {
    private int urtartalom;
    private String gyarto;
    private Date szavatossagiIdo;
    private double zsirtartalom;
    private long ar;

    public Tej(int urtartalom, String gyarto, Date szavatossagiIdo, double zsirtartalom, long ar) {
        this.urtartalom = urtartalom;
        this.gyarto = gyarto;
        this.szavatossagiIdo = szavatossagiIdo;
        this.zsirtartalom = zsirtartalom;
        this.ar = ar;
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

    public long getAr() {
        return ar;
    }

    @Override
    public String toString() {
        String result = "Jó még: " + joMeg();
        result += "; Űrtartalom: " + getUrtartalom();
        result += "; Gyártó: " + getGyarto();
        result += "; Szavatossági idő: " + getSzavatossagiIdo();
        result += "; Zsírtartalom: " + getZsirtartalom();
        result += "; Ár: " + getAr();
        return result;
    }
}