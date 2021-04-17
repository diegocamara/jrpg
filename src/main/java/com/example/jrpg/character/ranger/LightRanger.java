package com.example.jrpg.character.ranger;

import com.example.jrpg.character.*;

import java.math.BigDecimal;

public class LightRanger extends Ranger {

  private static final JobBonus jobBonus;

  static {
    final var strength = BigDecimal.valueOf(0.8);
    final var constitution = BigDecimal.valueOf(0.4);
    final var dexterity = BigDecimal.valueOf(0.3);
    final var intelligence = BigDecimal.valueOf(0.2);
    final var wisdom = BigDecimal.valueOf(0.4);
    final var charisma = BigDecimal.valueOf(0.4);
    jobBonus = new JobBonus(strength, constitution, dexterity, intelligence, wisdom, charisma);
  }

  public LightRanger(
      Integer level,
      Biography biography,
      ActionPoints healthPoints,
      ActionPoints manaPoints,
      Attributes attributes,
      Inventory inventory,
      Equipped<Ranger> equipped,
      Experience experience) {
    super(level, biography, healthPoints, manaPoints, attributes, inventory, equipped, experience);
  }

  @Override
  public JobBonus jobBonus() {
    return jobBonus;
  }
}
