package de.percsi.demo.gameoflife.form;

import de.percsi.demo.gameoflife.game.Position;
import io.vavr.collection.HashSet;
import io.vavr.collection.Set;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GameOfLifeFrame extends JFrame implements ActionListener, ItemListener {

  private JMenuBar mainMenu;

  private JPanel playField;

  public GameOfLifeFrame() {
    createMainMenu();
    this.setJMenuBar(this.mainMenu);
    this.playField = new GameOfLifeJPanel();
    this.add(this.playField);
  }

  public void setFields(Set<Position> fields) {
    ((GameOfLifeJPanel) this.playField).setStartPositions(fields);
  }

  private void createMainMenu() {
    this.mainMenu = new JMenuBar();
    JMenu patterns = new JMenu("Patterns");
    JMenu spaceships = new JMenu("Spaceships");
    patterns.add(spaceships);
    //Glider menu
    JMenuItem glider = new JMenuItem(GameOfLifePatterns.GLIDER.getName());
    spaceships.add(glider);
    glider.addActionListener(this);

    //LWSS - Light weight space ship
    JMenuItem lwss = new JMenuItem(GameOfLifePatterns.LWSS.getName());
    spaceships.add(lwss);
    lwss.addActionListener(this);

    //MWSS - Middle weight space ship
    JMenuItem mwss = new JMenuItem(GameOfLifePatterns.MWSS.getName());
    spaceships.add(mwss);
    mwss.addActionListener(this);
    
    this.mainMenu.add(patterns);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    JMenuItem menuItem = (JMenuItem) e.getSource();
    if (menuItem.getText().equals(GameOfLifePatterns.GLIDER.getName())) {
      this.setFields(GameOfLifePatterns.GLIDER.getPositions(5,2));
    } else if (menuItem.getText().equals(GameOfLifePatterns.LWSS.getName())) {
      this.setFields(GameOfLifePatterns.LWSS.getPositions(5,5));
    } else if (menuItem.getText().equals(GameOfLifePatterns.MWSS.getName())) {
      this.setFields(GameOfLifePatterns.MWSS.getPositions(4,4));
    }
  }
  @Override
  public void itemStateChanged(ItemEvent e) {

  }
}
