package org.smartx.beegoapix.api;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import org.smartx.beegoapix.MyApplication;
import org.smartx.beegoapix.api.bean.base.ApiRequest;
import org.smartx.beegoapix.api.bean.base.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by kext on 17/1/7.
 */

public class SessionInterceptor implements Interceptor {

    private static List<String> loginList = new ArrayList<>();

    static {
        loginList.add("/v1/user/get-details");
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Context context = MyApplication.getInstance().getApplicationContext();
        SharedPreferences sp = context.getSharedPreferences("user", Context.MODE_PRIVATE);
        String uid = null;
        String sid = null;
        if (sp != null) {
            uid = sp.getString("uid", null);
            sid = sp.getString("sid", null);
        }
        if (loginList.contains(request.url().url().getPath())) {
            if (uid == null || sid == null) {
                //Looper.prepare();
                //AppUtils.showToast(context, R.string.hint_need_login);
                //context.startActivity(new Intent(context, LoginActivity.class));
                //Looper.loop();
                return chain.proceed(request.newBuilder().tag(OKHttpUtils.CANCEL_TAG).build());
            }
        }
        if (sp != null) {
            // add user
            String body = OKHttpUtils.bodyToString(request.body());
            ApiRequest apiRequest = new Gson().fromJson(body, ApiRequest.class);
            User user = new User();
            user.setSid(sid);
            user.setUid(uid);
            apiRequest.user = user;
            return chain.proceed(
                    request.newBuilder()
                            .method(request.method(), RequestBody.create(request.body().contentType(), new Gson().toJson(apiRequest)))
                            .build());
        } else {
            return chain.proceed(request);
        }

    }

}
