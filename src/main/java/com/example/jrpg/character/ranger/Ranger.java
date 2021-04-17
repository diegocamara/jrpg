package com.example.jrpg.character.ranger;

import com.example.jrpg.character.Character;
import com.example.jrpg.character.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@Accessors(fluent = true)
public abstract class Ranger extends Character<Ranger> {

  public static final JobBonus jobBonus;
  public static final BigDecimal baseHealthPoints = BigDecimal.valueOf(80);
  public static final BigDecimal baseManaPoints = BigDecimal.valueOf(14);

  static {
    final var strength = BigDecimal.valueOf(0.8);
    final var constitution = BigDecimal.valueOf(0.4);
    final var dexterity = BigDecimal.valueOf(0.3);
    final var intelligence = BigDecimal.valueOf(0.2);
    final var wisdom = BigDecimal.valueOf(0.2);
    final var charisma = BigDecimal.valueOf(0.4);
    jobBonus = new JobBonus(strength, constitution, dexterity, intelligence, wisdom, charisma);
  }

  public Ranger(
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

  @Override
  protected BigDecimal baseHealthPoints() {
    return baseHealthPoints;
  }

  @Override
  protected BigDecimal baseManaPoints() {
    return baseManaPoints;
  }

  @Override
  protected void applyHealthPointsBonus() {
    final var constitution = jobBonus().constitution();
    final var levelMaxHealthPoints =
        baseHealthPoints
            .multiply(BigDecimal.valueOf(Math.pow(level().longValue(), constitution.doubleValue())))
            .setScale(0, RoundingMode.FLOOR)
            .toBigInteger();
    this.healthPoints().current(levelMaxHealthPoints);
    this.healthPoints().max(levelMaxHealthPoints);
  }

  @Override
  protected void applyManaPointsBonus() {
    var wisdom = jobBonus().wisdom();
    final var levelMaxManaPoints =
        baseManaPoints
            .multiply(BigDecimal.valueOf(Math.pow(level().longValue(), wisdom.doubleValue())))
            .setScale(0, RoundingMode.FLOOR)
            .toBigInteger();
    this.manaPoints().current(levelMaxManaPoints);
    this.manaPoints().max(levelMaxManaPoints);
  }
}
