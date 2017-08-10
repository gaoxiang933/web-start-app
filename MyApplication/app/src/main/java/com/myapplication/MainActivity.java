package com.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        Uri data = intent.getData();
        if (data != null){
            String name = data.getQueryParameter("name");
            String id = data.getQueryParameter("id");
            Toast.makeText(this,"name="+name+"-------id="+id,Toast.LENGTH_LONG).show();
        }
    }
}
