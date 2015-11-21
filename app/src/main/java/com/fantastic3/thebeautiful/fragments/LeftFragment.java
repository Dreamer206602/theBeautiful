package com.fantastic3.thebeautiful.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.activites.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */

/**
 * 侧滑部分的fragment
 */
public class LeftFragment extends BaseFragment {


    public LeftFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.left_fragment, container, false);
        ImageView user_head=(ImageView)view.findViewById(R.id.user_head);
        user_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}
