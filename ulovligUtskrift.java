public class ulovligUtskrift extends Exception {
    ulovligUtskrift(Lege l, Legemiddel lm) {
        super("Legen "+l.hentNavn() + "har ikke lov til å skrive ut " + lm.hentNavn());
    }
}
