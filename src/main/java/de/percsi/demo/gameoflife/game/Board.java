package de.percsi.demo.gameoflife.game;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import lombok.Value;

@Value
public class Board {

  public final static int MAX_WIDTH = 50;
  public final static int MAX_HEIGHT = 50;

  Set<Position> positions;

  public Board(Set<Position> positions) {
    this.positions = positions;
  }

  public Board getNextGenerationBoard() {
    return new Board(HashSet.ofAll(this.positions.map(position -> position.getNeighbours().map(this::correct))
          .flatMap(pos->pos)).filter(this::willBeAlive));
  }

  private boolean willBeAlive(Position position) {
    int n = position.getNeighbours().map(this::correct).count(this.positions::contains);
    return ( n == 3  || (n == 2 && isAlive(position)));
  }

  private boolean isAlive(Position position) {
    return this.positions.contains(position);
  }


  private Position correct(Position position) {
    return new Position(position.getX() < 0 ? MAX_WIDTH - 1 : (position.getX() > MAX_WIDTH - 1) ? 0 : position.getX(),
                (position.getY() < 0) ? MAX_HEIGHT -1 : (position.getY() > MAX_HEIGHT - 1) ? 0 : position.getY());
  }
}
