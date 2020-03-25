class Spesialist extends Lege implements Godkjenningsfritak {
    protected int kID;

    public Spesialist (String nav, int kontrollID) {
        super(nav);
        kID = kontrollID;
    }

    @Override
    public int hentKontrollID() {             //Returnerer kontroll ID på spesialist
        return kID;
    }
}
