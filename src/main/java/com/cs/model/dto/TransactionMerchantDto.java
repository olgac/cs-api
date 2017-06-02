package com.cs.model.dto;

import com.cs.constants.Status;
import com.cs.serializer.JsonDateTimeDeserializer;
import com.cs.serializer.JsonDateTimeSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by olgac on 01/06/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionMerchantDto implements Serializable {

    private static final long serialVersionUID = 3144081124787429490L;

    private Integer id;

    private String referenceNo;

    private Integer merchantId;

    private Integer fxTransactionId;

    private Integer agentInfoId;

    private Status status;

    private String operation;

    private String type;

    private String chainId;

    private String returnUrl;

    private Integer acquirerTransactionId;

    private String code;

    private String message;

    private String channel;

    private String customData;

    private Integer parentId;

    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonProperty("created_at")
    private Date createdAt;

    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonProperty("deleted_at")
    private Date deletedAt;

    private String transactionId;

}