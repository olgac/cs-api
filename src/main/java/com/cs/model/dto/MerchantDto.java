package com.cs.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by olgac on 31/05/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantDto {

    private Integer id;

    private Integer parentId;

    private String name;

    @JsonProperty("3dStatus")
    private String threeDStatus;

    private String mcc;

    private String ipnUrl;

    private String apiKey;

    private String cpgKey;

    private String type;

    private String descriptor;

    private String secretKey;

    private Boolean allowPartialRefund;

    private Boolean allowPartialCapture;

    private Boolean allowDynamicDescriptor;

    private Boolean avsCheck;

    private String walletId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    private Boolean disable;

    private String address;

    private String postcode;

    private String country;

    private String comType;

}