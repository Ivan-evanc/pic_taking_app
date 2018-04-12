package com.example.android.pictakingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

public class userRegistration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        String url="http://localhost/systems/android.ajiraconnect/test.user_register/main_url_user.php";

        StringRequest myreq=new StringRequest(Request.Method.GET,url,createMyReqSuccessListener(),createMyReqErrorListener()){
            
        }

    }

}
