abstract class Legemiddel {
    protected String navn;
    protected double pris;
    protected double virkestoff;
    protected static int counter = 0;
    protected int id;

    {                                   //Oppretter en unik ID for hvert legemiddel
    id = counter;
    counter++;
    }

    protected Legemiddel(String nvn, double pri, double virke) {
        navn = nvn;
        pris = pri;
        virkestoff = virke;
    }

    public String toString() {        //Visning av objekt-innhold som string
        return ("ID: " + id + " Navn: " + navn + " Pris: " + pris + " Virkestoff: " + virkestoff);
    }

    public int hentId() {             //Returnerer ID til legemiddel
        return id;
    }

    public String hentNavn() {        //Returnerer navn på legemiddel
        return navn;
    }

    public double hentPris() {        //Returnerer pris på legemiddel
        return pris;
    }

    public double hentVirkestoff() {  //Returnerer virkestoff i legemiddel
        return virkestoff;
    }

    public void settNyPris(double nyPris) {
        pris = nyPris;
    }
}
