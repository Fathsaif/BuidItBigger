package com.udacity.gradle.builditbigger.test;

import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.util.Log;

import com.udacity.gradle.builditbigger.JokeLoader;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Saif on 28/06/2017.
 */
@RunWith(AndroidJUnit4.class)
public class AsynctaskTest extends AndroidTestCase {
    @Test
    public void doInBackground() throws Exception {

        try{

            MainActivity mainActivity = new MainActivity();
            JokeLoader jokeLoader = new JokeLoader(mainActivity,null);
            jokeLoader.execute();
            String result = jokeLoader.get(30, TimeUnit.SECONDS);

            assertNotNull(result);
            assertTrue(result.length() > 0);
        } catch (Exception e){
            Log.e("AsyncTaskTested", "testDoInBackground: Timed out");
        }
    }
}
