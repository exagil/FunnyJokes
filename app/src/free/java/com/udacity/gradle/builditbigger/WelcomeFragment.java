package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.FoldingCube;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class WelcomeFragment extends Fragment {
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        AdView containerAd = (AdView) root.findViewById(R.id.container_ads);
        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        setupProgressBar(progressBar);
        setupAd(containerAd);
        return root;
    }

    private void setupProgressBar(ProgressBar progressBar) {
        FoldingCube cube = new FoldingCube();
        progressBar.setIndeterminateDrawable(cube);
    }

    private void setupAd(AdView containerAd) {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(BuildConfig.DEVICE_ID)
                .build();
        containerAd.loadAd(adRequest);
    }

    public void showLoader() {
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    public void hideLoader() {
        progressBar.setVisibility(ProgressBar.GONE);
    }
}
