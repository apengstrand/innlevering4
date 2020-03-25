import java.util.Iterator;

class Lenkeliste<T> implements Liste<T> {

    class Node {                    //Oppretter node
        Node neste = null;
        T data;
        Node (T x) {
            data = x;
        }
    }

    protected Node start = null;


    class LenkelisteIterator implements Iterator<T> {

        Node p = start;

        public boolean hasNext() {
            return p != null;
        }

        public T next () {
            if (hasNext()) {
                T da = p.data;
                p = p.neste;
                return da;
            }
            return null;
        }
        //void remove(){}
        //
    }

    public Iterator<T> iterator() {
      return new LenkelisteIterator();
    }

    public int stoerrelse() {  //Returnerer antall noder i listen. Forutsetter at nodene ikke er null
        Node p = start;
        int n = 0;

        while (p != null) {
            n++;
            p = p.neste;
        }
        return n;
    }

    public void leggTil(int pos, T x) {
      if (pos < 0 || pos > stoerrelse()) {
          throw new UgyldigListeIndeks(pos);
      }
      Node p = start;
      Node n = new Node(x);
      Node forrige = null;

      if (pos == 0) {
          start = n;
          n.neste = p;
          return;

      } else if (pos == stoerrelse()){          //Dersom posisjon er paa slutten av listen
          leggTil(x);
        }
        else {
        for (int i = 0; i < pos; i++) {         //Dersom posisjon ikke er 0 og ikke er slutten
            p = p.neste;
            Node d = p.neste;
            p.neste = n;
            n.neste = d;
            return;
        }
      }
    }

    public void printList() {
        Node p = start;
        while (p != null) {
            System.out.println(p.data);
            p = p.neste;
        }
    }

    public void leggTil(T x) {                  //Setter inn et element på slutten av listen
        if (stoerrelse() == 0) {                //Sjekker foerst om det ligger noe i start-variabelen
            start = new Node(x);
        } else {
            Node p = start;
            for (int i = 0; i < stoerrelse(); i++) {

                if (p.neste != null) {
                    p = p.neste;
                } else {
                    Node n = new Node(x);
                    p.neste = n;
                  }
            }
          }
    }


    public void sett(int pos, T x) {              //Setter inn en nytt objekt på posisjonen som angitt. Eksisterende rekke må legges inn i neste-peker i nytt node-objekt
          if (pos < 0 || pos > (stoerrelse()-1) || start == null) {
              throw new UgyldigListeIndeks(pos);
          }
          Node p = start;
          Node n = new Node(x);
          int i = 0;
          if (pos == 0) {                         //Hvis posisjon er lik startposisjon
              start = n;
              start.neste = p.neste;

          } else if (pos == stoerrelse()){          //Dersom posisjon er paa slutten av listen
            leggTil(x);

          } else {

            while(i < pos - 1) {
                p = p.neste;
                i++;
            }
            Node d = p.neste.neste;
            n.neste = d;
            p.neste = n;

          }
      }

    public T hent(int pos) {            //Henter elementet med angitt posisjon
        if (pos < 0 || pos > (stoerrelse()-1) || start == null) {
            throw new UgyldigListeIndeks(pos);
        }
          Node p = start;
          for (int i = 0; i<pos; i++) {
              p = p.neste;

          }
          return p.data;
    }

    public T fjern(int pos) {           //Fjerner node på angitt posisjon
        if (pos < 0 || pos > (stoerrelse()-1) || start == null) {
            throw new UgyldigListeIndeks(pos);
        }

        Node p = start;
        T b = null;
        int i = 0;
        if(p == null) {
            System.out.println("Listen er tom");

        } else if (p.neste == null) {

                  b = p.data;
                  start = null;

              }
         else {

             while(i < pos - 1) {
                 p = p.neste;
                 i++;
             }
             Node n = p.neste;
             p.neste = n.neste;
             b = n.data;
              }
            return b;
        }


    public T fjern() {                  //Metode som fjerner og returnerer elementet paa starten av listen
        if (start == null) {
            throw new UgyldigListeIndeks(0);
        }

          Node p = start;
          Node n;
          if(start == null) {
              System.out.println("Listen er tom. Ingen node å slette");
              return null;
            } else {
                start = start.neste;
              }
          return p.data;
          }


}
