package com.example.jrpg.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@AllArgsConstructor
public class InventoryResult<ITEM> {
  private Integer quantity;
  private ITEM item;
}
