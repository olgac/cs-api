package com.cs.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.cs.model.dto.CustomerDto;
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
public class ClientResponse implements Serializable {

    private static final long serialVersionUID = -9016797747229731977L;

    private CustomerDto customerInfo;

}