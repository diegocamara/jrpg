package com.example.jrpg.character;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Size;

@Data
@Accessors(fluent = true)
public class Biography {

  @Size(min = 4, max = 20)
  private final String name;

  @Size(min = 4, max = 20)
  private final String background;

  public Biography(String name, String background) {
    this.name = name;
    this.background = background;
  }
}
