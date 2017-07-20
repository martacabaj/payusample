package com.binarapps.payusample;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Copyright (C) Binar::Apps, 2017
 * All rights reserved.
 */

public class PaymentFragment extends Fragment {
    public static final String TAG = PaymentFragment.class.getSimpleName();

    private PaymentContract.Presenter presenter;
    private InteractionListener.PaymentInteractionListener paymentInteractionListener;

    public PaymentFragment() {

    }

    public static PaymentFragment newInstance() {
        return new PaymentFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PaymentPresenter(paymentInteractionListener.getPaymentService());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment, container, false);

        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroy();
    }


    @Override
    public Context getContext() {
        return getActivity().getApplicationContext();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        checkListenerImplementation(context);
    }
    //to support API<23
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        checkListenerImplementation(activity);
    }

    private void checkListenerImplementation(Context context) {
        if (context instanceof InteractionListener.PaymentInteractionListener) {
            paymentInteractionListener = (InteractionListener.PaymentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
              + " must implement PaymentInteractionListener");
        }
    }

}
