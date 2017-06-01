package com.cs.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by olgac on 01/06/2017.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataMerchantDto implements Serializable {

    private static final long serialVersionUID = -6120877068008857579L;

    private Integer id;

    private String name;

    private Boolean allowPartialRefund;

    private Boolean allowPartialCapture;

}