package com.example.jrpg.item;

import com.example.jrpg.character.Stats;
import com.example.jrpg.item.modifier.Modifier;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(fluent = true)
public abstract class Item {
  private final String name;
  private final String description;

  public Item(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public abstract List<Modifier<Stats>> modifiers();
}
