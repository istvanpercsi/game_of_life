package de.percsi.demo.gameoflife.form;

import de.percsi.demo.gameoflife.game.Field;
import io.vavr.collection.Set;

import javax.swing.*;

public class GameOfLifeFrame extends JFrame {
  private JPanel playField;

  public GameOfLifeFrame() {
    this.playField = new PlayField();
    this.add(this.playField);
  }

  public void setFields(Set<Field> fields) {
    ((PlayField) this.playField).setFields(fields);
  }


}
