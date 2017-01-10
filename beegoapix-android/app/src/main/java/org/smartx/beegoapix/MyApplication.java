package org.smartx.beegoapix;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kext on 16/12/13.
 */

public class MyApplication extends Application {

    private static MyApplication singleton;

    private Map<String, Object> map = new HashMap<>();

    public static MyApplication getInstance() {
        return singleton;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
    }

    public void setValue(String key, Object value) {
        map.put(key, value);
    }

    public Object getValue(String key) {
        return map.get(key);
    }
}
