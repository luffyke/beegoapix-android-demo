package org.smartx.beegoapix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import org.smartx.beegoapix.api.ApiFactory;
import org.smartx.beegoapix.api.RxHelper;
import org.smartx.beegoapix.api.RxSubscriber;
import org.smartx.beegoapix.api.bean.base.ApiRequest;
import org.smartx.beegoapix.api.bean.base.ApiResponse;
import org.smartx.beegoapix.api.bean.business.AppCheckVersionRequest;
import org.smartx.beegoapix.api.bean.business.AppCheckVersionResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button1)
    void checkVersion() {
        AppCheckVersionRequest request = new AppCheckVersionRequest.Builder()
                .versionCode(1)
                .build();
        ApiRequest<AppCheckVersionRequest> apiRequest = new ApiRequest<>(this);
        apiRequest.data = request;
        ApiFactory.create().getAppApiService()
                .checkVersion(apiRequest)
                .compose(RxHelper.<AppCheckVersionResponse>handleResult())
                .subscribe(new RxSubscriber<ApiResponse<AppCheckVersionResponse>>(this) {
                    @Override
                    public void onNext(ApiResponse<AppCheckVersionResponse> response) {
                        Toast.makeText(MainActivity.this, response.data.versionName, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
