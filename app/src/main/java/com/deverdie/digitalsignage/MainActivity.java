package com.deverdie.digitalsignage;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import pl.tajchert.nammu.Nammu;
import pl.tajchert.nammu.PermissionCallback;

import static android.view.WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;

public class MainActivity extends AppCompatActivity {


    private boolean lockScreen = true;

    // Check Runtime Permission -- BEGIN
    public void checkRuntimPermission() {
        Nammu.init(this);
        // Check Runtime Permission
        Nammu.askForPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, new PermissionCallback() {
            @Override
            public void permissionGranted() {
                Log.i("dlg", "permissionGranted: " + "Manifest.permission.WRITE_EXTERNAL_STORAGE - Granted");
//                Toast.makeText(MainActivity.this, "Manifest.permission.WRITE_EXTERNAL_STORAGE - Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void permissionRefused() {
                finish();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Nammu.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    // Check Runtime Persion -- END

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkRuntimPermission();

        hideSystemUI(lockScreen);
        blockTouch(lockScreen);

        String key = "Layout One";

        addFragment(LayoutTwoFragment.newInstance());
//        getSupportFragmentManager()
//                .beginTransaction()
//                .replace(R.id.layout_fragment_container, LayoutOneFragment.newInstance(key))
//                .commit();
    }

    private void addFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.layout_fragment_container, fragment);
        transaction.commit();
    }

    private void hideSystemUI(boolean b) {
        if (b) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

    }

    private void blockTouch(boolean b) {
        if (b) {
            getWindow().setFlags(FLAG_NOT_TOUCHABLE, FLAG_NOT_TOUCHABLE);
        } else {
            getWindow().clearFlags(FLAG_NOT_TOUCHABLE);
        }

    }
}
