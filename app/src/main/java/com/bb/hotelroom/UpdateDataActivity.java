package com.bb.hotelroom;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class UpdateDataActivity extends AppCompatActivity {
    private EditText etid,etname,etemail,etcity;
    private Button update_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);

        etid=(EditText)findViewById(R.id.uet_id);
        etname=(EditText)findViewById(R.id.uet_name);
        etemail=(EditText)findViewById(R.id.uet_email);
        etcity=(EditText)findViewById(R.id.uet_city);
        update_btn=findViewById(R.id.update_btn);

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(etid.getText().toString());
                String name=etname.getText().toString();
                String email=etemail.getText().toString();
                String city=etcity.getText().toString();


                List<MyDatalist> md= (List<MyDatalist>) new MyDatalist();
                md.setUid(md);
                md.setFirstName(name);
                md.setEmail(email);
                md.setCity(city);
                MainActivity.myDatabase.myDao(this, md).addData((MyDatalist) md);
                Toast.makeText(getApplicationContext(),"Data Updated",Toast.LENGTH_LONG).show();
                etid.setText("");
                etname.setText("");
                etemail.setText("");
                etcity.setText("");
            }
        });
    }
}
