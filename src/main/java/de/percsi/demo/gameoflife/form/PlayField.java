package de.percsi.demo.gameoflife.form;

import de.percsi.demo.gameoflife.game.Field;
import io.vavr.collection.Set;

import javax.swing.*;
import java.awt.*;

public class PlayField extends JPanel {

  private Set<Field> fields;

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.RED);
    fields.forEach(field -> {
      g.fillRect(field.getX() * 10,field.getY() * 10, 10, 10);
    });

  }

  public void setFields(Set<Field> fields) {
    this.fields = fields;
    repaint();
  }
}
