package com.cs.controller;

import com.cs.common.BaseControllerTest;
import com.cs.model.request.ListRequest;
import com.cs.model.response.ListResponse;
import com.cs.service.TransactionService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by olgac on 01/06/2017.
 */
public class TransactionControllerTest extends BaseControllerTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    public void shouldRetrieveList() throws Exception {
        Date fromDate = new GregorianCalendar(2017, Calendar.MARCH, 1).getTime();
        Date toDate = new GregorianCalendar(2017, Calendar.MAY, 1).getTime();
        ListRequest listRequest = ListRequest.builder().fromDate(fromDate).toDate(toDate).build();
        ListResponse listResponse = ListResponse.builder().perPage(100).from(20).to(30).build();
        String token = "my-token";

        when(transactionService.retrieveList(token, listRequest, null)).thenReturn(new AsyncResult<>(Optional.ofNullable(listResponse)));

        mockMvc().perform(post("/transaction/list")
                .header(HttpHeaders.AUTHORIZATION, token)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(asJsonString(listRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(7)))
                .andExpect(jsonPath("$.per_page", equalTo(100)))
                .andExpect(jsonPath("$.current_page", equalTo(2)))
                .andExpect(jsonPath("$.next_page_url", equalTo("http://www.cs.com?page=3")))
                .andExpect(jsonPath("$.prev_page_url", equalTo("http://www.cs.com?page=1")))
                .andExpect(jsonPath("$.from", equalTo(20)))
                .andExpect(jsonPath("$.to", equalTo(30)))
                .andExpect(jsonPath("$.data", nullValue()));

        verify(transactionService).retrieveList(token, listRequest, null);
    }

    @Test
    public void shouldRetrieveReport() throws Exception {
    }

    @Test
    public void shouldRetrieveClient() throws Exception {
    }

    @Test
    public void shouldRetrieveMerchant() throws Exception {
    }

    @Test
    public void shouldRetrieveTransaction() throws Exception {
    }

}