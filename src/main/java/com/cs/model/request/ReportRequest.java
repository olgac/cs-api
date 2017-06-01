package com.cs.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by olgac on 31/05/2017.
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequest {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fromDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date toDate;

    private Integer merchant;

    private Integer acquirer;

}
