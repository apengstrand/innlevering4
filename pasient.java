class Pasient {
      protected String navn;
      protected String foedselsnummer;
      protected static int counter = 0;
      protected int id;
      protected Liste<Resept> resepter = new Stabel<Resept>();

      {                                   //Oppretter en unik ID for hver pasient
      id = counter;
      counter++;
      }

      public Pasient(String nav, String foedsel) {
          navn = nav;
          foedselsnummer = foedsel;
      }

public void leggTil(Resept res) {
      resepter.leggTil(res);
}

public void hentResepter() {
      resepter.printList();
}

public Liste<Resept> hentResept() {
      return resepter;
}

public String hentNavn() {
      return navn;
}

public int hentId() {
      return id;
}
public String hentFoedsel() {
      return foedselsnummer;
}

public String toString() {
    return (navn);

}

}
