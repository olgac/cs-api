package com.cs.constants;

import lombok.AllArgsConstructor;

/**
 * Created by olgac on 31/05/2017.
 */
@AllArgsConstructor
public enum Operation {

    DIRECT("DIRECT"),
    REFUND("REFUND"),
    THREED("3D"),
    THREEDAUTH("3DAUTH"),
    STORED("STORED");

    private String value;

}
