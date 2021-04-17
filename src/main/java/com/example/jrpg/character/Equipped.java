package com.example.jrpg.character;

import com.example.jrpg.item.equipment.weapon.Weapon;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Optional;

@Getter
@Setter
@Accessors(fluent = true)
public class Equipped<CHARACTER_CLASS> {

  private Weapon<CHARACTER_CLASS> weapon;

  public Optional<Weapon<CHARACTER_CLASS>> equip(Weapon<CHARACTER_CLASS> weapon) {
    final var alreadyEquipped = Optional.ofNullable(this.weapon);
    this.weapon = weapon;
    return alreadyEquipped;
  }
}
