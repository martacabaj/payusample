package com.binarapps.payusample;

/**
 * Copyright (C) Binar::Apps, 2017
 * All rights reserved.
 */

public interface PaymentContract {
    interface Presenter {
        void resume();
        void pause();
        void destroy();
    }


}
