package com.deverdie.digitalsignage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class LayoutOneFragment extends Fragment {
    private static final String TAG = "dlg";
    private static final String EXTRA_KEY = "extra_key";

    private TextView Text;

    public LayoutOneFragment() {
        // Required empty public constructor
    }

    public static LayoutOneFragment newInstance() {
        return new LayoutOneFragment();
    }


    public static LayoutOneFragment newInstance(String key) {
        LayoutOneFragment fragment = new LayoutOneFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_KEY, key);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String key = getArguments().getString(EXTRA_KEY);
        Log.i(TAG, "onCreate, Key: " + key);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_one, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        String key = getArguments().getString(EXTRA_KEY);
//        Text = view.findViewById(R.id.tv_text);
//        Text.setText(String.format("%1$s %2$s", getResources().getString(R.string.hello_blank_fragment), key));
//
        addChildFragment(VDOFragment.newInstance());
//        LayoutTwoFragment childFragment = new LayoutTwoFragment();
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        transaction.replace(R.id.box_one, childFragment.newInstance("2")).commit();

    }


    private void addChildFragment(Fragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.box_one, fragment);
        transaction.commit();
    }
}
