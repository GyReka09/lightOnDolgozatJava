
package test;
import lampa.Lampak;
import lampa.Lampa;
import java.awt.Color;
import java.util.ArrayList;


public class lampaTest {

    public static void main(String[] args) {
        lampaTest test = new lampaTest();
        test.setListaTest();
        test.randomListaTest();
        test.megfeleloLampa();
        test.kezdoListaFeltoltes();

        System.out.println("Minden teszt sikeresen lefutott!");
    }

    public void setListaTest() {
        Lampak lampak = new Lampak();
        Color eredetiSzin = lampak.getLamp(0).getSzin();
        lampak.setLista(0);
        Color ujSzin = lampak.getLamp(0).getSzin();

        assert eredetiSzin != ujSzin : "A színnek változnia kell";
        assert (ujSzin.equals(Color.orange) || ujSzin.equals(Color.green)) : "Színnek orange vagy green kell lennie";
    }

    public void randomListaTest() {
        Lampak lampak = new Lampak();
        lampak.randomListaFeltoltes();
        boolean vanGreen = false;
        boolean vanOrange = false;
        for (int i = 0; i < 9; i++) {
            Color szin = lampak.getLamp(i).getSzin();
            if (szin.equals(Color.green)) vanGreen = true;
            if (szin.equals(Color.orange)) vanOrange = true;
        }
        assert vanGreen : "Legalább egy green szín kell legyen";
        assert vanOrange : "Legalább egy orange szín kell legyen";
        System.out.println("randomListaTest() teszt sikeresen lefutott!");
    }

    public void megfeleloLampa() {
        Lampak lampak = new Lampak();
        for (int i = 0; i < 9; i++) {
            Lampa lampa = lampak.getLamp(i);
            assert lampa.getIndex() == i : "A lámpa indexe nem egyezik";
            assert lampa.getSzin() != null : "A lámpa színe nem lehet null";
        }
        System.out.println("megfeleloLampa() teszt sikeresen lefutott!");
    }

    public void kezdoListaFeltoltes() {
        Lampak lampak = new Lampak();
        ArrayList<Lampa> lista = lampak.kezdoListaFeltotes();
        for (int i = 0; i < 9; i++) {
            Color szin = lista.get(i).getSzin();
            if (i % 2 == 0) {
                assert szin.equals(Color.orange) : "Páros indexeken narancs kell legyen";
            } else {
                assert szin.equals(Color.green) : "Páratlan indexeken zöld kell legyen";
            }
        }
        System.out.println("kezdoListaFeltoltes teszt sikeresen lefutott!");
    }
}
