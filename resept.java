abstract class Resept {

    protected int id;
    protected Legemiddel legemiddelId;
    protected Lege utskrivendeLege;
    protected Pasient pasientId;
    protected int reit;
    protected static int counter = 0;

    {                                   //Oppretter en unik ID for hver resept
    id = counter;
    counter++;
    }

    protected Resept (Legemiddel legemiddel, Lege utskriveLege, Pasient pas, int rei) {            //Setter til protected slik at den ikke kan aksesseres fra utsiden av klassen eller subklassene
        legemiddelId = legemiddel;
        utskrivendeLege = utskriveLege;
        pasientId = pas;
        reit = rei;
    }

    public String toString() {
        return ("id: " + id + " legemiddel: " + legemiddelId + " Lege: " + utskrivendeLege + " Pasient: " + pasientId);
    }

    public int hentId () {                  //Metode som returnerer id til resepten
        return id;
    }
    public Legemiddel hentLegemiddel () {   //Metode som returnerer legemiddel
        return legemiddelId;
    }


    public Lege hentLege () {               //returnerer lege
        return utskrivendeLege;

    }
    public Pasient hentPasientId () {           //Returnerer pasient ID
        return pasientId;

    }
    public int hentReit () {                //Returnerer antall reit
        return reit;
    }

    public boolean bruk () {                //Tester om Reit er stoerre enn null
        if (reit > 0) {
            reit = reit - 1;
            return true;
        } else {
            return false;
        }
    }

    abstract public String farge ();        //returnerer fargen på resepten

    abstract public double prisAaBetale (); //Abstract-metode for å hente pris på resepten

}
