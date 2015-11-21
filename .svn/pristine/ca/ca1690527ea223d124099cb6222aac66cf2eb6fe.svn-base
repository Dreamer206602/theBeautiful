package com.fantastic3.thebeautiful.activites;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.fantastic3.thebeautiful.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login_btn = (Button) findViewById(R.id.login_btn);
        Button register_btn = (Button) findViewById(R.id.register_btn);
        Html.ImageGetter imageGetter = new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String source) {
                Drawable drawable = null;
                drawable = LoginActivity.this.getResources().getDrawable(Integer.parseInt(source));
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                return drawable;
            }
        };
        StringBuffer sb = new StringBuffer();
        sb.append("<font color=\"fff\">登录</font>").append("<img src=\"").append(R.drawable.view_reg_arrow).append("\"/>");
        Spanned spannable =Html.fromHtml(sb.toString(),imageGetter,null);
        login_btn.setText(spannable);
        sb.delete(0, sb.length());
        sb.append("<font color=\"5587f2\">注册</font>").append("<img src=\"").append(R.drawable.view_reg_enter).append("\"/>");
        Log.d("000",sb.toString());
        Spanned spannable1 = Html.fromHtml(sb.toString(), imageGetter, null);
        register_btn.setText(spannable1);
        sb=null;
    }

    public void register_click(View view) {
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    public void gethave_password_click(View view) {
        Intent intent=new Intent(this,GetPasswordActivity.class);
        startActivity(intent);
    }
}
