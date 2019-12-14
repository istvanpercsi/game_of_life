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
    return new Board(HashSet.ofAll(positions.map(position -> position.getNeighbours()).flatMap(pos->pos)));
  }

}
