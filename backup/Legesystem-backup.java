import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

class Legesystem {

      //lister i systemet
      protected SortertLenkeliste<Lege> legeliste = new SortertLenkeliste<Lege>();
      protected Lenkeliste<Pasient> pasienter = new Lenkeliste<Pasient>();
      protected Lenkeliste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();


      //Henter fra fil
      public void lesFraFil() throws FileNotFoundException {
            File inputFile = new File("innfil.txt");
            Scanner in = new Scanner(inputFile);
            String temp = null;

            while (in.hasNextLine()) {
                  String linje = in.nextLine();
                  if (linje.startsWith("# Pasienter")) {
                      temp = "pasient";
                  } else if (linje.startsWith("# Leger")) {
                      temp = "leger";
                  } else if (linje.startsWith("# Legemidler")) {
                      temp = "legemidler";
                  } else if ((linje.startsWith("# Resepter"))) {
                      temp = "resepter";
                  } else {
                      String[] linjer = linje.split(",");
                      if (temp == "pasient") {
                          
                          Pasient pas = new Pasient(linjer[0], linjer[1]);
                      } else if (temp == "legemidler") {

                          if (linjer[1] == "narkotisk") {
                              Narkotisk narko = new Narkotisk(linjer[0], linjer[2], linjer[3], linjer[4]);
                          } else if (linjer[1] == "vanedannende") {
                              Vanedannende vane = new Vanedannende(linjer[0], linjer[2], linjer[3], linjer[4]);
                          } else if (linjer[1] == "vanlig") {
                              Vanlig van = new Vanlig(linjer[0], linjer[2], linjer[3]);
                          }

                      } else if (temp == "leger") {
                          if (linjer[1] != 0) {
                              Spesialist spes = new Spesialist(linjer[0], linjer[1]);
                          } else {
                            Lege leg = new Lege(linjer[0]);

                          }


                      } else if (temp == "resepter") {

                          for (Legemiddel a : legemidler) {
                              if (a.hentId() == linjer[0]) {
                                  Legemiddel b = a;
                              }
                          }

                          for (Lege l : legeliste) {
                              if (l.hentNavn() == linjer[1]) {
                                  Lege m = l;
                              }
                          }
                          for (Pasient p : pasienter) {
                              if (p.hentNavn() == linjer[2]) {
                                  Pasient q = p;
                              }
                          }

                          //Oppretter resepter
                          if (linjer[3] == "hvit") {
                              m.skrivHvitResept(b, q, linjer[4]);
                          }
                          if (linjer[3] == "blaa") {
                              m.skrivBlaaResept(b, q, linjer[4]);
                          }
                          if (linjer[3] == "militaer") {
                              m.skrivMilitaerresept(b, q, linjer[4]);
                          }
                          if (linjer[3] == "p") {
                              m.skrivPResept(b, q);
                          }

                  }
            }
            in.close();


      }
}
    public void opprettPasient(String[] linje, String temp) {
        Pasient pas = new Pasient(linje[0], linjer[1]);
    }

    public void opprettLegemiddel(String[], String temp) {
    } else if (temp == "legemidler") {
        if (linjer[1] == "narkotisk") {
            Narkotisk narko = new Narkotisk(linjer[0], linjer[2], linjer[3], linjer[4]);
        } else if (linjer[1] == "vanedannende") {
            Vanedannende vane = new Vanedannende(linjer[0], linjer[2], linjer[3], linjer[4]);
        } else if (linjer[1] == "vanlig") {
            Vanlig van = new Vanlig(linjer[0], linjer[2], linjer[3]);
        }
    }

}
