package com.cs.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by olgac on 31/05/2017.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AmountDto implements Serializable {

    private static final long serialVersionUID = 2360761642438294894L;

    private Long count;

    private BigDecimal total;

    private String currency;

}
