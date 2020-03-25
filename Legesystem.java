import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;



class Legesystem {


  //lister i systemet
  static SortertLenkeliste<Lege> legeliste = new SortertLenkeliste<Lege>();
  static Lenkeliste<Pasient> pasienter = new Lenkeliste<Pasient>();
  static Lenkeliste<Legemiddel> legemidler = new Lenkeliste<Legemiddel>();



      public static void main(String[] arg) {
          System.out.println("her starter legesystemet");
          lesFraFil();

          meny();
    /*
          System.out.println("Her listes nå legemidler: ");
          legemidler.printList();
          Lenkeliste<Resept> tester;
          System.out.println("Her listes nå leger og resepter: ");
          for (Lege g : legeliste) {
              System.out.println(g);
              tester = g.returnerResept();
              System.out.println(tester);
              for (Resept d : tester) {
                System.out.println("Her listes nå resept: ");
                  System.out.println(d);

              }
          }
    */
      }

      public static void meny() {
          Scanner lesInn = new Scanner(System.in);

          Boolean avslutt = false;

          while (!avslutt) {
            System.out.println("---- HOVEDMENY ---- \nGjoer ditt valg: ");
            System.out.println("** Velkommen til legesystemet ** \n Velg ditt alternativ: \n");
            System.out.println("1. Skriv ut fullstendig liste");
            System.out.println("2. Opprett og legg til nye elementer");
            System.out.println("3. Bruke resept");
            System.out.println("4. Skrive ut statistikk");
            System.out.println("5. Avslutt");

            int brukerInput = lesInn.nextInt();
              switch(brukerInput) {

                  case 1:
                      skrivUtAlt();
                  break;

                  case 2:
                  System.out.println("Hva vil du legge til? \n1. Lege \n2. Pasient\n3. Legemiddel\n4. Resept");
                  int brukerInp = lesInn.nextInt();
                      switch(brukerInp) {
                          case 1: //Legg til Lege
                              System.out.println("----Legge til Lege----");
                              //System.out.println("Skriv inn legens navn: ");

                              String[] legene = new String[2];
                              String[] varTextLege = {"Skriv inn legens navn: ", "Skriv inn legens ID hvis spesialist. Hvis ikke spesialist, trykk 0"};
                              lesInn.nextLine();

                              for (int i = 0; i<2; i++) {
                                  System.out.println(varTextLege[i]);
                                  legene[i] = lesInn.nextLine();
                              }

                              opprettLege(legene);
                              break;

                          case 2: //Legg til Pasient
                                System.out.println("----Legge til pasient----");

                                String[] pasienten = new String[2];
                                String[] varText = {"navn", "ID"};
                                lesInn.nextLine();
                                for (int i = 0; i<2; i++) {
                                    System.out.println("Skriv inn pasientens " + varText[i]);
                                    pasienten[i] = lesInn.nextLine();
                                }


                                opprettPasient(pasienten);
                                break;
                          case 3: //Legg til Legemiddel
                                System.out.println("----Legge til legemiddel----");
                                lesInn.nextLine();
                                String[] legemidlene = new String[5];
                                String[] varTextLegemiddel = {"navn:", "type:", "pris", "virkestoff:", "styrke (hvis ingen, skriv 0)", ""};

                                for (int i = 0; i<4; i++) {
                                    System.out.println("Skriv inn legemiddelets " + varTextLegemiddel[i]);
                                    legemidlene[i] = lesInn.nextLine();
                                }
                                opprettLegemiddel(legemidlene);
                                break;

                          case 4: //Legg til resept
                                System.out.println("----Legge til resept----");
                                lesInn.nextLine();
                                String[] reseptInn = new String[5];
                                String[] varTextResept = {"Legg til legemiddelnummer","legens navn","pasientens ID", "type resept:", "antall resepter:"};

                                for (int i = 0; i<5; i++) {
                                    System.out.println("Skriv inn " + varTextResept[i]);
                                    reseptInn[i] = lesInn.nextLine();
                                }
                                opprettResept(reseptInn);
                                break;
                      }

                  break;
                  case 3:
                        System.out.println("----Bruke til resept----");
                        System.out.println("Hvilken pasient vil du bruke resept for?");
                        lesInn.nextLine();
                        int i = 0;
                        for (Pasient p : pasienter) {
                            System.out.println(i + ": " + p.hentNavn() + " (foedselsnummer: " + p.hentFoedsel());
                            i++;
                          }
                        int pasInp = lesInn.nextInt();
                        Pasient dm = null;
                        for (Pasient pm : pasienter) {
                            if (pm.hentId() == pasInp) {
                              dm = pm;
                            }
                        }
                        System.out.println("Du har valgt "+ dm.hentNavn() + " (foedselsnummer: " + dm.hentFoedsel() + ")");
                        System.out.println("Hvilken resept vil du bruke?");

                        Liste<Resept> pasResepter = dm.hentResept();
                        int y = 0;
                        for (Resept re : pasResepter) {
                              System.out.println(y + ": " + re.hentLegemiddel().hentNavn() + " (" + re.hentReit() + " reit)");
                              y++;
                        }
                        pasInp = lesInn.nextInt();
                        Resept rp = null;
                        for (Resept re : pasResepter) {
                            if (re.hentId() == pasInp) {
                                rp = re;
                            }
                        }
                        if (rp.bruk() == true) {
                            System.out.println("Brukte resept paa " + rp.hentLegemiddel().hentNavn() + ". Antall gjenvaerende reit er " + rp.hentReit());
                        } else {
                            System.out.println("Det er ingen reit igjen");
                        }

                  break;
                  case 4:
                        lesInn.nextInt();
                        System.out.println("----Vis statisikk----");

                        System.out.println("1. Total utskrevne resepter på vanedannende midler");
                        System.out.println("2. Total utskrevne resepter på narkotiske midler");
                        System.out.println("3. Potensiell misbruk av narkotika (Leger)");
                        System.out.println("4. Potensiell misbruk av narkotika (Pasienter)");

                        pasInp = lesInn.nextInt();

                        switch(pasInp) {
                            case 1:
                                  lesInn.nextInt();
                                  System.out.println("1. Total utskrevne resepter på vanedannende midler:");
                                  System.out.println();
                                  int vaneCounter = 0;
                                  for (Lege dn : legeliste) {
                                      Liste<Resept> res1 = dn.returnerResept();
                                      for (Resept r : res1) {
                                          if (r.hentLegemiddel() instanceof Vanedannende) {
                                              vaneCounter++;
                                          }
                                      }
                                  }
                                  System.out.println("Antall: " + vaneCounter);
                            break;
                            case 2:

                            break;
                            case 3:

                            break;
                            case 4:
                            break;

                        }


                  break;
                  case 5:
                  avslutt = true;
                  break;
              }



        }

      }

