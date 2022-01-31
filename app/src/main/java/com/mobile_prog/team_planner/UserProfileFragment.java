package com.mobile_prog.team_planner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.banner.BannerView;
import com.mobile_prog.team_planner.models.User;
import com.mobile_prog.team_planner.repositories.UserRepository;

public class UserProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_user_profile, container, false);
        TextView userName=rootView.findViewById(R.id.userProfileName);
        TextView userEmail=rootView.findViewById(R.id.userProfileEmail);
        User currUser=UserRepository.getCurrentUser();
        userName.setText(currUser.getName());
        userEmail.setText(currUser.getEmail());
        BannerView bannerView = rootView.findViewById(R.id.hw_banner_view);
        // Set the ad unit ID and ad dimensions. "testw6vs28auh3" is a dedicated test ad unit ID.
//        bannerView.setAdId("testw6vs28auh3");
//        bannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_360_57);
        // Set the refresh interval to 60 seconds.
        bannerView.setBannerRefresh(60);

        AdParam adParam = new AdParam.Builder().build();
        bannerView.loadAd(adParam);




        Button logOut=rootView.findViewById(R.id.log_out_button);

        logOut.setOnClickListener((view)->{
            FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
            firebaseAuth.signOut();
        });
        return rootView;
    }
}