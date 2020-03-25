class Vanedannende extends Legemiddel {
    protected int styrke;

    public Vanedannende(String nvn, double pri, double virke, int styrk) {
      super(nvn, pri, virke);
      styrke = styrk;
    }

    public int hentVanedannendeStyrke() {
        return styrke;
    }

    public String toString() {
        return ("ID: " + id + " Navn: " + navn + " Pris: " + pris + " Virkestoff: " + virkestoff + " Styrke: " + styrke);
    }


}
