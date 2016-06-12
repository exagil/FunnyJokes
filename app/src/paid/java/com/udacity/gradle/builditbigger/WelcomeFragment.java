package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.FoldingCube;

public class WelcomeFragment extends Fragment {

    private ProgressBar progressBar;

    public WelcomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        setupProgressBar(progressBar);
        return root;
    }

    private void setupProgressBar(ProgressBar progressBar) {
        FoldingCube cube = new FoldingCube();
        progressBar.setIndeterminateDrawable(cube);
    }

    public void showLoader() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    public void hideLoader() {
        progressBar.setVisibility(ProgressBar.GONE);
    }
}
