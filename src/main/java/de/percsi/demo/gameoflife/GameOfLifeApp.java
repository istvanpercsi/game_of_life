package de.percsi.demo.gameoflife;

import de.percsi.demo.gameoflife.form.GameOfLifeFrame;
import de.percsi.demo.gameoflife.game.Field;
import io.vavr.collection.HashSet;

import javax.swing.*;
import java.awt.*;


public class GameOfLifeApp {

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        GameOfLifeFrame gameOfLifeFrame = new GameOfLifeFrame();
        gameOfLifeFrame.setTitle("Conway's Game of Life");
        gameOfLifeFrame.setSize(520,520);
        gameOfLifeFrame.setMinimumSize(new Dimension(500,500));
        gameOfLifeFrame.setMaximumSize(new Dimension(500, 500));
        gameOfLifeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameOfLifeFrame.setResizable(false);
        gameOfLifeFrame.setVisible(true);
        gameOfLifeFrame.setFields(HashSet.of(new Field(49,10)));
      }
    });



  }
}
