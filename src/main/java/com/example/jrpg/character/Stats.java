package com.example.jrpg.character;

import com.example.jrpg.item.modifier.Modifier;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.math.BigInteger;
import java.util.List;

@Getter
@Accessors(fluent = true)
public class Stats {
  private final ActionPoints healthPoints;
  private final ActionPoints manaPoints;
  private final Attributes attributes;
  private final List<Modifier<Stats>> modifiers;

  private BigInteger attackPower;
  private BigInteger defencePower;

  protected Stats(
      ActionPoints healthPoints,
      ActionPoints manaPoints,
      Attributes attributes,
      List<Modifier<Stats>> modifiers) {
    this.healthPoints = healthPoints;
    this.manaPoints = manaPoints;
    this.attributes = attributes;
    this.modifiers = modifiers;
    this.attackPower = attributes.strength();
    this.defencePower = attributes.constitution();
    this.modifiers.forEach(statsModifier -> statsModifier.apply(this));
  }

  public void increasesAttackPower(BigInteger amount) {
    this.attackPower = this.attackPower.add(amount);
  }

  public void decreasesAttackPower(BigInteger amount) {
    this.attackPower = this.attackPower.subtract(amount);
  }

  public void increasesDefensePower(BigInteger amount) {
    this.defencePower = this.defencePower.add(amount);
  }

  public void decreasesDefensePower(BigInteger amount) {
    this.defencePower = this.defencePower.subtract(amount);
  }
}
