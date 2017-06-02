package com.cs.model.request;

import com.cs.constants.ErrorCode;
import com.cs.constants.FilterField;
import com.cs.constants.PaymentMethod;
import com.cs.constants.Status;
import com.cs.serializer.JsonDateDeserializer;
import com.cs.serializer.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
@AllArgsConstructor
@NoArgsConstructor
public class ListRequest {

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date fromDate;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private Date toDate;

    private Status status;

    private String operation;

    private Integer merchantId;

    private Integer acquirerId;

    private PaymentMethod paymentMethod;

    private ErrorCode errorCode;

    private FilterField filterField;

    private String filterValue;

    private Integer page;

}
