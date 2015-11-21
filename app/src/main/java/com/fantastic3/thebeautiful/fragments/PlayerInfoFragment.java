package com.fantastic3.thebeautiful.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fantastic3.thebeautiful.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerInfoFragment extends BaseFragment {


    public PlayerInfoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_player_info, container, false);
    }


}
