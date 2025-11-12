
package lampa;

import java.awt.Color;


public class Lampa {
    private Color szin;
    private int index;
    public Lampa(Color szin, int index){
        this.szin = szin;
        this.index= index;
    }
    public int getIndex(){
        return this.index;
    }

    public Color getSzin() {
        return szin;
    }

    public void setSzin(Color szin) {
        this.szin = szin;
    }    
}
