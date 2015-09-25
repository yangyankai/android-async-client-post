package com.example.ykai.test_httpasyclient;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;


import org.json.*;
import com.loopj.android.http.*;

import java.io.IOException;
import java.net.URI;

import java.util.logging.LogRecord;


public class MainActivity extends ActionBarActivity {
    private static  Handler handler=new Handler();
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
textView=(TextView)findViewById(R.id.t1);


AsyncHttpClient myClient=new AsyncHttpClient();


       RequestParams params = new RequestParams();

        params.put("key", "value");  // 添加表单
       params.put("more", "data");    // 添加值
        File myFile = new File("/path/to/file.png");
        try {
            params.put("profile_picture", myFile);     //添加图片等文件
        } catch(FileNotFoundException e) {}
        finally {
            myClient.post("http://m.baidu.com/",params,responseHandler);
        }

     //   myClient.post("http://m.baidu.com/",responseHandler);
      //  myClient.get("http://m.baidu.com/", responseHandler);


    }
    ResponseHandlerInterface responseHandler=new ResponseHandlerInterface() {
        @Override
        public void sendResponseMessage(HttpResponse httpResponse) throws IOException {

            HttpEntity httpEntity = httpResponse.getEntity();
            if(httpResponse.getStatusLine().getStatusCode() == 200){
                InputStream inputStream = httpEntity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String result = "";
                String line = "";
                while ((line = reader.readLine()) != null)
                {
                    result = result + line;
                }

                textView.setText(result);
            }
            // textView.setText(httpResponse.getEntity().toString());
            //   textView.setText("x"+strResult);
        }

        @Override
        public void sendStartMessage() {

        }

        @Override
        public void sendFinishMessage() {

        }

        @Override
        public void sendProgressMessage(int i, int i2) {

        }

        @Override
        public void sendCancelMessage() {

        }

        @Override
        public void sendSuccessMessage(int i, Header[] headers, byte[] bytes) {

        }

        @Override
        public void sendFailureMessage(int i, Header[] headers, byte[] bytes, Throwable throwable) {

        }

        @Override
        public void sendRetryMessage(int i) {

        }

        @Override
        public URI getRequestURI() {
            return null;
        }

        @Override
        public Header[] getRequestHeaders() {
            return new Header[0];
        }

        @Override
        public void setRequestURI(URI uri) {

        }

        @Override
        public void setRequestHeaders(Header[] headers) {

        }

        @Override
        public void setUseSynchronousMode(boolean b) {

        }

        @Override
        public boolean getUseSynchronousMode() {
            return false;
        }

        @Override
        public void onPreProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {

        }

        @Override
        public void onPostProcessResponse(ResponseHandlerInterface responseHandlerInterface, HttpResponse httpResponse) {

        }
    };


}
