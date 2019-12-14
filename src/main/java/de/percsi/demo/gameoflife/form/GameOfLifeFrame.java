package de.percsi.demo.gameoflife.form;

import de.percsi.demo.gameoflife.game.Position;
import io.vavr.collection.Set;

import javax.swing.*;

public class GameOfLifeFrame extends JFrame {
  private JPanel playField;

  public GameOfLifeFrame() {
    this.playField = new PlayBoard();
    this.add(this.playField);
  }

  public void setFields(Set<Position> fields) {
    ((PlayBoard) this.playField).setStartPositions(fields);
  }


}
