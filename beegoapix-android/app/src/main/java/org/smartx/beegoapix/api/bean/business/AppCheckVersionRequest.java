package org.smartx.beegoapix.api.bean.business;

/**
 * Created by kext on 16/8/13.
 */

public class AppCheckVersionRequest {

    public Integer versionCode;

    private AppCheckVersionRequest(Builder builder) {
        this.versionCode = builder.versionCode;
    }

    public static class Builder {

        private Integer versionCode;

        public Builder versionCode(Integer versionCode) {
            this.versionCode = versionCode;
            return this;
        }

        public AppCheckVersionRequest build() {
            return new AppCheckVersionRequest(this);
        }
    }
}
