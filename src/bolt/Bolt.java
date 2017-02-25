package bolt;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Bolt {
    private String nev;
    private String cim;
    private String tulajdonos;
    private Hashtable elelmiszerpult;


    public Bolt(String nev, String cim, String tulajdonos, Hashtable elelmiszerpult) {
        this.nev = nev;
        this.cim = cim;
        this.tulajdonos = tulajdonos;
        this.elelmiszerpult = elelmiszerpult;
    }

    public Bolt(String nev, String cim, String tulajdonos) {
        this.nev = nev;
        this.cim = cim;
        this.tulajdonos = tulajdonos;
        this.elelmiszerpult = new Hashtable<Long, BoltBejegyzes>();
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

    public boolean vanMegAdottAru (Class c) {
        boolean result = false;
        Iterator iterator = elelmiszerpult.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            long kod = (long) entry.getKey();
            BoltBejegyzes bejegyzes = (BoltBejegyzes) entry.getValue();
            if (bejegyzes.getElelmiszer().getClass().equals(c)) {
                if (bejegyzes.getMennyiseg() > 0) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean vanMegTej() {
        return vanMegAdottAru(Tej.class);
    }
    
    public boolean vanMegSajt() {
        return vanMegAdottAru(Sajt.class);
    }

    public void vasarolElelmiszert(long vonalKod, long mennyiseg) {
        for (Object kod: elelmiszerpult.keySet()) {
            if (vonalKod == (long) kod) {
                BoltBejegyzes bejegyzes = (BoltBejegyzes) elelmiszerpult.get(vonalKod);
                long raktaron = bejegyzes.getMennyiseg();
                if (raktaron - mennyiseg > 0) {
                    bejegyzes.levonMennyiseg((int) mennyiseg);
                    elelmiszerpult.put(vonalKod, bejegyzes);
                }

            }
        }
    }

    public void feltoltElelmiszerrel(long vonalKod, long mennyiseg) {
        for (Object kod: elelmiszerpult.keySet()) {
            if ((long) kod == vonalKod) {
                BoltBejegyzes bejegyzes = (BoltBejegyzes) elelmiszerpult.get(vonalKod);
                bejegyzes.adMennyiseg((int) mennyiseg);
                elelmiszerpult.put(vonalKod, bejegyzes);
            }
        }

    }
    
    public void feltoltUjElelmiszerrel(Elelmiszer e, long mennyiseg, long ar) {
        long vonalKod = e.getVonalKod();
        elelmiszerpult.put(vonalKod, new BoltBejegyzes(e, mennyiseg, ar));
    }
    
    public void torolElelmiszert(long vonalKod) {
        for (Object kod: elelmiszerpult.keySet()) {
            if ((long) kod == vonalKod) {
                elelmiszerpult.remove(vonalKod);
            }
        }
    }

    public class BoltBejegyzes {
        private Elelmiszer e;
        private long mennyiseg;
        private long ar;

        public BoltBejegyzes(Elelmiszer e, long mennyiseg, long ar) {
            this.e = e;
            this.mennyiseg = mennyiseg;
            this.ar = ar;
        }

        public void adMennyiseg(long mennyiseg) {
            setMennyiseg(getMennyiseg() + mennyiseg);
        }

        public void levonMennyiseg(int mennyiseg) {
            setMennyiseg(getMennyiseg() - mennyiseg);
        }

        public Elelmiszer getElelmiszer() {
            return e;
        }

        public void setElelmiszer(Elelmiszer e) {
            this.e = e;
        }

        public long getMennyiseg() {
            return mennyiseg;
        }

        public void setMennyiseg(long mennyiseg) {
            this.mennyiseg = mennyiseg;
        }

        public long getAr() {
            return ar;
        }

        public void setAr(int ar) {
            this.ar = ar;
        }
    }

}
