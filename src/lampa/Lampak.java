
package lampa;

import static java.awt.Color.green;
import static java.awt.Color.orange;
import java.util.ArrayList;
import java.util.List;


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
}
