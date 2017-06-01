package com.cs.model.dto;

import com.cs.constants.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("created_at")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("deleted_at")
    private Date deletedAt;

    private String transactionId;

}