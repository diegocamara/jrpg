package com.example.jrpg.item.equipment.weapon.ranger;

import com.example.jrpg.character.Stats;
import com.example.jrpg.character.ranger.Ranger;
import com.example.jrpg.item.equipment.weapon.Weapon;
import com.example.jrpg.item.modifier.Modifier;
import com.example.jrpg.item.modifier.Strength3Percent;

import java.util.Arrays;
import java.util.List;

public class BlasterSword extends Weapon<Ranger> {
  public BlasterSword() {
    super("Blaster Sword", "Blaster Sword Description");
  }

  @Override
  public List<Modifier<Stats>> modifiers() {
    return Arrays.asList(new Strength3Percent());
  }
}
