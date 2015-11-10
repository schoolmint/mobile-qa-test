package android.mobile.com.qa.net;


import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;

public class RestClient {

    private RestClientService mRestClientService;

    private static RestClient sInstance;

    public static RestClient getInstance() {
        if (sInstance == null) {
            sInstance = new RestClient();
        }

        return sInstance;
    }

    private RestClient() {
        mRestClientService = new RestAdapter.Builder()
                .setEndpoint("http://successfull.schoolmintqa.net")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new JacksonConverter())
                .setClient(new OkClient(new OkHttpClient()))
                .build().create(RestClientService.class);
    }


    public RestClientService getClientService() {
        return mRestClientService;
    }

}
