package com.cs.service.impl;

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
import com.cs.util.RestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by olgac on 31/05/2017.
 */
@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private RestClient rest;

    @Value("${rest.list}")
    private String listPath;

    @Value("${rest.report}")
    private String reportPath;

    @Value("${rest.client}")
    private String clientPath;

    @Value("${rest.merchant}")
    private String merchantPath;

    @Value("${rest.transaction}")
    private String transactionPath;

    @Override
    public ListResponse retrieveList(String token, ListRequest listRequest, Integer page) {
        String suffix = page != null && page > 1 ? "?page=".concat(page.toString()) : "";
        return rest.post(listPath.concat(suffix), token, listRequest, ListResponse.class);
    }

    @Override
    public ReportResponse retrieveReport(String token, ReportRequest reportRequest) {
        return rest.post(reportPath, token, reportRequest, ReportResponse.class);
    }

    @Override
    public ClientResponse retrieveClient(String token, ClientRequest clientRequest) {
        return rest.post(clientPath, token, clientRequest, ClientResponse.class);
    }

    @Override
    public MerchantResponse retrieveMerchant(String token, MerchantRequest merchantRequest) {
        return rest.post(merchantPath, token, merchantRequest, MerchantResponse.class);
    }

    @Override
    public TransactionResponse retrieveTransaction(String token, TransactionRequest transactionRequest) {
        return rest.post(transactionPath, token, transactionRequest, TransactionResponse.class);
    }
}