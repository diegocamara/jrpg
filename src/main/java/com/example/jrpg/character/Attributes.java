package com.example.jrpg.character;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Data
@Accessors(fluent = true)
public class Attributes {

  @Min(value = 1)
  @Max(value = 99)
  @NotNull
  private final BigInteger strength;

  @Min(value = 1)
  @Max(value = 99)
  @NotNull
  private final BigInteger constitution;

  @Min(value = 1)
  @Max(value = 99)
  @NotNull
  private final BigInteger dexterity;

  @Min(value = 1)
  @Max(value = 99)
  @NotNull
  private final BigInteger intelligence;

  @Min(value = 1)
  @Max(value = 99)
  @NotNull
  private final BigInteger wisdom;

  @Min(value = 1)
  @Max(value = 99)
  @NotNull
  private final BigInteger charisma;
}
