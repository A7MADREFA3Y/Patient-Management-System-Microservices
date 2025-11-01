package com.pm.billingservice.grpc;


import billing.BillingsServiceGrpc.BillingsServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BillingGrpcService extends BillingsServiceImplBase {

    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest,
                                     StreamObserver<billing.BillingResponse> responseStreamObserver){

    }

}
