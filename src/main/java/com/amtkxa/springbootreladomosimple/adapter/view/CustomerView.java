package com.amtkxa.springbootreladomosimple.adapter.view;

import com.amtkxa.springbootreladomosimple.domain.entity.Customer;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerView implements Serializable {
  @ApiModelProperty(value = "Customer ID.")
  private int customerId;

  @ApiModelProperty(value = "Customer's name.")
  private String name;

  @ApiModelProperty(value = "Customer's nationality.")
  private String country;

  public static CustomerView fromCustomer(Customer customer) {
    return CustomerView.builder()
        .customerId(customer.getCustomerId())
        .name(customer.getName())
        .country(customer.getCountry())
        .build();
  }
}
