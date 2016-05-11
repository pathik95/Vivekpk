package in.vaksys.vivekpk.extras;

/**
 * Created by dell980 on 5/3/2016.
 */

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import in.vaksys.vivekpk.fragments.MainTabFragment;

public class MyApplication extends Application {
    public static final String TAG = MyApplication.class.getSimpleName();
    private MainTabFragment currentFragment=null;

    public MainTabFragment getCurrentFragment() {
        return currentFragment;
    }

    public void setCurrentFragment(MainTabFragment currentFragment) {
        this.currentFragment = currentFragment;
    }

    private static MyApplication mInstance;
    private RequestQueue mRequestQueue;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    int value;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

    }

    // for volley
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    // common in volley singleton and analytics
    public static synchronized MyApplication getInstance() {
        return mInstance;
    }

}