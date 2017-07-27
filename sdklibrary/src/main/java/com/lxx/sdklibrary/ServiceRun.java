package com.lxx.sdklibrary;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by android on 2017/7/27.
 */
public class ServiceRun implements Runnable {

    public Handler handler;

    private static Context mContext;

    private static ServiceRun serviceRun;

    private Looper myLooper;

    public static ServiceRun getInstance(Context context) {
        if (serviceRun == null) {
            serviceRun = new ServiceRun();
            init(context);
        }
        return serviceRun;
    }

    private ServiceRun() {
    }

    private static void init(Context context) {
        mContext = context;
    }


    @Override
    public void run() {
        Looper.prepare();
        myLooper = Looper.myLooper();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:
                       // destroy();
                        break;
                    case 1:
                        Toast.makeText(mContext, msg.obj.toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        break;
                }
            }
        };
        Looper.loop();
        Log.e("tag", "loop()方法执行完了");
        Toast.makeText(mContext, "Loop死le", Toast.LENGTH_SHORT).show();
    }

    public void destroy() {
        if (myLooper != null) {
            myLooper.quit();
            myLooper = null;
        }
    }
}
