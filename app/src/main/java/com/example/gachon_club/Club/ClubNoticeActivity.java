package com.example.gachon_club.Club;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gachon_club.R;

public class ClubNoticeActivity extends Fragment {
    private View view;

    public static ClubNoticeActivity newInstance(){
        ClubNoticeActivity clubNoticeActivity = new ClubNoticeActivity();
        return clubNoticeActivity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_club_notice, container, false);

        return view;
    }
}