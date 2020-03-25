class Stabel<T> extends Lenkeliste<T> {

    public void leggPaa(T x) {        //Legger til elementer paa slutten av listen
        leggTil(x);
    }

    public T taAv() {                 //Fjerne elementer fra slutten av listen
      T x = fjern(stoerrelse()-1);
        return x;
    }
}
