package com.cs.model.request;

import com.cs.constants.ErrorCode;
import com.cs.constants.FilterField;
import com.cs.constants.Operation;
import com.cs.constants.PaymentMethod;
import com.cs.constants.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

    private Status status;

    private Operation operation;

    private Integer merchantId;

    private Integer acquirerId;

    private PaymentMethod paymentMethod;

    private ErrorCode errorCode;

    private FilterField filterField;

    private String filterValue;

    private Integer page;

}
