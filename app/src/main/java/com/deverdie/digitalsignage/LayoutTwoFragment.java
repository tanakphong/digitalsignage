package com.deverdie.digitalsignage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LayoutTwoFragment extends Fragment {
    private static final String TAG = "dlg";
    private static final String EXTRA_KEY = "extra_key";

    private TextView Text;

    public LayoutTwoFragment() {
        // Required empty public constructor
    }

    public static LayoutTwoFragment newInstance() {
        return new LayoutTwoFragment();
    }


    public static LayoutTwoFragment newInstance(String key) {
        LayoutTwoFragment fragment = new LayoutTwoFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_KEY, key);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        String key = getArguments().getString(EXTRA_KEY);
//        Log.i(TAG, "onCreate, Key: "+key);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_layout_two, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        String key = getArguments().getString(EXTRA_KEY);
//        Text = view.findViewById(R.id.tv_text);
//        Text.setText(String.format("%1$s %2$s", getResources().getString(R.string.hello_blank_fragment), key));

        addChildFragment(VDOFragment.newInstance("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"), R.id.box_one);
        addChildFragment(VDOFragment.newInstance("https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4"), R.id.box_one);
    }

    private void addChildFragment(Fragment fragment, int idx) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(idx, fragment);
        transaction.commit();
    }

}
