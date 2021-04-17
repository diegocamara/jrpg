package com.example.jrpg.item.modifier;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public abstract class Modifier<T> {

  private final String description;

  protected Modifier(String description) {
    this.description = description;
  }

  public abstract void apply(T t);
}
