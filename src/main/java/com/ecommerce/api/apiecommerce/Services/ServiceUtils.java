package com.ecommerce.api.apiecommerce.Services;

import netscape.javascript.JSObject;
import org.apache.commons.logging.Log;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceUtils {
    private final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");


    public String currentDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        return dateFormat.format(date);
    }
    public Date strToDate(String data)  {
        try {
            return df.parse(data);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
