package org.smartx.beegoapix.api;

import android.content.Context;
import android.widget.Toast;

import org.smartx.beegoapix.R;

import java.net.ConnectException;

import rx.Subscriber;

/**
 * Created by kext on 16/8/16.
 */

public abstract class RxSubscriber<T> extends Subscriber<T> {

    private Context context;

    public RxSubscriber(Context context) {
        this.context = context;
    }

    @Override
    public void onCompleted() {
    }

    @Override
    public void onError(Throwable e) {
        // 默认showToast,个性化需求让子类处理
        if (e instanceof ApiException) {
            Toast.makeText(context, ((ApiException) e).getState().msg, Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(context, R.string.error_connection, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, R.string.error_system, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNext(T t) {
    }
}
