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

import java.util.Optional;
import java.util.concurrent.Future;

/**
 * Created by olgac on 31/05/2017.
 */
public interface TransactionService {

    Future<Optional<ListResponse>> retrieveList(String token, ListRequest listRequest, Integer page);

    Future<Optional<ReportResponse>> retrieveReport(String token, ReportRequest reportRequest);

    Future<Optional<ClientResponse>> retrieveClient(String token, ClientRequest clientRequest);

    Future<Optional<MerchantResponse>> retrieveMerchant(String token, MerchantRequest merchantRequest);

    Future<Optional<TransactionResponse>> retrieveTransaction(String token, TransactionRequest transactionRequest);

}