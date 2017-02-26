package bolt.aruk;

import bolt.Aru;

public class Szappan extends Aru {
    char mosohatas;
    public Szappan(Long vonalKod, String gyarto, char mosohatas) {
        super(vonalKod, gyarto);
        setMosohatas(mosohatas);
    }

    public char getMosohatas() {
        return mosohatas;
    }

    private void setMosohatas(char mosohatas) {
        this.mosohatas = mosohatas;
    }
}
