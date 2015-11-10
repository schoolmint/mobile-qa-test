package android.mobile.com.qa.ui;


import android.content.Context;
import android.mobile.com.qa.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class FormFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = FormFragment.class.getName();

    public static FormFragment newInstance() {
        return new FormFragment();
    }

    private FragmentListener mListener;


    private EditText mName;

    private EditText mLastName;

    private EditText mEmail;

    private EditText mPhone;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_form, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.next_btn).setOnClickListener(this);

        mName = (EditText) view.findViewById(R.id.name);
        mLastName = (EditText) view.findViewById(R.id.last_name);
        mEmail = (EditText) view.findViewById(R.id.email);
        mPhone = (EditText) view.findViewById(R.id.phone);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.next_btn) {
            mListener.setName(mName.getText().toString());
            mListener.setLastName(mLastName.getText().toString());
            mListener.setEmail(mEmail.getText().toString());
            mListener.setPhone(mPhone.getText().toString());
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_contaimer, ConfirmationFragment.newInstance(), ConfirmationFragment.TAG)
                    .addToBackStack(ConfirmationFragment.TAG).commit();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (FragmentListener) context;
        } catch (ClassCastException ex) {
            Log.w(TAG, context.toString()
                    + " must implement FragmentListener");
        }
    }
}
