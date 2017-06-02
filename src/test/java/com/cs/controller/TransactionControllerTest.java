package com.cs.controller;

import com.cs.constants.Status;
import com.cs.model.dto.CustomerDto;
import com.cs.model.dto.MerchantDto;
import com.cs.model.request.ClientRequest;
import com.cs.model.request.ListRequest;
import com.cs.model.request.MerchantRequest;
import com.cs.model.request.ReportRequest;
import com.cs.model.request.TransactionRequest;
import com.cs.model.response.ClientResponse;
import com.cs.model.response.ListResponse;
import com.cs.model.response.MerchantResponse;
import com.cs.model.response.ReportResponse;
import com.cs.model.response.TransactionResponse;
import com.cs.service.TransactionService;
import com.cs.util.Utils;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Date;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by olgac on 01/06/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @Test
    public void shouldRetrieveListSuccessfully() throws Exception {
        Date fromDate = new DateTime(2017, 3, 1, 0 ,0 ).toDate();
        Date toDate = new DateTime(2017, 5, 1, 0 ,0 ).toDate();
        ListRequest listRequest = ListRequest.builder().fromDate(fromDate).toDate(toDate).build();
        ListResponse listResponse = ListResponse.builder().perPage(100).nextPageUrl("http://www.cs.com?page=3").prevPageUrl("http://www.cs.com?page=1").from(20).to(30).build();


        when(transactionService.retrieveList("my-token", listRequest, null)).thenReturn(new AsyncResult<>(Optional.ofNullable(listResponse)));

        MvcResult mvcResult = mockMvc.perform(post("/transaction/list")
                .header(HttpHeaders.AUTHORIZATION, "my-token")
                .content(Utils.asJsonString(listRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))
                .andReturn();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.per_page", equalTo(100)))
                .andExpect(jsonPath("$.next_page_url", equalTo("http://www.cs.com?page=3")))
                .andExpect(jsonPath("$.prev_page_url", equalTo("http://www.cs.com?page=1")))
                .andExpect(jsonPath("$.from", equalTo(20)))
                .andExpect(jsonPath("$.to", equalTo(30)))
                .andExpect(jsonPath("$.data", nullValue()));
    }

    @Test
    public void shouldRetrieveReportSuccessfully() throws Exception {
        Date fromDate = new DateTime(2017, 3, 1, 0 ,0 ).toDate();
        Date toDate = new DateTime(2017, 5, 1, 0 ,0 ).toDate();
        ReportRequest reportRequest = ReportRequest.builder().fromDate(fromDate).toDate(toDate).build();
        ReportResponse reportResponse = ReportResponse.builder().status(Status.APPROVED).build();

        when(transactionService.retrieveReport("my-token", reportRequest)).thenReturn(new AsyncResult<>(Optional.ofNullable(reportResponse)));

        MvcResult mvcResult = mockMvc.perform(post("/transaction/report")
                .header(HttpHeaders.AUTHORIZATION, "my-token")
                .content(Utils.asJsonString(reportRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))
                .andReturn();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.status", equalTo(Status.APPROVED.name())));
    }

    @Test
    public void shouldRetrieveClientSuccessfully() throws Exception {
        ClientRequest clientRequest = ClientRequest.builder().transactionId("my-transaction-id").build();
        CustomerDto customerInfo = CustomerDto.builder().id(5435).build();
        ClientResponse clientResponse = ClientResponse.builder().customerInfo(customerInfo).build();

        when(transactionService.retrieveClient("my-token", clientRequest)).thenReturn(new AsyncResult<>(Optional.ofNullable(clientResponse)));

        MvcResult mvcResult = mockMvc.perform(post("/transaction/client")
                .header(HttpHeaders.AUTHORIZATION, "my-token")
                .content(Utils.asJsonString(clientRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))
                .andReturn();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.customerInfo.id", equalTo(5435)));
    }

    @Test
    public void shouldRetrieveMerchantSuccessfully() throws Exception {
        MerchantRequest merchantRequest = MerchantRequest.builder().transactionId("my-transaction-id").build();
        MerchantDto merchant = MerchantDto.builder().id(6757).build();
        MerchantResponse merchantResponse = MerchantResponse.builder().merchant(merchant).build();

        when(transactionService.retrieveMerchant("my-token", merchantRequest)).thenReturn(new AsyncResult<>(Optional.ofNullable(merchantResponse)));

        MvcResult mvcResult = mockMvc.perform(post("/transaction/merchant")
                .header(HttpHeaders.AUTHORIZATION, "my-token")
                .content(Utils.asJsonString(merchantRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))
                .andReturn();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.merchant.id", equalTo(6757)));
    }

    @Test
    public void shouldRetrieveTransactionSuccessfully() throws Exception {
        TransactionRequest transactionRequest = TransactionRequest.builder().transactionId("my-transaction-id").build();
        CustomerDto customerInfo = CustomerDto.builder().id(2344).build();
        TransactionResponse transactionResponse = TransactionResponse.builder().customerInfo(customerInfo).build();

        when(transactionService.retrieveTransaction("my-token", transactionRequest)).thenReturn(new AsyncResult<>(Optional.ofNullable(transactionResponse)));

        MvcResult mvcResult = mockMvc.perform(post("/transaction")
                .header(HttpHeaders.AUTHORIZATION, "my-token")
                .content(Utils.asJsonString(transactionRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(request().asyncStarted())
                .andExpect(request().asyncResult(instanceOf(ResponseEntity.class)))
                .andReturn();

        mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.customerInfo.id", equalTo(2344)));
    }

}