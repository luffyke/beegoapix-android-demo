package org.smartx.beegoapix.api;

import org.smartx.beegoapix.api.service.AppApiService;

/**
 * Created by kext on 16/8/12.
 */

public class ApiFactory {

    private AppApiService appApiService;

    private static final ApiFactory INSTANCE = new ApiFactory();

    public static ApiFactory create() {
        return INSTANCE;
    }

    private ApiFactory() {
        this.appApiService = ApiClient.getInstance().getRetrofit().create(AppApiService.class);
    }

    public AppApiService getAppApiService() {
        return this.appApiService;
    }
}
