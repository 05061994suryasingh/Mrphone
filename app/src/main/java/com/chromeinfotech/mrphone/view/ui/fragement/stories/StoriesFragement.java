package com.chromeinfotech.mrphone.view.ui.fragement.stories;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chromeinfotech.mrphone.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
  * to handle interaction events.
 * Use the {@link StoriesFragement#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StoriesFragement extends Fragment {

    public StoriesFragement() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BuyPhoneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StoriesFragement newInstance(String param1, String param2) {
        StoriesFragement fragment = new StoriesFragement();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buy_phone, container, false);
    }

}
