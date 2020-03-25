class testLegemiddel {
    public static void main (String[] args) {

        //Tester opprettelse av legemidler
        Narkotisk narko1 = new Narkotisk("Barbital", 362, 10, 15);
        Narkotisk narko2 = new Narkotisk("Morfin", 450, 40, 35);
        Vanedannende vane1 = new Vanedannende("Anxiolytica", 150.20, 15, 40);
        Vanedannende vane2 = new Vanedannende("Sedativa", 198.50, 20, 10);
        Vanlig vanlig1 = new Vanlig("Paracet", 39.50, 5);
        Vanlig vanlig2 = new Vanlig("Ibux", 36.50, 2);

        //Tester utskrift og metoder for klassene
        System.out.println("styrke er" + narko1.hentNarkotiskStyrke());
        System.out.println(narko1);
        System.out.println(narko2);

        System.out.println("styrke er" + narko1.hentNarkotiskStyrke());
        System.out.println("Dette er id på narko2: " + narko2.hentId());

        System.out.println("Dette er navn på vane1: " + vane1.hentNavn());
        System.out.println("Dette er pris på vanlig1: " + vanlig1.hentPris());
        vanlig1.settNyPris(48.30);
        System.out.println("Dette er pris på vanlig1: " + vanlig1.hentPris());
        System.out.println("Virkestoff for vanlig2: " + vanlig2.hentVirkestoff());


    }
}
