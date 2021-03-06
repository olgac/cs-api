package com.cs.model.dto;

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
public class AcquirerDto implements Serializable {

    private static final long serialVersionUID = 8717708297439791153L;

    private Integer id;

    private String name;

    private String code;

    private String type;

}
