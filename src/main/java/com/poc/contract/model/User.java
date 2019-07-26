package com.poc.contract.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class User implements Serializable {

  private Integer id;
  private String email;
  private String name;
}
