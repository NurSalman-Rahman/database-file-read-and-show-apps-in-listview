package com.example.data_read;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SQLdm {









        //Database storage path
        String filePath = "data/data/com.example.data_read/data.sqlite";
        //The folder where the database is stored under data/data/kaoqin.xxf.com.kaoqin
        String pathStr = "data/data/com.example.data_read";

        SQLiteDatabase database;
        public  SQLiteDatabase openDatabase(Context context){
            System.out.println("filePath:"+filePath);
            File jhPath=new File(filePath);
            //Check whether the database file exists
            if(jhPath.exists()){
                Log.i("test", "Database exists");
                //If exists, return to the opened database directly
                return SQLiteDatabase.openOrCreateDatabase(jhPath, null);
            }else{
                //Create folder first if it does not exist
                File path=new File(pathStr);
                Log.i("test", "pathStr="+path);
                if (path.mkdir()){
                    Log.i("test", "Created successfully");
                }else{
                    Log.i("test", "Failed to create");
                };
                try {
                    //Get resources
                    AssetManager am= context.getAssets();
                    //Get the input stream of the database
                    InputStream is=am.open("data.sqlite");
                    Log.i("test", is+"");
                    //Write to SDcard with output stream
                    FileOutputStream fos=new FileOutputStream(jhPath);
                    Log.i("test", "fos="+fos);
                    Log.i("test", "jhPath="+jhPath);
                    //Create byte array for 1KB write once
                    byte[] buffer=new byte[1024];
                    int count = 0;
                    while((count = is.read(buffer))>0){
                        Log.i("test", "Get");
                        fos.write(buffer,0,count);
                    }
                    //Finally close it
                    fos.flush();
                    fos.close();
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
                }
                //If there is no such database, we have written it to the SD card, and then execute this method once to return to the database
                return openDatabase(context);
            }
        }
    }



