package com.binarapps.payusample;

import com.payu.android.sdk.payment.PaymentEventBus;
import com.payu.android.sdk.payment.PaymentService;
import com.payu.android.sdk.payment.event.AbsentSelectedPaymentMethodEvent;
import com.payu.android.sdk.payment.event.PaymentFailedEvent;
import com.payu.android.sdk.payment.event.PaymentSuccessEvent;
import com.payu.android.sdk.payment.event.PresentSelectedPaymentMethodEvent;

/**
 * Copyright (C) Binar::Apps, 2017
 * All rights reserved.
 */

class PaymentPresenter implements PaymentContract.Presenter {
    private PaymentService paymentService;
    private PaymentEventBus paymentEventBus = new PaymentEventBus();

    PaymentPresenter(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void resume() {
        paymentEventBus.register(this);
    }


    @Override
    public void pause() {
        paymentEventBus.unregister(this);
    }

    @Override
    public void destroy() {
        paymentService.notifyUserLogout();
    }

    public void onPaymentProcessEventMainThread(PaymentFailedEvent paymentFailedEvent) {

    }

    public void onPaymentProcessEventMainThread(PaymentSuccessEvent event) {

    }

    public void onPaymentProcessEventMainThread(PresentSelectedPaymentMethodEvent event) {


    }

    public void onPaymentProcessEventMainThread(AbsentSelectedPaymentMethodEvent event) {

    }
}
