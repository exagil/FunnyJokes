package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class WelcomeFragment extends Fragment {

    public WelcomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        AdView containerAd = (AdView) root.findViewById(R.id.container_ads);
        setupAd(containerAd);
        return root;
    }

    private void setupAd(AdView containerAd) {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(BuildConfig.DEVICE_ID)
                .build();
        containerAd.loadAd(adRequest);
    }
}
