package com.cs.controller;

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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by olgac on 31/05/2017.
 */
@RestController
@Api(description = "Transaction operations")
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @ApiOperation("List")
    @PostMapping("/list")
    public ResponseEntity<ListResponse> retrieveList(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @Valid @RequestBody ListRequest listRequest, @RequestParam(value = "page", required = false) Integer page) {
        return new ResponseEntity<ListResponse>(transactionService.retrieveList(token, listRequest, page), HttpStatus.OK);
    }

    @ApiOperation("Report")
    @PostMapping("/report")
    public ResponseEntity<ReportResponse> retrieveReport(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @Valid @RequestBody ReportRequest reportRequest) {
        return new ResponseEntity<ReportResponse>(transactionService.retrieveReport(token, reportRequest), HttpStatus.OK);
    }

    @ApiOperation("Client")
    @PostMapping("/client")
    public ResponseEntity<ClientResponse> retrieveClient(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @Valid @RequestBody ClientRequest clientRequest) {
        return new ResponseEntity<ClientResponse>(transactionService.retrieveClient(token, clientRequest), HttpStatus.OK);
    }

    @ApiOperation("Merchant")
    @PostMapping("/merchant")
    public ResponseEntity<MerchantResponse> retrieveMerchant(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @Valid @RequestBody MerchantRequest merchantRequest) {
        return new ResponseEntity<MerchantResponse>(transactionService.retrieveMerchant(token, merchantRequest), HttpStatus.OK);
    }

    @ApiOperation("Transaction")
    @PostMapping
    public ResponseEntity<TransactionResponse> retrieveTransaction(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @Valid @RequestBody TransactionRequest transactionRequest) {
        return new ResponseEntity<TransactionResponse>(transactionService.retrieveTransaction(token, transactionRequest), HttpStatus.OK);
    }
}