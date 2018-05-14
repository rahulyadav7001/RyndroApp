package com.ryandro.ryndroapp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.ryandro.ryndroapp.BaseActivity;
import com.ryandro.ryndroapp.R;

import org.json.JSONObject;

import butterknife.ButterKnife;

public class FacebookImplementActivity extends BaseActivity {

    //    @Bind(R.id.login_button)
    LoginButton loginButton;
    //    @Bind(R.id.tv_status)
    TextView tv_status, tv_userName, tv_UserEmail;
    private LoginManager loginManager;
    private CallbackManager callbackManager;

    @Override
    public void initialize() {
        inflater.inflate(R.layout.activity_facebook_implement, flBody, true);
        ButterKnife.bind(this);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        tv_status = (TextView) findViewById(R.id.tv_status);
        tv_userName = (TextView) findViewById(R.id.tv_UserName);
        tv_UserEmail = (TextView) findViewById(R.id.tv_email);
        loginButton.setReadPermissions("email");
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                getUserData(loginResult);
                tv_status.setText("Login Success\n" + loginResult.getAccessToken().getUserId() + "\n" + loginResult.getAccessToken().toString());
            }

            @Override
            public void onCancel() {
                tv_status.setText("Login Cencel");
            }

            @Override
            public void onError(FacebookException error) {
                tv_status.setText("Erro Occor:\n" + error.getMessage().toString());

            }
        });
    }

    protected void getUserData(LoginResult loginResult) {

        GraphRequest data_Request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    tv_userName.setText(object.get("name").toString() + "");
                    tv_UserEmail.setText(object.get("email").toString() + "");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Bundle data = new Bundle();
        data.putString("fields", "id,name,email,picture.width(120).height(120)");
        data_Request.setParameters(data);
        data_Request.executeAsync();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
