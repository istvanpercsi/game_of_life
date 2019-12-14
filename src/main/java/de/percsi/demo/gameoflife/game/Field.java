package de.percsi.demo.gameoflife.game;

import io.vavr.collection.HashSet;
import io.vavr.collection.Set;
import io.vavr.collection.Stream;
import lombok.Value;

@Value
public final class Field {
  private final int x;
  private final int y;

  public final Set<Field> getNeighbours() {
    return HashSet
          .ofAll(Stream.rangeClosed(x-1, x+1).map(mx -> Stream.rangeClosed(y-1, y+1).map(my -> new Field(mx,my))))
          .flatMap(fields -> fields).filter(filter -> !filter.equals(this));
  }
}
