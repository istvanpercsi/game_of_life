package de.percsi.demo.gameoflife.form;

import de.percsi.demo.gameoflife.game.Position;
import io.vavr.collection.HashSet;
import io.vavr.collection.Set;

public enum GameOfLifePatterns {
  //Spaceships
  GLIDER("Glider", HashSet.of(new Position(0,1), new Position(1,2),
        new Position(2,0), new Position(2,1), new Position(2,2))),
  LWSS("LWSS",HashSet.of(new Position(1,0), new Position(2,0), new Position(3,0),
        new Position(4,0), new Position(0,1), new Position(4,1), new Position(4,2),
        new Position(3,3), new Position(0, 3))),
  MWSS("MWSS", HashSet.of(new Position(1,0), new Position(2,0), new Position(3,0),
        new Position(4,0), new Position(5,0), new Position(0,1), new Position(5,1),
        new Position(5,2), new Position(4,3), new Position(2,4), new Position(0, 3))),

  //Pulsars
  BLINKER("Blinker",HashSet.of(new Position(0,0), new Position(1,0), new Position(2,0)));

  //

  private String name;

  private Set<Position> positions;

  GameOfLifePatterns(String name, Set<Position> positions) {
    this.name = name;
    this.positions = positions;
  }

  public String getName() {
    return this.name;
  }

  public Set<Position> getPositions() {
    return getPositions(0,0);
  }

  public Set<Position> getPositions(int offsetX, int offsetY) {
    return this.positions.map(position -> new Position(position.getX() + offsetX, position.getY() + offsetY));
  }
}
