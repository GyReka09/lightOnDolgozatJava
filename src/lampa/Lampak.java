
package lampa;

import java.awt.Color;
import static java.awt.Color.green;
import static java.awt.Color.orange;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Lampak {
    private List<Lampa> lampaLista;
    private Lampa kivalasztott;
    public Lampak(){
        lampaLista = new ArrayList<>();
        lampaLista= kezdoListaFeltotes();
        
    }
    public ArrayList<Lampa> kezdoListaFeltotes(){
        ArrayList<Lampa>kezdoLista = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if(i % 2 == 0){
                kezdoLista.add(new Lampa(orange, i));
            }else{
                kezdoLista.add(new Lampa(green, i));
            }
        }
        return kezdoLista;
    }
    public void setLista(int index){
        if(this.lampaLista.get(index).getSzin()== orange){
            lampaLista.get(index).setSzin(green);
        }else{
            lampaLista.get(index).setSzin(orange);
        }
    }
    public ArrayList<Lampa> getLista(){
        return (ArrayList<Lampa>) this.lampaLista;
    }
    public Lampa getLamp(int index){
        return lampaLista.get(index);
    }
     public void randomListaFeltoltes() {
        Random rand = new Random();
        lampaLista = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            Color szin = rand.nextBoolean() ? orange : green;
            lampaLista.add(new Lampa(szin, i));
        }
        randomEllenorzes();
    }
     
    public void randomEllenorzes(){
    int grn = 0;
    int orng = 0;
    for (int i = 0; i < lampaLista.size(); i++) {
        if(lampaLista.get(i).getSzin() == orange){
            orng +=1;
        }
        if(lampaLista.get(i).getSzin() == green){
            grn +=1;
        }
    }
    if(grn == 0 || orng == 0){
        randomListaFeltoltes();
    }
}
}
