package com.freedoctorhelpline.smsreading;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class SmsSearchResult extends AppCompatActivity {
    ArrayList number=new ArrayList();
    ArrayList message=new ArrayList();
    RecyclerView recyclerView;
    SMSResultRecycler mAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_search_result);
        Intent intent=getIntent();
        String a=intent.getStringExtra("search");
        Log.w("Abcde",a);
        String w=a.substring(1,a.length());
        String q=a.substring(0, 1).toUpperCase()+w;
        String e=a.substring(0, 1).toLowerCase()+w;

        Log.w("Abcq",q+e);
//        SMSRead smsRead=new SMSRead();
//        smsRead.onReceive(getApplicationContext(),intent);
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor c= getContentResolver().query(uri, null, null ,null,null);
        startManagingCursor(c);

        // Read the sms data and store it in the list
        if(c.moveToFirst()) {
            for(int i=0; i < c.getCount(); i++) {
                String d=(c.getString(c.getColumnIndexOrThrow("body")).toString());

                String b=(c.getString(c.getColumnIndexOrThrow("address")).toString());
                Log.w("Ab",b);
                //if (d.contains(a)||d.contains(a.toUpperCase())||d.contains(a.toLowerCase())||d.contains(a.substring(0, 1).toUpperCase())||d.contains(a.substring(0, 1).toLowerCase())){
                if(d.contains(a)||d.contains(a.toUpperCase())||d.contains(a.toLowerCase())||d.contains(q)||d.contains(e)){
                    number.add(d);
                    message.add(b);
                }
                c.moveToNext();
            }
        }
        c.close();
        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        mAdaptor=new SMSResultRecycler(getApplicationContext(),message,number);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdaptor);
        Log.w("Abc", String.valueOf(number));
        Log.w("Abcd", String.valueOf(message));
    }

}
