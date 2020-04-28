package com.cassio.cesar_emailservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.HashSet;

public class EmailService extends Service {
    Intent intentEmail;
    Node node = null;

    @Override
    public void onCreate() {
        intentEmail = new Intent("com.cassio.cesar_emailservice");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        node = intent.getParcelableExtra("NodeList");
        Log.i("LOG EMAIL SERVICE:", "Intent Received by service");



        Log.i("LOG EMAIL SERVICE:", "Remove duplicated e-mails executing");
        // Hash - stores emails already seen
        HashSet<String> hs = new HashSet<String>();

        Node current = node;
        Node prev = null;
        while (current != null)
        {
            String currentVal = current.email;

            if (hs.contains(currentVal)) {
                prev.next = current.next;
            } else {
                hs.add(currentVal);
                prev = current;
            }
            current = current.next;
        }

        intentEmail.putExtra("ListRemovedDup", node);

        sendBroadcast(intentEmail);
        Log.i("LOG EMAIL SERVICE:", "sendBroadcast called");

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
