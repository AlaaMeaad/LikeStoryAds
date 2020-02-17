package com.alaameaad.likestoryads;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.service.autofill.UserData;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.io.File;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HelperMethod {

    private static ProgressDialog checkDialog;
    public static AlertDialog alertDialog;
    public static Snackbar snackbar;
    private static SharedPreferences sharedPreferences = null;
    private static String USER_DATA = "USER_DATA";


    //tost + action
    public static void createSnackBar(View view, String message, Context context) {
        final Snackbar snackbar = Snackbar.make(view, message, 50000);
        snackbar.setAction("dismiss", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbar.dismiss();
            }
        })
                .setActionTextColor(context.getResources().getColor(android.R.color.holo_red_light))

                .show();
    }

    public static void createSnackBar(View view, String message, Context context, View.OnClickListener action, String Title) {
        snackbar = Snackbar.make(view, message, 50000);
        snackbar.setAction(Title, action)
                .setActionTextColor(context.getResources().getColor(android.R.color.holo_red_light))
                .show();
    }



    public static void showProgressDialog(Activity activity, String title) {
        try {
            checkDialog = new ProgressDialog(activity);
            checkDialog.setMessage(title);
            checkDialog.setIndeterminate(false);
            checkDialog.setCancelable(false);
            checkDialog.show();

        } catch (Exception e) {

        }
    }


    //display dialog
    public static void dismissProgressDialog() {
        try {
            if (checkDialog != null && checkDialog.isShowing()) {
                checkDialog.dismiss();
            }
        } catch (Exception e) {

        }
    }


    //call fragment
    public static void ReplaceFragment(Fragment fragment, FragmentManager supportFragmentManager, int container_id
            , TextView toolbarTitle, String title) {

        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        transaction.replace(container_id, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
        if (toolbarTitle != null) {
            toolbarTitle.setText(title);
        }

    }








}
