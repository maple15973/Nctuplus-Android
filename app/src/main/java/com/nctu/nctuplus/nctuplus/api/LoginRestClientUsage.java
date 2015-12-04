package com.nctu.nctuplus.nctuplus.api;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nctu.nctuplus.nctuplus.R;
import com.nctu.nctuplus.nctuplus.utils.ToastUtil;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cober on 2015/12/4.
 */
public class LoginRestClientUsage {
    private final String LOG_TAG = getClass().getSimpleName();
    private Context context;

    public LoginRestClientUsage(Context context) {
        this.context = context;
    }

    public void postUser(String username, String password) {
        RequestParams requestParams = new RequestParams();
        requestParams.put("key", context.getString(R.string.key));
        requestParams.put("username", username);
        requestParams.put("password", password);
        BaseRestClient.post(context.getString(R.string.url_login), requestParams, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    ToastUtil.shortToast(context, response.getJSONObject("user").getString("name"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                ToastUtil.shortToast(context, context.getString(R.string.connect_error));
            }
        });
    }
}
