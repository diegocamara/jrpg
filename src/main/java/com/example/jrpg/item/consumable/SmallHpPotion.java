package com.example.jrpg.item.consumable;

import com.example.jrpg.character.Character;

import java.math.BigInteger;

public class SmallHpPotion extends Consumable {

  public SmallHpPotion() {
    super("Small HP Portion", "Restores 50 points of health.");
  }

  @Override
  public void consume(Character<?> character) {
    final var healthPoints = character.healthPoints();
    final var result = healthPoints.current().add(BigInteger.valueOf(50)).min(healthPoints.max());
    healthPoints.current(result);
  }
}
