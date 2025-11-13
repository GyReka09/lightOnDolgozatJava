
package controller;

import java.awt.Button;
import static java.awt.Color.orange;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import lampa.Lampak;
import view.View;


public class Controller {
private Lampak lampaLista;
private View view;
private List<JButton>buttonList;

public Controller(){
    this.lampaLista = new Lampak();
    this.view = new View();
    btnListener();
    run();
    this.buttonList = Arrays.asList(
        view.getjButton1(),
        view.getjButton2(),
        view.getjButton3(),
        view.getjButton4(),
        view.getjButton5(),
        view.getjButton6(),
        view.getjButton7(),
        view.getjButton8(),
        view.getjButton9()
    );
    gombokSzinezese();
   
}
  private void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                view.setVisible(true);
            }
        });
    }
  public void btnListener(){
          view.getjButton1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                szomszedokValtoztatasa(0);
                gombokSzinezese();
                nyeremenyEllenorzes();
            }
        });
           view.getjButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                szomszedokValtoztatasa(1);
                gombokSzinezese();
                nyeremenyEllenorzes();
            }
        });
           view.getjButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                szomszedokValtoztatasa(2);
                gombokSzinezese();
                nyeremenyEllenorzes();
            }
        });
            view.getjButton4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                szomszedokValtoztatasa(3);
                gombokSzinezese();
                nyeremenyEllenorzes();

            }
        });
            view.getjButton5().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                szomszedokValtoztatasa(4);
                gombokSzinezese();
                nyeremenyEllenorzes();

            }
        });
            view.getjButton6().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                szomszedokValtoztatasa(5);
                gombokSzinezese();
                nyeremenyEllenorzes();
            }
        });
            view.getjButton7().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                szomszedokValtoztatasa(6);
                gombokSzinezese();
                nyeremenyEllenorzes();

            }
        });
           view.getjButton8().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                szomszedokValtoztatasa(7);
                gombokSzinezese();
                nyeremenyEllenorzes();

            }
        });
           view.getjButton9().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                szomszedokValtoztatasa(8);
                gombokSzinezese();
                nyeremenyEllenorzes();

            }
        });
              view.getNewGame().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lampaLista.randomListaFeltoltes();
                gombokSzinezese();
            }
        });
  }
    public void szomszedokValtoztatasa(int id) {
    lampaLista.setLista(id);
    if (id % 3 != 0) {
      this.lampaLista.setLista(id - 1);
    }
    if (id % 3 != 2) {
      this.lampaLista.setLista(id+1);
    }
    if (id > 2) {
      this.lampaLista.setLista(id -3);
    }
    if (id < 6) {
      this.lampaLista.setLista(id +3);
    }
  };
    public void gombokSzinezese(){
        for (int i = 0; i < lampaLista.getLista().size(); i++) {
            buttonList.get(i).setBackground(lampaLista.getLamp(i).getSzin());
        }
    }
    public void nyeremenyEllenorzes(){
        boolean nyert= true;
        for (int i = 0; i < lampaLista.getLista().size(); i++) {
            if(lampaLista.getLamp(i).getSzin() == orange){
                nyert= false;
            }
            
        }
        if(nyert){
            JOptionPane.showMessageDialog(view, "grat nyertél!");
        }
    }
    
}
