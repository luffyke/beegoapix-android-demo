package org.smartx.beegoapix.api.bean.base;

import android.content.Context;

import org.smartx.beegoapix.BuildConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kext on 16/8/11.
 */

public class Client {

    // 调用来源, app或者h5
    private String caller = "app";

    // 客户端系统信息
    private String os = "";

    // 版本号
    private String ver = String.valueOf(BuildConfig.VERSION_CODE);

    // 平台,android或者ios
    private String platform = "android";

    // 渠道
    private String ch = BuildConfig.FLAVOR;

    // 扩展标识
    private Map<String, Object> ex;

    private Client(Builder builder) {
        this.ex = builder.ex;
    }

    public static class Builder {

        private Map<String, Object> ex;

        public Builder ex(Map<String, Object> ex) {
            this.ex = ex;
            return this;
        }

        public Builder ex(String key, Object value) {
            if (this.ex == null) {
                this.ex = new HashMap<>();
            }
            this.ex.put(key, value);
            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    public static Client init(Context context) {
        String imei = "";
        String mac = "";
        String lang = "";
        return new Client.Builder()
                .ex("imei", imei)
                .ex("mac", mac)
                .ex("lang", lang)
                .build();
    }

}
