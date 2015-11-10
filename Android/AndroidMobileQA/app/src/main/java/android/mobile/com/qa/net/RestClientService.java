package android.mobile.com.qa.net;


import com.fasterxml.jackson.databind.node.ArrayNode;

import retrofit.Callback;
import retrofit.http.GET;

public interface RestClientService {

    @GET("/api/v1/languages.json")
    void networkRequest(Callback<ArrayNode> callback);
}
