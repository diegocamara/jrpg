package com.example.jrpg.character;

import com.example.jrpg.item.Item;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Accessors(fluent = true)
public class Inventory {
  @DecimalMin(value = "0")
  private final BigInteger gold;

  @NotNull private final List<Item> items;

  public void add(Item item) {
    this.items.add(item);
  }

  public <T extends Item> Optional<InventoryResult<T>> find(Class<T> itemClass) {
    final var result =
        this.items.stream()
            .filter(item -> itemClass.isAssignableFrom(itemClass))
            .map(item -> (T) item)
            .collect(Collectors.toList());
    final var quantity = result.size();
    return quantity > 0
        ? Optional.of(new InventoryResult<>(quantity, result.stream().findFirst().orElseThrow()))
        : Optional.empty();
  }

  public void remove(Item item) {
    this.items.remove(item);
  }
}
