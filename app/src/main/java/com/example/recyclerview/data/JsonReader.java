package com.example.recyclerview.data;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
public class JsonReader {
    private static String charSet = "UTF-8";
    protected static String jsonToString(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer, charSet);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonString;
    }
}