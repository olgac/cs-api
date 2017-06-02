package com.cs.controller;

import com.cs.constants.Status;
import com.cs.model.error.Error;
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
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by olgac on 31/05/2017.
 */
@RestController
@Api(description = "Transaction Operations")
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @ApiOperation("List")
    @PostMapping("/list")
    public Callable<ResponseEntity<ListResponse>> retrieveList(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @Valid @RequestBody ListRequest listRequest, @RequestParam(value = "page", required = false) Integer page) {
        return () -> {
            Future<Optional<ListResponse>> future = transactionService.retrieveList(token, listRequest, page);
            Optional<ListResponse> optional = future.get();
            return new ResponseEntity<>(optional.orElseThrow(() -> new Error(0, Status.ERROR, "List not retrieved!")), HttpStatus.OK);
        };
    }

    @ApiOperation("Report End-Point")
    @PostMapping("/report")
    public Callable<ResponseEntity<ReportResponse>> retrieveReport(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @Valid @RequestBody ReportRequest reportRequest) {
        return () -> {
            Future<Optional<ReportResponse>> future = transactionService.retrieveReport(token, reportRequest);
            Optional<ReportResponse> optional = future.get();
            return new ResponseEntity<>(optional.orElseThrow(() -> new Error(0, Status.ERROR, "Report not retrieved!")), HttpStatus.OK);
        };
    }

    @ApiOperation("Client End-Point")
    @PostMapping("/client")
    public Callable<ResponseEntity<ClientResponse>> retrieveClient(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @Valid @RequestBody ClientRequest clientRequest) {
        return () -> {
            Future<Optional<ClientResponse>> future = transactionService.retrieveClient(token, clientRequest);
            Optional<ClientResponse> optional = future.get();
            return new ResponseEntity<>(optional.orElseThrow(() -> new Error(0, Status.ERROR, "Client not retrieved!")), HttpStatus.OK);
        };
    }

    @ApiOperation("Merchant End-Point")
    @PostMapping("/merchant")
    public Callable<ResponseEntity<MerchantResponse>> retrieveMerchant(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @Valid @RequestBody MerchantRequest merchantRequest) {
        return () -> {
            Future<Optional<MerchantResponse>> future = transactionService.retrieveMerchant(token, merchantRequest);
            Optional<MerchantResponse> optional = future.get();
            return new ResponseEntity<>(optional.orElseThrow(() -> new Error(0, Status.ERROR, "Merchant not retrieved!")), HttpStatus.OK);
        };
    }

    @ApiOperation("Transaction End-Point")
    @PostMapping
    public Callable<ResponseEntity<TransactionResponse>> retrieveTransaction(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @Valid @RequestBody TransactionRequest transactionRequest) {
        return () -> {
            Future<Optional<TransactionResponse>> future = transactionService.retrieveTransaction(token, transactionRequest);
            Optional<TransactionResponse> optional = future.get();
            return new ResponseEntity<>(optional.orElseThrow(() -> new Error(0, Status.ERROR, "Transaction not retrieved!")), HttpStatus.OK);
        };
    }
}