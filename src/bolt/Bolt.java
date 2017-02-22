package bolt;

public class Bolt {
    private String nev;
    private String cim;
    private String tulajdonos;
    private Tej[] tejpult;


    public Bolt(String nev, String cim, String tulajdonos, Tej[] tejpult) {
        this.nev = nev;
        this.cim = cim;
        this.tulajdonos = tulajdonos;
        this.tejpult = tejpult;
    }

    public Bolt(String nev, String cim, String tulajdonos) {
        this.nev = nev;
        this.cim = cim;
        this.tulajdonos = tulajdonos;
    }

    public String getNev() {
        return nev;
    }

    public String getCim() {
        return cim;
    }

    public String getTulajdonos() {
        return tulajdonos;
    }

    public boolean vanMegTej() {
        for (int i = 0; i < tejpult.length; i++) {
            if (tejpult[i] != null) {
                return true;
            }
        }
        return false;
    }

    public Tej vasarolTej(Tej m) {
        Tej tej = null;
        Tej[] ujTejPult = new Tej[tejpult.length-1];
        boolean megveve = false;
        for (int i = 0; i < tejpult.length; i++) {
            Tej aktualisTej = tejpult[i];
            if (aktualisTej.equals(m)) {
                tej = aktualisTej;
                megveve = true;
            }
            else {
                if (megveve) {
                    ujTejPult[i-1] = tej;
                }
                else if (ujTejPult.length != i){
                    ujTejPult[i] = tej;
                }
            }
        }
        return tej;
    }

    public void feltoltTej(Tej m) {
        Tej[] ujTejPult = new Tej[tejpult.length + 1];
        for (int i = 0; i < tejpult.length; i++) {
            ujTejPult[i] = tejpult[i];
        }
        ujTejPult[ujTejPult.length - 1] = m;
        tejpult = ujTejPult;
    }

}
