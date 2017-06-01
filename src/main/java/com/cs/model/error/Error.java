package com.cs.model.error;

import com.cs.constants.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by olgac on 31/05/2017.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error extends RuntimeException {

    private static final long serialVersionUID = 6583931924466565939L;

    private Integer code;

    private Status status;

    private String message;

}
