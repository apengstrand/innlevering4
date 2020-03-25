public class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {

    @Override
    public void leggTil(T x) {         //Overskriver eksisterende metode
        Node ny_node = new Node(x);
        Node p = start;
        Node d = null;
        if (stoerrelse() == 0) {       //Sjekker foerst om det ligger noe i lenkelisten
            start = ny_node;
        } else if (ny_node.data.compareTo(p.data)<0) { //Sjekker om node skal legges foerst
            ny_node.neste = start;
            start = ny_node;
        } else if (ny_node.data.compareTo(hent(stoerrelse()-1))>0){
            super.leggTil(x);

        } else {
            while (p.data.compareTo(ny_node.data)<=0 && p.neste != null ){
                d = p;
                p = p.neste;
            }
            ny_node.neste = p;
            d.neste = ny_node;
        }
    }

    @Override
    public T fjern() {

      T b = null;
      Node fo = null;
      if (start == null) {
          throw new UgyldigListeIndeks(0);
      }
        Node p = start;
        if(start == null) {
            System.out.println("Listen er tom. Ingen node å slette");
            b = null;
        } else if (stoerrelse() == 1){
              start = null;
        }
          else {
              for (int i = 0; i < stoerrelse()-1; i++) {

                  fo = p;
                  p = p.neste;
                  if (p.neste == null) {
                      fo.neste = null;
                  }
              }
          }
          return p.data;
      }

      @Override     //Overskriver sett-metode slik at noder ikke kan settes paa spesifikke posisjoner
      public void sett(int pos, T x) {
        if (pos >= 0 || pos < 0) {
            throw new UnsupportedOperationException();
        }
      }

      @Override     //Overskriver sett-metode slik at noder ikke kan settes paa spesifikke posisjoner
      public void leggTil(int pos, T x) {
        if (pos >= 0 || pos < 0) {
            throw new UnsupportedOperationException();
        }
      }
}
