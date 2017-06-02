package com.cs.model.response;

import com.cs.model.dto.CustomerDto;
import com.cs.model.dto.DataMerchantDto;
import com.cs.model.dto.FxDto;
import com.cs.model.dto.TransactionDto;
import com.cs.model.dto.TransactionResponseParentDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by olgac on 31/05/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionResponse implements Serializable {

    private static final long serialVersionUID = -5688276687133049083L;

    private CustomerDto customerInfo;

    private FxDto fx;

    private TransactionDto transaction;

    private DataMerchantDto merchant;

    private TransactionResponseParentDto parent;

}