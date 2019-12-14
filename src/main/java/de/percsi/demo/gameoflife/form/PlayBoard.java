package de.percsi.demo.gameoflife.form;

import de.percsi.demo.gameoflife.game.Board;
import de.percsi.demo.gameoflife.game.Position;
import io.vavr.collection.Set;
import io.vavr.collection.Stream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayBoard extends JPanel implements ActionListener {

  private Board board;

  private Timer timer = new Timer(300, this);

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.RED);
    this.board.getPositions()
          .forEach(position -> g.fillRect(position.getX() * 10 + 10,position.getY() * 10 + 10, 10, 10));
    g.setColor(Color.LIGHT_GRAY);
    g.drawRect(10,10,500,500);
    Stream.range(2, 51).forEach(mx -> g.drawLine(mx * 10, 10, mx * 10, 510));
    Stream.range(2, 51).forEach(my -> g.drawLine(10, my * 10, 510, my * 10));
  }

  void setStartPositions(Set<Position> fields) {
    this.board = new Board(fields);
    repaint();
    timer.start();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.board = this.board.getNextGenerationBoard();
    repaint();
  }
}
