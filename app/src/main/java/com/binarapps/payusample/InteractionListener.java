package com.binarapps.payusample;

import com.payu.android.sdk.payment.PaymentService;

/**
 * Copyright (C) Binar::Apps, 2017
 * All rights reserved.
 */

public interface InteractionListener {

    interface FiltersTicketInteractionListener {
        void goToPayment();
    }

    interface PaymentInteractionListener {
        PaymentService getPaymentService();
    }
}
