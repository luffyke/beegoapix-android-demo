package org.smartx.beegoapix.api.service;


import org.smartx.beegoapix.api.bean.base.ApiRequest;
import org.smartx.beegoapix.api.bean.base.ApiResponse;
import org.smartx.beegoapix.api.bean.business.AppCheckVersionRequest;
import org.smartx.beegoapix.api.bean.business.AppCheckVersionResponse;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by kext on 16/8/13.
 */

public interface AppApiService {

    @POST("v1/app/check-version")
    Observable<ApiResponse<AppCheckVersionResponse>> checkVersion(@Body ApiRequest<AppCheckVersionRequest> request);
}
