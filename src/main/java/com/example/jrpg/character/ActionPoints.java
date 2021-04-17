package com.example.jrpg.character;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.DecimalMin;
import java.math.BigInteger;

@Data
@Accessors(fluent = true)
public class ActionPoints {

  @DecimalMin(value = "0")
  private BigInteger current;

  @DecimalMin(value = "1")
  private BigInteger max;

  public ActionPoints(BigInteger current, BigInteger max) {
    this.current = current;
    this.max = max;
  }

  public static ActionPoints fromBase(BigInteger base) {
    return new ActionPoints(base, base);
  }
}