      public static void skrivUtAlt() {
          System.out.println("Utskrift av legesystem \n");

          System.out.println("Pasienter i systemet: ");
          for (Pasient p : pasienter) {
              System.out.println(p);
          }

          System.out.println("\nLeger i systemet: ");
          for (Lege f : legeliste) {
              System.out.println(f);
          }

          System.out.println("\nLegemidler i systemet: ");
          for (Legemiddel v : legemidler) {
              System.out.println(v);
          }

          System.out.println("\nResepter i systemet: ");
          for (Lege s : legeliste) {
              s.hentResepter();
          }
      }



      //Henter fra fil
      public static void lesFraFil() {

            File inputFile = new File("innfil.txt");
            String temp = null;

            try {
            Scanner in = new Scanner(inputFile);

            while (in.hasNextLine()) {
                  String linje = in.nextLine();
                  //System.out.println(linje);
                  if (linje.startsWith("# Pasienter")) {
                      temp = "pasient";
                  } else if (linje.startsWith("# Legemidler")) {
                        temp = "legemidler";
                  } else if (linje.startsWith("# Leger")) {
                      temp = "leger";
                  } else if ((linje.startsWith("# Resepter"))) {
                      temp = "resepter";
                  } else {
                      String[] linjer = linje.split(",");
                      if (temp == "pasient") {
                          opprettPasient(linjer);
                          System.out.println("Pasient: " + linjer[0]);

                      } else if (temp == "legemidler") {
                          opprettLegemiddel(linjer);
                          System.out.println("legemiddel: " + linjer[1]);

                      } else if (temp == "leger") {
                          opprettLege(linjer);
                          //System.out.println("Lege: " + linjer[0]);

                      } else if (temp == "resepter") {
                          opprettResept(linjer);
                          System.out.println("Resept: " + linjer[0]);
                  }
            }

      }
      in.close();
    } catch (FileNotFoundException e) {
          System.out.println("Filen ikke funnet");
    }
}

