package com.poc.contract.integration.dto;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto implements Serializable {

  private Integer id;
  private String email;
  private String name;
}
