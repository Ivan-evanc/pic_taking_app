package com.example.android.pictakingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;

import android.content.pm.PackageInfo;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class  MainActivity extends AppCompatActivity {
    //declare the constant variable for the activity
 private final int REQUEST_IMAGE_CAPTURE=1;
 ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button imageCapture=(Button)findViewById(R.id.btnCamera);
        imageView=(ImageView)findViewById(R.id.imageView);

        if(!hasCamera()){
            imageCapture.setEnabled(false);
        }

    }
    //function to check if camera is on
    public Boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void launchCamera(View view){
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_IMAGE_CAPTURE&&resultCode==RESULT_OK){
            Bundle  b=data.getExtras();
            Bitmap pic=(Bitmap)b.get("data");
            imageView.setImageBitmap(pic);
            if(imageView!=null){
                Intent newIntent=new Intent(MainActivity.this,userRegistration.class);
                startActivity(newIntent);
            }
        }
    }
}
