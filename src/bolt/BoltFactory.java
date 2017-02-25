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

    public Sajt ujSajt(Long vonalKod, double suly, String gyarto, Date szavatossagiIdo, double zsirtartalom) {
        return new Sajt(vonalKod, gyarto, szavatossagiIdo);
    }

    public Szappan ujSzappan(Long vonalKod, String gyarto, char mosohatas) {
        return new Szappan();
    }

}
