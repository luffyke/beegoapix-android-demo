package org.smartx.beegoapix.api;


import org.smartx.beegoapix.api.bean.base.ApiResponse;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by kext on 16/8/18.
 */

public final class RxHelper {

    private RxHelper() {
    }

    public static <T> Observable.Transformer<ApiResponse<T>, ApiResponse<T>> handleResult() {
        return new Observable.Transformer<ApiResponse<T>, ApiResponse<T>>() {
            @Override
            public Observable<ApiResponse<T>> call(Observable<ApiResponse<T>> tObservable) {
                return tObservable.flatMap(new Func1<ApiResponse<T>, Observable<ApiResponse<T>>>() {
                    @Override
                    public Observable<ApiResponse<T>> call(ApiResponse<T> response) {
                        if (response.state.code == 0) {
                            return createData(response);
                        } else {
                            return Observable.error(new ApiException(response.state));
                        }
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    private static <T> Observable<T> createData(final T data) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(data);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
