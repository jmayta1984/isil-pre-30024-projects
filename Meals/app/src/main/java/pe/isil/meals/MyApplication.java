package pe.isil.meals;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static MyApplication application;

    private static Application getApplication() {
        return application;
    }

    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

}
