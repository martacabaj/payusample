package com.binarapps.payusample;

/**
 * Copyright (C) Binar::Apps, 2017
 * All rights reserved.
 */

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

public class TicketFiltersStepFragment extends Fragment {

    private InteractionListener.FiltersTicketInteractionListener filterInteractionListener;

    public static TicketFiltersStepFragment newInstance() {
        return new TicketFiltersStepFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filters, container, false);
        view.findViewById(R.id.go_to_payment_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPaymentScreen();
            }
        });
        return view;
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
        if (context instanceof InteractionListener.FiltersTicketInteractionListener) {
            filterInteractionListener = (InteractionListener.FiltersTicketInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
              + " must implement OnFragmentInteractionListener");
        }
    }

    public void goToPaymentScreen() {
        filterInteractionListener.goToPayment();
    }


}

