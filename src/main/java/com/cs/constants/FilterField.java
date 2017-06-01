package com.cs.constants;

import lombok.AllArgsConstructor;

/**
 * Created by olgac on 31/05/2017.
 */
@AllArgsConstructor
public enum FilterField {

    F1("Transaction UUID"),
    F2("Customer Email"),
    F3("Reference No"),
    F4("Custom Data"),
    F5("Card PAN");

    private String name;

}