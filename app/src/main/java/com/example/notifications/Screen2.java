package com.example.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;

public class Screen2 extends AppCompatActivity {
    Button btn_push, btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        btn_cancel = findViewById(R.id.btn_cancel);
        btn_push = findViewById(R.id.btn_push);
        btn_push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //phase 1
                //int icon2 = R.drawable.ic_baseline_circle_notifications_24;
                int icon = android.R.drawable.star_on;
                String ticket = "this is the ticket message";
                long when = System.currentTimeMillis();
                String title = "title";
                String ticker = "ticker";
                String text = "text";

                //phase 2
                Intent intent = new Intent(Screen2.this, MainActivity.class);
                intent.putExtra("key", "i want a burekas");
                PendingIntent pendingIntent = PendingIntent.getActivity(Screen2.this,
                        0, intent,0);
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                //phase 3
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        getApplicationContext());
                Notification notification = builder.setContentIntent(pendingIntent).
                        setSmallIcon(icon).
                        setTicker(ticker).
                        setWhen(when).
                        setAutoCancel(true).
                        setContentTitle(title).setContentText(text).build();
                notificationManager.notify(1, notification);

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.cancel(1);
            }
        });
    }
}