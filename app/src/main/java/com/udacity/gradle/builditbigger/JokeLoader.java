package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.example.saif.displayjoke.DisplayJoke;
import com.example.saif.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import static com.udacity.gradle.builditbigger.Constants.JOKE;

/**
 * Created by Saif on 21/06/2017.
 */

public class JokeLoader extends AsyncTask <Void,Void,String>{
    private static MyApi myApi = null;
    private Context context;
    public JokeLoader (Context context){
        this.context = context;
    }
    @Override
    protected String doInBackground(Void... params) {
        if(myApi == null){

            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null)
                    .setRootUrl("http://192.168.1.6:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApi = builder.build();
        }

        try {
            return myApi.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Intent intent = new Intent(context, DisplayJoke.class);
        intent.putExtra("joke",s);
        context.startActivity(intent);
    }
}
