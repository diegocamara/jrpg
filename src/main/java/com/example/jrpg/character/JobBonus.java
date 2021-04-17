package com.example.jrpg.character;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(fluent = true)
public class JobBonus {

  private final BigDecimal strength;
  private final BigDecimal constitution;
  private final BigDecimal dexterity;
  private final BigDecimal intelligence;
  private final BigDecimal wisdom;
  private final BigDecimal charisma;
}
