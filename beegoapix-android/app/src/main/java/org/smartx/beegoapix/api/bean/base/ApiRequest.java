package org.smartx.beegoapix.api.bean.base;

import android.content.Context;

/**
 * Created by kext on 16/8/11.
 */

public class ApiRequest<T> {

    public String id;

    public String sign;

    public Client client;

    public Page page;

    public User user;

    public T data;

    public ApiRequest(Context context) {
        this.id = generateId();
        this.client = Client.init(context);
    }

    private String generateId() {
        String chars = "0123456789";
        char[] rands = new char[6];
        for (int i = 0; i < rands.length; i++) {
            int rand = (int) (Math.random() * 10);
            rands[i] = chars.charAt(rand);
        }
        return String.valueOf(System.currentTimeMillis()) + new String(rands);
    }

}
