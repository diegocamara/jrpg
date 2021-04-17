package com.example.jrpg.item.equipment.weapon;

import com.example.jrpg.item.equipment.Equipment;

public abstract class Weapon<CHARACTER_CLASS> extends Equipment {

  public Weapon(String name, String description) {
    super(name, description);
  }
}
