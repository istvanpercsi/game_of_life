package de.percsi.demo.gameoflife;

import de.percsi.demo.gameoflife.form.GameOfLifeFrame;
import de.percsi.demo.gameoflife.game.Position;
import io.vavr.collection.HashSet;
import io.vavr.collection.Set;

import javax.swing.*;
import java.awt.*;


public class GameOfLifeApp {

  private static final int MAX_WIDTH = 528;
  private static final int MAX_HEIGHT = 575;


  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      GameOfLifeFrame gameOfLifeFrame = new GameOfLifeFrame();
      gameOfLifeFrame.setTitle("Conway's Game of Life");
      gameOfLifeFrame.setSize(MAX_WIDTH,MAX_HEIGHT);
      gameOfLifeFrame.setMinimumSize(new Dimension(MAX_WIDTH,MAX_HEIGHT));
      gameOfLifeFrame.setMaximumSize(new Dimension(MAX_WIDTH, MAX_HEIGHT));
      gameOfLifeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gameOfLifeFrame.setResizable(false);
      gameOfLifeFrame.setVisible(true);
    });




  }
}
