class testLege {
	public static void main(String[] arg) {
		Lege l1 = new Lege("Nafstad");
		Lege l2 = new Lege("Stian");
		Lege l3 = new Lege("Hedvig");
		System.out.println(l1.compareTo(l2));
		System.out.println(l2.compareTo(l1));
		System.out.println(l1.compareTo(l1));
		SortertLenkeliste<Lege> sLst = new SortertLenkeliste<Lege>();
		sLst.leggTil(l1);
		sLst.leggTil(l2);
		sLst.leggTil(l3);

    Narkotisk narko1 = new Narkotisk("Barbital", 362, 10, 15);
    Pasient pas1 = new Pasient("Charlotte", "12345");
    Vanedannende vane1 = new Vanedannende("Anxiolytica", 150.20, 15, 40);

    try {
    l1.skrivBlaaResept(narko1, pas1, 3);
    }

    catch (ulovligUtskrift e) {
        System.out.println("Ulovlig utskrift av militaer");
    }

    try {
    l2.skrivHvitResept(vane1, pas1, 3);
    }

    catch (ulovligUtskrift e) {
        System.out.println("Ulovlig utskrift av hvitresept");
    }

    Lenkeliste<Resept> tester;

		for (Lege l : sLst) {
			System.out.println(l.hentNavn());
      tester = l.returnerResept();
      for (Resept d : tester) {
          System.out.println(d);
      }
		}
	}
}
