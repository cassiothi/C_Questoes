package com.cassio.cesar_emailservice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Activity activity;
    Intent intent;
    Node n1 = new Node("Email 1");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activity = MainActivity.this;

        //Creating more nodes for test purposes only
        n1.next = new Node("Email 2");
        n1.next.next = new Node("Email 2");
        n1.next.next.next = new Node("Email 3");
        //Print list before removing duplicated e-mails
        Log.i("LOG EMAIL SERVICE:", "List before removing duplicated elements "+ n1.email + " " + n1.next.email+ " " + n1.next.next.email);

        initService();

    }

    private void initService(){
        intent =  new Intent(activity,EmailService.class);
        intent.putExtra("NodeList", n1);
        activity.startService(intent);
        Log.i("LOG EMAIL SERVICE:", "Service started ");
        activity.registerReceiver(broadcastReceiver,
                new IntentFilter("com.cassio.cesar_emailservice"));
    }


    private void update(Intent intent){
        n1 =  intent.getParcelableExtra("ListRemovedDup");
        //Print list after duplicated e-mails are removed
        Log.i("LOG EMAIL SERVICE:", "List Received "+ n1.email + " " + n1.next.email+ " " + n1.next.next.email);
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                Log.i("LOG EMAIL SERVICE:","broadcastReceiver OK");
                update(intent);
            }catch (Exception e){
                Log.e("LOG EMAIL SERVICE:", "broadcastReceiver"+e.getMessage());
            }
        }
    };
}