      public static void opprettPasient(String[] linjer) {
          Pasient pasient = new Pasient(linjer[0], linjer[1]);
          pasienter.leggTil(pasient);
      }

      public static void opprettLegemiddel(String[] linjer) {
          String temp = linjer[1];

          System.out.println("Printer linje 1 legemiddel " + linjer[1]);
          if (temp.contains("narkotisk")) {
              Narkotisk narko = new Narkotisk(linjer[0], Double.parseDouble(linjer[2]), Double.parseDouble(linjer[3]), Integer.parseInt(linjer[4]));
              legemidler.leggTil(narko);
          }
          if (temp.contains("vanedannende")) {
              Vanedannende vane = new Vanedannende(linjer[0], Double.parseDouble(linjer[2]), Double.parseDouble(linjer[3]), Integer.parseInt(linjer[4]));
              legemidler.leggTil(vane);
          }
          if (temp.contains("vanlig")) {
              Vanlig van = new Vanlig(linjer[0], Double.parseDouble(linjer[2]), Double.parseDouble(linjer[3]));
              legemidler.leggTil(van);
            }
      }

      public static void opprettLege(String[] linjer) {
          if (linjer[1] != "0") {
              Spesialist spes = new Spesialist(linjer[0], Integer.parseInt(linjer[1]));
              legeliste.leggTil(spes);
          } else {
              Lege leg = new Lege(linjer[0]);
              legeliste.leggTil(leg);
          }
      }

      public static void opprettResept(String[] linjer) {
        //System.out.println("PRinter legemidler:");
        //legemidler.printList();
        Legemiddel b = null;
        Lege m = null;
        Pasient q = null;

        for (Legemiddel a : legemidler) {
            //System.out.println(a.hentNavn());

            if (a.hentId() == Integer.parseInt(linjer[0])) {
                //System.out.println("Dette er legemiddel id: " + a);
                b = a;
                //System.out.println("dette er b: " + b);
            }
        }

        for (Lege l : legeliste) {
            if (l.hentNavn().equals(linjer[1])) {
                //System.out.println("Her er legen: " + linjer[1]);
                m = l;

            }
            System.out.println(m);
        }
        for (Pasient p : pasienter) {
            if (p.hentId() == Integer.parseInt(linjer[2])) {
                q = p;
            }
        }

        //Oppretter resepter
        if (linjer[3].contains("hvit")) {
            try {
                System.out.println("Tester opprettelse av " + linjer[3]);
                m.skrivHvitResept(b, q, Integer.parseInt(linjer[4]));
            }
            catch (ulovligUtskrift e) {
                System.out.println("Ulovlig opprettelse av hvit resept");}
            }
        if (linjer[3].contains("blaa")) {
            try {
            System.out.println("Tester opprettelse av " + linjer[3]);
            m.skrivBlaaResept(b, q, Integer.parseInt(linjer[4]));
            //m.hentResepter();
            }
            catch (ulovligUtskrift e) {
                System.out.println("Ulovlig opprettelse av blaa resept");}
        }
        if (linjer[3].contains("militaer")) {
            try {
            System.out.println("Tester opprettelse av " + linjer[3]);
            m.skrivMilitaerresept(b, q, Integer.parseInt(linjer[4]));
            }
            catch (ulovligUtskrift e) {
                System.out.println("Ulovlig utskrift av militaer");}
        }
        if (linjer[3].contains("p")) {
            try {
            System.out.println("Tester opprettelse av " + linjer[3]);
            m.skrivPResept(b, q);
            }
            catch (ulovligUtskrift e) {
                System.out.println("Ulovlig utskrift av presept");}
        }


      }

}
