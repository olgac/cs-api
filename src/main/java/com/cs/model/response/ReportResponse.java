package com.cs.model.response;

import com.cs.constants.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.cs.model.dto.AmountDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by olgac on 31/05/2017.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReportResponse implements Serializable {

    private static final long serialVersionUID = 3594334014880611045L;

    private Status status;

    private List<AmountDto> response;

}