package com.freedoctorhelpline.smsreading;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText searchView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView=(EditText)findViewById(R.id.searchbox);
        button=(Button)findViewById(R.id.searchbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a= String.valueOf(searchView.getText());
                Intent intent=new Intent(MainActivity.this,SmsSearchResult.class);
                intent.putExtra("search", a);
                startActivity(intent);
            }
        });
    }
}
