package bolt;

import bolt.aruk.Sajt;
import bolt.aruk.Szappan;
import bolt.aruk.Tej;
import bolt.aruk.tej.FeltartosTej;
import bolt.aruk.tej.TartosTej;

import java.util.Date;

public class BoltFactory {
    public BoltFactory() {

    }

    public Tej ujTartosTej(Long vonalKod, int urtartalom,
                           String gyarto, Date szavatossagiIdo, double zsirtartalom) {
        return new TartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, zsirtartalom);
    }

    public Tej ujFeltartosTej(Long vonalKod, int urtartalom,
                           String gyarto, Date szavatossagiIdo, double zsirtartalom) {
        return new FeltartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, zsirtartalom);
    }

    public Tej ujFelzsirosTartosTej(Long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo) {
        return ujTartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, Tej.FELZSIROS);
    }

    public Tej ujZsirosTartosTej(Long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo) {
        return ujTartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, Tej.ZSIROS);
    }

    public Tej ujFelzsirosFeltartosTej(Long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo) {
        return ujFeltartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, Tej.FELZSIROS);
    }

    public Tej ujZsirosFeltartosTej(Long vonalKod, int urtartalom, String gyarto, Date szavatossagiIdo) {
        return ujFeltartosTej(vonalKod, urtartalom, gyarto, szavatossagiIdo, Tej.ZSIROS);
    }

    public Tej ujFelzsirosLiteresTartosTej(Long vonalKod, String gyarto, Date szavatossagiIdo) {
        return ujFelzsirosTartosTej(vonalKod, Tej.LITER, gyarto, szavatossagiIdo);
    }

    public Tej ujZsirosLiteresTartosTej(Long vonalKod, String gyarto, Date szavatossagiIdo) {
        return ujZsirosTartosTej(vonalKod, Tej.LITER, gyarto, szavatossagiIdo);
    }

    public Tej ujFelzsirosLiteresFeltartosTej(Long vonalKod, String gyarto, Date szavatossagiIdo) {
        return ujFelzsirosFeltartosTej(vonalKod, Tej.LITER, gyarto, szavatossagiIdo);
    }

    public Tej ujZsirosLiteresFeltartosTej(Long vonalKod, String gyarto, Date szavatossagiIdo) {
        return ujZsirosFeltartosTej(vonalKod, Tej.LITER, gyarto, szavatossagiIdo);
    }


    public Sajt ujSajt(Long vonalKod, double suly, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
        return new Sajt(vonalKod, gyarto, szavatossagiIdo);
    }

    public Szappan ujSzappan(Long vonalKod, String gyarto, char mosohatas) {
        return new Szappan(vonalKod, gyarto, mosohatas);
    }

    public Szappan ujAMosohatasuSzappan(Long vonalKod, String gyarto) {
        return ujSzappan(vonalKod, gyarto, 'A');
    }

}
