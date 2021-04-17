package com.example.jrpg.item.consumable;

import com.example.jrpg.character.Stats;
import com.example.jrpg.item.Item;
import com.example.jrpg.item.modifier.Modifier;

import java.util.LinkedList;
import java.util.List;

public abstract class Consumable extends Item implements ConsumableActions {
  public Consumable(String name, String description) {
    super(name, description);
  }

  @Override
  public List<Modifier<Stats>> modifiers() {
    return new LinkedList<>();
  }
}
