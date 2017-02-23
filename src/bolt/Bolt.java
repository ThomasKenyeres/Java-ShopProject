package bolt;

import java.util.Hashtable;
import java.util.Iterator;

public class Bolt {
    private String nev;
    private String cim;
    private String tulajdonos;
    private Hashtable tejpult;


    public Bolt(String nev, String cim, String tulajdonos, Hashtable tejpult) {
        this.nev = nev;
        this.cim = cim;
        this.tulajdonos = tulajdonos;
        this.tejpult = tejpult;
    }

    public Bolt(String nev, String cim, String tulajdonos) {
        this.nev = nev;
        this.cim = cim;
        this.tulajdonos = tulajdonos;
        this.tejpult = new Hashtable<Tej, Integer>();
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
        if (tejpult.isEmpty()) {
            return false;
        }
        return true;
    }

    public Tej vasarolTej(long vonalKod) {
        Iterator iterator = tejpult.keySet().iterator();
        Tej tej = null;
        while (iterator.hasNext()) {
            Tej aktualisTej = (Tej) iterator.next();
            if (aktualisTej.getVonalKod() == vonalKod) {
                tej = aktualisTej;
                Integer value = (Integer) tejpult.get(tej);
                if (value > 1) {
                    tejpult.put(tej, --value);
                }
                else {
                    tejpult.remove(tej);
                }
            }
        }
        return tej;
    }

    public void feltoltTej(Tej m) {
        if (tejpult.containsKey(m)) {
            Integer value = (Integer) tejpult.get(m);
            tejpult.put(m, ++value);
        }
        else {
            tejpult.put(m, 1);
        }
    }

    public class BoltBejegyzes {
        private Tej t;
        private int mennyiseg;
        private int ar;

        public BoltBejegyzes(Tej t, int mennyiseg, int ar) {
            this.t = t;
            this.mennyiseg = mennyiseg;
            this.ar = ar;
        }

        public void adMennyiseg(int mennyiseg) {
            setMennyiseg(getMennyiseg() + mennyiseg);
        }

        public void levonMennyiseg(int mennyiseg) {
            setMennyiseg(getMennyiseg() - mennyiseg);
        }

        public Tej getT() {
            return t;
        }

        public void setT(Tej t) {
            this.t = t;
        }

        public int getMennyiseg() {
            return mennyiseg;
        }

        public void setMennyiseg(int mennyiseg) {
            this.mennyiseg = mennyiseg;
        }

        public int getAr() {
            return ar;
        }

        public void setAr(int ar) {
            this.ar = ar;
        }
    }

}
