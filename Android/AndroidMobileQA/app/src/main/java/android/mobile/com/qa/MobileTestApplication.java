package android.mobile.com.qa;

import android.app.Application;

import com.fasterxml.jackson.databind.ObjectMapper;


public class MobileTestApplication extends Application {

    private static MobileTestApplication sInstance;

    private ObjectMapper mGlobalMapper;


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mGlobalMapper = new ObjectMapper();

    }


    public static MobileTestApplication getInstance() {
        return sInstance;
    }

    public ObjectMapper getGlobalMapper() {
        return mGlobalMapper;
    }


}
