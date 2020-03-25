class Lege implements Comparable<Lege>{
    protected String navn;
    protected Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<Resept>();

    public Lege (String nav) {
        navn = nav;
    }

    public String hentNavn() {            //Returnerer navn på lege
        return navn;
    }

    public void hentResepter() {
          utskrevedeResepter.printList();
    }

    public Lenkeliste<Resept> returnerResept() {
          return utskrevedeResepter;
    }

    public int compareTo(Lege l) {
          int teller = this.navn.compareTo(l.hentNavn());
          return teller;
    }

    public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws ulovligUtskrift {
        if (legemiddel instanceof Narkotisk) throw new ulovligUtskrift(this, legemiddel);

        HvitResept hvit = new HvitResept(legemiddel, this, pasient, reit);
        utskrevedeResepter.leggTil(hvit);
        pasient.leggTil(hvit);
        return hvit;
    }

    public MilitaerResept skrivMilitaerresept(Legemiddel legemiddel, Pasient pasient, int reit) throws ulovligUtskrift {
        if (legemiddel instanceof Narkotisk) throw new ulovligUtskrift(this, legemiddel);

        MilitaerResept mili = new MilitaerResept(legemiddel, this, pasient, reit);
        utskrevedeResepter.leggTil(mili);
        pasient.leggTil(mili);
        return mili;
    }

    public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws ulovligUtskrift {
        if (legemiddel instanceof Narkotisk) throw new ulovligUtskrift(this, legemiddel);
        PResept presept = new PResept(legemiddel, this, pasient);
        utskrevedeResepter.leggTil(presept);
        pasient.leggTil(presept);
        return presept;
    }

    public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws ulovligUtskrift {
        if (legemiddel instanceof Narkotisk) throw new ulovligUtskrift(this, legemiddel);
        BlaaResept blaa = new BlaaResept(legemiddel, this, pasient, reit);
        utskrevedeResepter.leggTil(blaa);
        pasient.leggTil(blaa);
        return blaa;
    }


    public String toString() {
        return ("Lege: " + navn);
    }
}
