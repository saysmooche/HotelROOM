package com.bb.hotelroom;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddDataActivity extends AppCompatActivity {
        EditText etid,etname,etemail,etcity;
        private Button btn_save;
        private Context context;
        private List<MyDatalist> myDatalist;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_savedata);


            etid=(EditText)findViewById(R.id.editid);
            etname=(EditText)findViewById(R.id.editname);
            etemail=(EditText)findViewById(R.id.editemail);
            etcity=(EditText)findViewById(R.id.editcity);
            btn_save=(Button)findViewById(R.id.btn_add);

            btn_save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int uid=Integer.parseInt(etid.getText().toString());

                    String name=etname.getText().toString();
                    String email=etemail.getText().toString();
                    String city=etcity.getText().toString();
                    MyDatalist myDataList=new MyDatalist();
                    myDataList.setId(uid);
                    myDataList.setName(name);
                    myDataList.setEmail(email);
                    myDataList.setCity(city);

                    MainActivity.myDatabase.myDao(context, myDatalist).addData((MyDatalist) myDatalist);
                    Toast.makeText(getApplicationContext(),"Data Save",Toast.LENGTH_LONG).show();
                    etid.setText("");
                    etname.setText("");
                    etemail.setText("");
                    etcity.setText("");
                }
            });
        }
    }
