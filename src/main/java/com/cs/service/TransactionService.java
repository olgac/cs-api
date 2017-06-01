package com.cs.service;

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

/**
 * Created by olgac on 31/05/2017.
 */
public interface TransactionService {

    ListResponse retrieveList(String token, ListRequest listRequest, Integer page);

    ReportResponse retrieveReport(String token, ReportRequest reportRequest);

    ClientResponse retrieveClient(String token, ClientRequest clientRequest);

    MerchantResponse retrieveMerchant(String token, MerchantRequest merchantRequest);

    TransactionResponse retrieveTransaction(String token, TransactionRequest transactionRequest);

}