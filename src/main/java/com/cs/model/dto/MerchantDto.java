package com.cs.model.dto;

import com.cs.serializer.JsonDateTimeDeserializer;
import com.cs.serializer.JsonDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by olgac on 31/05/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantDto implements Serializable {

    private static final long serialVersionUID = -7116458540437904536L;

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

    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    private Date createDate;

    private Boolean disable;

    private String address;

    private String postcode;

    private String country;

    private String comType;

}