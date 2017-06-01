package com.cs.model.dto;

import com.cs.constants.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by olgac on 01/06/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataIpnMerchantDto implements Serializable {

    private static final long serialVersionUID = -7046681452927990306L;

    private String transactionId;

    private String referenceNo;

    private BigDecimal amount;

    private String currency;

    private BigDecimal convertedAmount;

    private String convertedCurrency;

    private Long date;

    private String code;

    private String message;

    private String operation;

    private String type;

    private Status status;

    private String customData;

    private String chainId;

    private String paymentType;

    private String descriptor;

    private String token;

    @JsonProperty("IPNUrl")
    private String IPNUrl;

    private String ipnType;

}