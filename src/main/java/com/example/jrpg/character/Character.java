package com.example.jrpg.character;

import com.example.jrpg.item.consumable.Consumable;
import com.example.jrpg.item.equipment.Equipment;
import com.example.jrpg.item.modifier.Modifier;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@Accessors(fluent = true)
public abstract class Character<CHARACTER_CLASS> implements CharacterActions {

  @Min(value = 1)
  @Max(value = 100)
  private Integer level;

  @NotNull @Valid private final Biography biography;
  @NotNull @Valid private final ActionPoints healthPoints;
  @NotNull @Valid private final ActionPoints manaPoints;
  @NotNull @Valid private final Attributes attributes;
  @NotNull @Valid private final Inventory inventory;
  @NotNull @Valid private final Equipped<CHARACTER_CLASS> equipped;
  @NotNull @Valid private final Experience experience;

  public Character(
      Integer level,
      Biography biography,
      ActionPoints healthPoints,
      ActionPoints manaPoints,
      Attributes attributes,
      Inventory inventory,
      Equipped<CHARACTER_CLASS> equipped,
      Experience experience) {
    this.level = level;
    this.biography = biography;
    this.healthPoints = healthPoints;
    this.manaPoints = manaPoints;
    this.attributes = attributes;
    this.inventory = inventory;
    this.equipped = equipped;
    this.experience = experience;
  }

  protected abstract JobBonus jobBonus();

  protected abstract BigDecimal baseHealthPoints();

  protected abstract BigDecimal baseManaPoints();

  protected abstract void applyHealthPointsBonus();

  protected abstract void applyManaPointsBonus();

  public Stats stats() {
    final var stats = new Stats(healthPoints, manaPoints, attributes, equippedModifiers());
    //    equippedModifiers().forEach(statsModifier -> statsModifier.apply(stats));
    return stats;
  }

  private List<Equipment> equipment() {
    return Stream.of(equipped().weapon()).collect(Collectors.toList());
  }

  private List<Modifier<Stats>> equippedModifiers() {
    return equipment().stream()
        .map(Equipment::modifiers)
        .reduce(
            new LinkedList<>(),
            (partialModifiers, modifiers) -> {
              partialModifiers.addAll(modifiers);
              return partialModifiers;
            });
  }

  @Override
  public void consumeItem(Consumable consumable) {
    this.inventory.remove(consumable);
    consumable.consume(this);
  }

  public void addExperience(BigInteger amount) {
    this.experience.current(this.experience.current().add(amount));
    if (isLevelUp()) {
      this.experience.next(Experience.nextLevel(++this.level));
      applyAttributeBonus();
    }
  }

  private boolean isLevelUp() {
    return this.experience.current().compareTo(this.experience.next()) >= 0;
  }

  public void applyAttributeBonus() {
    applyHealthPointsBonus();
    applyManaPointsBonus();
  }
}
