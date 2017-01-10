package org.smartx.beegoapix.api;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okio.Buffer;

/**
 * Created by kext on 17/1/8.
 */

public final class OKHttpUtils {

    public static final String CANCEL_TAG = "cancel";

    public static void cancelCallWithTag(OkHttpClient client) {
        for (Call call : client.dispatcher().queuedCalls()) {
            if (CANCEL_TAG.equals(call.request().tag())) {
                call.cancel();
            }
        }
        for (Call call : client.dispatcher().runningCalls()) {
            if (CANCEL_TAG.equals(call.request().tag())) {
                call.cancel();
            }
        }
    }

    public static String bodyToString(final RequestBody request) throws IOException {
        final RequestBody copy = request;
        final Buffer buffer = new Buffer();
        copy.writeTo(buffer);
        return buffer.readUtf8();
    }
}
