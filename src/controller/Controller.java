
package controller;

import java.awt.Button;
import java.awt.Color;
import static java.awt.Color.green;
import static java.awt.Color.orange;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    run();
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
              view.getElozoAllapot().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elozoAllapotBetoltes();
                gombokSzinezese();
            }
        });
              view.getKilepesGomb().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kilepes();
            }
        });  
              view.getMentesGomb().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mentes();
            }
        });
  }
public void mentes() {
    try (PrintWriter pw = new PrintWriter(new FileWriter("allapot.txt"))) {
        for (int i = 0; i < lampaLista.getLista().size(); i++) {
            Color szin = lampaLista.getLamp(i).getSzin();
            if (szin.equals(orange)) {
                pw.println("orange");
            } else if (szin.equals(green)) {
                pw.println("green");
            } else {
                pw.println("unknown");
            }
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(view, "Hiba a mentés során: " + e.getMessage());
    }
}
public void randomEllenorzes(){
    int grn = 0;
    int orng = 0;
    for (int i = 0; i < lampaLista.getLista().size(); i++) {
        if(lampaLista.getLamp(i).getSzin() == orange){
            orng +=1;
        }if(lampaLista.getLamp(i).getSzin() == green){
            grn +=1;
        }
        
    }
    if(grn == 0 || orng == 0){
        lampaLista.randomListaFeltoltes();
    }
}

  public void kilepes() {
    int valasz = JOptionPane.showConfirmDialog(
            view,
            "Biztos ki akarsz lépni?",
            "Kilépés megerősítése",
            JOptionPane.YES_NO_OPTION
    );

    if (valasz == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
}
  public void elozoAllapotBetoltes() {
    try (BufferedReader br = new BufferedReader(new FileReader("allapot.txt"))) {
        String sor;
        int index = 0;
        while ((sor = br.readLine()) != null && index < lampaLista.getLista().size()) {
            if (sor.equals("orange")) {
                lampaLista.getLamp(index).setSzin(orange);
            } else if (sor.equals("green")) {
                lampaLista.getLamp(index).setSzin(green);
            }
            index++;
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(view, "Hiba a betöltés során: " + e.getMessage());
    }
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
