package com.pm.billingservice.grpc;


import billing.BillingResponse;
import billing.BillingsServiceGrpc.BillingsServiceImplBase;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class BillingGrpcService extends BillingsServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(BillingGrpcService.class);

    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest,
                                     StreamObserver<billing.BillingResponse> responseStreamObserver){

        log.info("createBillingAccount request received {}", billingRequest.toString());

        // Business logic - e.g save to database, perform calculates etc

        BillingResponse response = BillingResponse.newBuilder()
                .setAccountId("12344")
                .setStatus("ACTIVE")
                .build();

        //Send the GRPc service back to the client
        responseStreamObserver.onNext(response);
        //The response is completed the cycle end here
        responseStreamObserver.onCompleted();
        
    }
}
