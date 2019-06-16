package service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import java.util.logging.Handler;

public class MyService extends Service {
    public Context context = this;
    public Handler handler =  null;
    public Runnable runnable = null;

    public MyService() {}

    @Override
    public IBinder onBind (Intent intent) {return null;}

    @Override
    public void onCreate () {
        Toast.makeText(this, "Service created!", Toast.LENGTH_SHORT).show();

    handler = new Handler();
    runnable = new Runnable() {
        @Override
        public void run() {
            double randomNo = getRandomDoubleBetweenRanger(1,100);
            Toast.makeText(context, "Random no : " + randomNo , Toast.LENGTH_LONG).show();
            handler.postDelayed(runnable, 2000);
        }
    };
    handler.postDelayed(runnable, 2000);
    }
    public static double getRandomDoubleBetweenRanger(double min, double max) {
        return (Math.random()*((max-min)+1))+min;
    }
    @Override
    public void onDestroy ( ) {
        handler.removeCallbacks(runnable);
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show();
    }
}
