class TestPasient {
      public static void main(String[] args) {

          Pasient pas1 = new Pasient("Charlotte", "12345");
          Narkotisk narko1 = new Narkotisk("Barbital", 362, 10, 15);
          Narkotisk narko2 = new Narkotisk("Morfin", 450, 40, 35);
          Vanedannende vane1 = new Vanedannende("Anxiolytica", 150.20, 15, 40);
          Lege lege1 = new Lege("Sindre");

          //Resepter
          PResept presept1 = new PResept(narko1, lege1, pas1);
          PResept presept2 = new PResept(narko2, lege1, pas1);
          PResept presept3 = new PResept(vane1, lege1, pas1);

          pas1.leggTil(presept1);
          pas1.leggTil(presept2);
          pas1.leggTil(presept3);
          System.out.println("Skriv ut navn: " + pas1.hentNavn());
          System.out.println("Nå skrives ut resepter: \n ");
          pas1.hentResepter();

          //Tester iterator
          Lenkeliste<Integer> lst = new Lenkeliste<Integer>();
          for (int i = 0; i < 10; i++) {
            lst.leggTil(i);
          }

          for (Integer j : lst) {
            System.out.println(j);
          }
          System.out.println(lst.stoerrelse());


      }
}
