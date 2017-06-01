package com.cs.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.cs.model.dto.MerchantDto;
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
public class MerchantResponse {

    private MerchantDto merchant;

}