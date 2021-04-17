package com.example.jrpg.item.equipment;

import com.example.jrpg.item.Item;

public abstract class Equipment extends Item implements EquipmentActions {

  public Equipment(String name, String description) {
    super(name, description);
  }
}
