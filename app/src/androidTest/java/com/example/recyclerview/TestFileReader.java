package com.example.recyclerview;

import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.recyclerview.data.CountryCovidData;
import com.example.recyclerview.data.GetCovidDataListFromJson;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TestFileReader {
    @Test
    public void covid_data_list_should_parse_231_countries() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        List<CountryCovidData> list = new GetCovidDataListFromJson().execute(appContext);
        assertEquals(231, list.size());
    }
}