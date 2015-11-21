package com.fantastic3.thebeautiful.activites;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.fantastic3.thebeautiful.R;
import com.fantastic3.thebeautiful.widgets.FloatLayout;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        FloatLayout floatLayout= (FloatLayout) findViewById(R.id.floatPael);
        String s[]={"彩妆","保湿补水","美白","护肤","瘦身减肥","底妆","祛痘","战痘特训营","服装搭配","眼妆"};
        ViewGroup.MarginLayoutParams marginLayoutParams=new ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                60
                );
        marginLayoutParams.leftMargin=10;
        marginLayoutParams.bottomMargin=10;
        marginLayoutParams.topMargin=10;
        marginLayoutParams.rightMargin=10;
        for(int i=0;i<s.length;i++){
            Button button=new Button(this);
            button.setText(s[i]);
            button.setPadding(10, 5, 10, 5);
            button.setTextSize(13);
            button.setTextColor(Color.GRAY);
            button.setBackgroundResource(R.drawable.float_btn);
            button.setLayoutParams(marginLayoutParams);
            floatLayout.addView(button);
        }

    }

}
