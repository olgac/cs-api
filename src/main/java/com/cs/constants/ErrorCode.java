package com.cs.constants;

import lombok.AllArgsConstructor;

/**
 * Created by olgac on 31/05/2017.
 */
@AllArgsConstructor
public enum ErrorCode {

    CS01("Do not honor"),
    CS02("Invalid Transaction"),
    CS03("Invalid Card"),
    CS04("Not sufficient funds"),
    CS05("Incorrect PIN"),
    CS06("Invalid country association"),
    CS07("3-D Secure Transport Error"),
    CS08("Transaction not permitted to cardholder");

    private String name;

}
