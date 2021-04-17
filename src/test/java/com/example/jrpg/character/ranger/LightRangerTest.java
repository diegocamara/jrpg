package com.example.jrpg.character.ranger;

import com.example.jrpg.character.*;
import com.example.jrpg.item.Item;
import com.example.jrpg.item.consumable.SmallHpPotion;
import com.example.jrpg.item.equipment.weapon.ranger.BlasterSword;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.stream.IntStream;

class LightRangerTest {

  @Test
  public void shouldCreateLightRanger() {

    final var level = 1;

    final var biography = new Biography("Light Ranger", "Light Ranger Description");

    final var healthPoints = ActionPoints.fromBase(Ranger.baseHealthPoints.toBigInteger());
    final var manaPoints = ActionPoints.fromBase(Ranger.baseManaPoints.toBigInteger());
    healthPoints.current(BigInteger.valueOf(29));
    final var strength = BigInteger.TEN;
    final var constitution = BigInteger.valueOf(4);
    final var dexterity = BigInteger.valueOf(4);
    final var intelligence = BigInteger.valueOf(5);
    final var wisdom = BigInteger.valueOf(6);
    final var charisma = BigInteger.valueOf(3);

    final var attributes =
        new Attributes(strength, constitution, dexterity, intelligence, wisdom, charisma);

    final var gold = BigInteger.ZERO;

    final var items = new LinkedList<Item>();

    final var inventory = new Inventory(gold, items);

    inventory.add(new SmallHpPotion());

    final var equipped = new Equipped<Ranger>();

    final var blasterSword = new BlasterSword();
    equipped.equip(blasterSword);
    final var experience = Experience.from(1);

    final var lightRanger =
        new LightRanger(
            level,
            biography,
            healthPoints,
            manaPoints,
            attributes,
            inventory,
            equipped,
            experience);

    lightRanger
        .inventory()
        .find(SmallHpPotion.class)
        .ifPresent(inventoryResult -> lightRanger.consumeItem(inventoryResult.item()));

    lightRanger
        .inventory()
        .find(BlasterSword.class)
        .ifPresent(
            blasterSwordInventoryResult ->
                lightRanger.equipped().equip(blasterSwordInventoryResult.item()));

    lightRanger.stats();

    IntStream.range(1, 100)
        .forEach(
            value -> {
              lightRanger.addExperience(BigInteger.valueOf(value));
              System.out.printf(
                  "level: %d, experience: %d/%d, hp: %d/%d, mp: %d/%d%n",
                  lightRanger.level(),
                  lightRanger.experience().current(),
                  lightRanger.experience().next(),
                  lightRanger.healthPoints().current(),
                  lightRanger.healthPoints().max(),
                  lightRanger.manaPoints().current(),
                  lightRanger.manaPoints().max());
            });
  }
}
