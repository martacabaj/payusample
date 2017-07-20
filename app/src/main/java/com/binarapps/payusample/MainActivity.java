package com.binarapps.payusample;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.payu.android.sdk.payment.PaymentService;

public class MainActivity extends AppCompatActivity implements
  InteractionListener.FiltersTicketInteractionListener,
  InteractionListener.PaymentInteractionListener {

    private PaymentService paymentService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goToTicketFiltersSteps();
    }

    public void goToTicketFiltersSteps() {
        if (checkIfFragmentVisible(TicketFiltersStepFragment.class.getName())) {
            return;
        }
        if (!isFragmentInStackAndPopBack(TicketFiltersStepFragment.class.getName())) {
            createAndReplaceFragment(new TicketFiltersStepFragment(), FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        }
    }

    @Override
    public void goToPayment() {
        if (checkIfFragmentVisible(PaymentFragment.class.getName())) {
            return;
        }
        if (!isFragmentInStackAndPopBack(PaymentFragment.class.getName())) {
            createAndReplaceFragment(PaymentFragment.newInstance(), FragmentTransaction.TRANSIT_NONE);
        }
    }

    private boolean checkIfFragmentVisible(String tag) {
        Fragment fragment = getFragmentManager().findFragmentByTag(tag);
        return fragment != null && fragment.isVisible();
    }

    private boolean isFragmentInStackAndPopBack(String name) {
        return getFragmentManager().popBackStackImmediate(name, 0);
    }

    private void createAndReplaceFragment(Fragment fragment, int transaction) {
        String tag = fragment.getClass().getName();
        getFragmentManager()
          .beginTransaction()
          .setTransition(transaction)
          .replace(R.id.layout_container, fragment, tag)
          .addToBackStack(tag)
          .commit();
    }

    @Override
    public PaymentService getPaymentService() {
        if (paymentService == null) {
            paymentService = PaymentService.createInstance(this);
        }
        return paymentService;
    }
}
