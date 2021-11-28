package com.example.notifications;

import android.util.Log;

public class FirstThread extends Thread{
    int counter = 30;

    @Override
    public void run() {
        super.run();
        while(counter>0){
            try {
                Thread.sleep(1000);
                Log.d("service", "timer:" + counter);
                counter--;
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //stop the tread when getting to 0
        stop();
    }
}
