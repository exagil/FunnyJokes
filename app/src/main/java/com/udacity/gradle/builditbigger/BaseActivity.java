package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);
        setupToolbar();
    }

    private void setupToolbar() {
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle("");
        supportActionBar.setElevation(0);
    }

    public void showLoader(String message) {
        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public void hideLoader() {
        progressDialog.dismiss();
    }
}
