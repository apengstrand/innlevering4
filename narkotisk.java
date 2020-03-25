class Narkotisk extends Legemiddel {
    protected int styrke;

    public Narkotisk (String nvn, double pri, double virke, int styrk) {
      super(nvn, pri, virke);
      styrke = styrk;
    }

    public int hentNarkotiskStyrke() {        //Returnerer narkotisk styrke
        return styrke;
    }

    public String toString() {
        return ("ID: " + id + " Navn: " + navn + " Pris: " + pris + " Virkestoff: " + virkestoff + " Styrke: " + styrke);
    }

}
