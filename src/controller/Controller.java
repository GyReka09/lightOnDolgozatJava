
package controller;

import lampa.Lampak;
import view.View;


public class Controller {
private Lampak lampaLista;
private View view;

public Controller(){
    this.lampaLista = new Lampak();
    this.view = new View();
    run();
}
  private void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                view.setVisible(true);
            }
        });
    }
}
