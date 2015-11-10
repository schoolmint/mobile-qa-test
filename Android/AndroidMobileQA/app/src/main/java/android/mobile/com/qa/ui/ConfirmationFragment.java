package android.mobile.com.qa.ui;


import android.content.Context;
import android.mobile.com.qa.R;
import android.mobile.com.qa.net.RestClient;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.node.ArrayNode;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class ConfirmationFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = ConfirmationFragment.class.getName();

    private FragmentListener mListener;

    public static ConfirmationFragment newInstance() {
        return new ConfirmationFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_confirmation, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.next_btn).setOnClickListener(this);
        ((TextView) view.findViewById(R.id.name)).setText("First name: " + mListener.getName());
        ((TextView) view.findViewById(R.id.last_name)).setText("Last name: " + mListener.getLastName());
        ((TextView) view.findViewById(R.id.email)).setText("Email: " + mListener.getEmail());
        ((TextView) view.findViewById(R.id.phone)).setText("Phone number: " + mListener.getPhone());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.next_btn) {
            RestClient.getInstance().getClientService().networkRequest(new Callback<ArrayNode>() {
                @Override
                public void success(ArrayNode jsonArray, Response response) {
                    Log.d(TAG, "Success");
                    Toast.makeText(getActivity(), "All the information has been submitted", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d(TAG, "Fail");
                    throw new RuntimeException("AARRRGGGG!!!! The application crashed!");
                }
            });
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
