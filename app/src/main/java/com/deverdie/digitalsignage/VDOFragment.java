package com.deverdie.digitalsignage;


import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VDOFragment extends Fragment {
    private static final String TAG = "dlg";
    private static final String EXTRA_KEY = "extra_key";

    private VideoView mVideoView;
    private VideoView vidView;

    public VDOFragment() {
        // Required empty public constructor
    }

    public static VDOFragment newInstance() {
        return new VDOFragment();
    }


    public static VDOFragment newInstance(String key) {
        VDOFragment fragment = new VDOFragment();
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

        View v = inflater.inflate(R.layout.fragment_vdo, container, false);


//        String appPath = Util.GetExtStoreagePath(getActivity().getApplicationContext());
//        final String vdoPath = appPath + File.separator + "Movies" + File.separator + "big_buck_bunny.mp4";

        vidView = (VideoView) v.findViewById(R.id.vidView);

//        String vidAddress = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
//        String vidAddress = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4";
//        Uri vidUri = Uri.parse(vidAddress);
        Uri vidUri = Uri.parse(getArguments().getString(EXTRA_KEY));
        vidView.setVideoURI(vidUri);
//        vidView.setVideoPath(vdoPath);

//        MediaController vidControl = new MediaController(getActivity());
//
//        vidControl.setAnchorView(vidView);
//
//        vidView.setMediaController(vidControl);

        vidView.start();

//        String appPath = Util.GetExtStoreagePath(getActivity().getApplicationContext());
//        String vdoFolder = Prefs.getString(ConfigBean.COLUMN_VDO_FILE, "");
//        final String moviesPath = appPath + File.separator + "Movies";
//        File folder = new File(moviesPath);
////        final File file[] = folder.listFiles();
//        for (File f : folder.listFiles()) {
//            Log.i(TAG, "File Name: " + f.getName());
//        }
//
////
//        mVideoView = (VideoView) v.findViewById(R.id.vidView);
//
//            mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mediaPlayer) {
//                    mVideoView.stopPlayback();
//                    mVideoView.setVideoPath(vdoPath + "/" + pl.Next().getName());
////                    mVideoView.setFocusable(false);
////                    mVideoView.setFocusableInTouchMode(false);
//                    mVideoView.start();
//                }
//            });
//
//
//        mVideoView.setVideoPath(vdoPath);
//        MediaController mc = new MediaController(getActivity());
//        mVideoView.setMediaController(mc);
//        mVideoView.setFocusable(false);
//        mVideoView.setFocusableInTouchMode(false);
//        mVideoView.start();
//        }
        return v;
    }

}
