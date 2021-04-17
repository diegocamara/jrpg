package com.example.jrpg.item.modifier;

import com.example.jrpg.character.Stats;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Strength3Percent extends Modifier<Stats> {

  public Strength3Percent() {
    super("Increases 3 percent of strength");
  }

  @Override
  public void apply(Stats stats) {
    final var attributes = stats.attributes();
    final var currentStrength = new BigDecimal(attributes.strength());
    final var result =
        currentStrength.add(
            currentStrength
                .multiply(BigDecimal.valueOf(3))
                .divide(BigDecimal.valueOf(100), 0, RoundingMode.UP));
    stats.increasesAttackPower(result.toBigInteger());
  }
}
