package com.cs.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CustomerDto implements Serializable {

    private static final long serialVersionUID = -4221149927227973138L;

    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("created_at")
    private Date createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("deleted_at")
    private Date deletedAt;

    private String number;

    private String expiryMonth;

    private String expiryYear;

    private String startMonth;

    private String startYear;

    private String issueNumber;

    private String email;

    private String birthday;

    private String gender;

    private String billingTitle;

    private String billingFirstName;

    private String billingLastName;

    private String billingCompany;

    private String billingAddress1;

    private String billingAddress2;

    private String billingCity;

    private String billingPostcode;

    private String billingState;

    private String billingCountry;

    private String billingPhone;

    private String billingFax;

    private String shippingTitle;

    private String shippingFirstName;

    private String shippingLastName;

    private String shippingCompany;

    private String shippingAddress1;

    private String shippingAddress2;

    private String shippingCity;

    private String shippingPostcode;

    private String shippingState;

    private String shippingCountry;

    private String shippingPhone;

    private String shippingFax;

    private String token;

}
