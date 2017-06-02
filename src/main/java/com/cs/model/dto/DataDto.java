package com.cs.model.dto;

import com.cs.serializer.JsonDateDeserializer;
import com.cs.serializer.JsonDateSerializer;
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
public class DataDto implements Serializable {

    private static final long serialVersionUID = -5302103235785024066L;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonProperty("created_at")
    private Date createdAt;

    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonProperty("updated_at")
    private Date updatedAt;

    private FxDto fx;

    private TransactionDto transaction;

    private AcquirerDto acquirer;

    private CustomerDto customerInfo;

    private DataMerchantDto merchant;

    private TransactionResponseParentDto parent;

}