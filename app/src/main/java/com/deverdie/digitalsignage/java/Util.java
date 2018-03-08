package com.deverdie.digitalsignage.java;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.widget.EditText;

import com.pixplicity.easyprefs.library.Prefs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by tphon on 28/11/2560.
 */

public class Util {
    public static void setActionBar(ActionBar actionBar, String title, boolean isBackButton) {
        actionBar.setTitle(title);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(isBackButton);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
    }

    public static void setActionBar(ActionBar actionBar, String title, boolean isBackButton, int icon) {
        actionBar.setTitle(title);
        actionBar.setIcon(icon);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(isBackButton);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowTitleEnabled(true);
    }

    public static void PrefsStart(Context context, String packageName) {
        new Prefs.Builder()
                .setContext(context)
                .setMode(android.content.ContextWrapper.MODE_PRIVATE)
                .setPrefsName(packageName)
                .setUseDefaultSharedPreference(true)
                .build();
    }

    public static String GetExtStoreagePath(Context context) {
        String extStoreage = Environment.getExternalStorageDirectory().getAbsolutePath();
        return extStoreage;
    }

    public static String GetAppPath(Context context) {
        String extStoreage = Environment.getExternalStorageDirectory().getAbsolutePath();
        String packageName = context.getPackageName();
        return extStoreage + "/Android/data/" + packageName;
    }

    public static String GetDatabasePath(Context context, String databaseFolder) {
        String extStoreage = Environment.getExternalStorageDirectory().getAbsolutePath();
        return extStoreage + File.separator + databaseFolder + File.separator;
    }

    public static void CreateDirectory(File fileOrFolder) {
        if (!fileOrFolder.exists()) {
            fileOrFolder.mkdirs();
        }
    }

    public static void RemoveDirectory(File fileOrFolder) {
        if (fileOrFolder.isDirectory()) {
            String[] children = fileOrFolder.list();
            for (int i = 0; i < children.length; i++) {
                new File(fileOrFolder, children[i]).delete();
            }
        }
        fileOrFolder.delete();
    }

    public static BufferedReader readTextFilePath(String path) {
        try {

            File myFile = new File(path);
            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader bufferedreader = new BufferedReader(
                    new InputStreamReader(fIn));
            return bufferedreader;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getCurrentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getCurrentDateTime(String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static boolean notEmpty(EditText input) {
        return !input.getText().toString().trim().isEmpty();
    }

    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String Character2String(String strChar) {
        String ret = "";
        switch (strChar) {
            case "Comma":
                ret = ",";
                break;
            case "Tab":
                ret = "\t";
                break;
            case "SemiColon":
                ret = ";";
                break;
            case "Space":
                ret = " ";
                break;
            case "Pipe":
                ret = "\\|";
                break;

            case "None":
                ret = "";
                break;
//            case "'":
//                ret = "\'";
//                break;
//            case "\"":
//                ret = "\"";
//                break;
            default:
                ret = strChar;
        }
        return ret;
    }

    public static void showAllPref(Activity activity){
        Map<String, ?> prefsMap = Prefs.getAll();
        for (Map.Entry<String, ?> entry: prefsMap.entrySet()) {
            Log.v("SharedPreferences ", entry.getKey() + ":" + entry.getValue().toString());
        }
    }
}
