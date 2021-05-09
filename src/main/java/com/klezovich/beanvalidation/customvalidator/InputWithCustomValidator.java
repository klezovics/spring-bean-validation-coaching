package com.klezovich.beanvalidation.customvalidator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
class InputWithCustomValidator {

  @IpAddress
  private String ipAddress;
}