package com.bb.hotelroom;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReadDataActivity extends AppCompatActivity {
        private RecyclerView rv;
        private Context context;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_savedata);
            rv=(RecyclerView)findViewById(R.id.recycler);
            rv.setHasFixedSize(true);
            rv.setLayoutManager(new LinearLayoutManager(this));

            getData(context);
        }

        private void getData(final Context context) {
            class GetData extends AsyncTask<Void,Void,List<MyDatalist>>{

            @Override
            protected List<MyDatalist> doInBackground(Void... voids) {
                List<MyDatalist>myDatalist = null;
                myDatalist = MainActivity.myDatabase.myDao(context, myDatalist).getMyDatalist();

                return myDatalist;

            }

            protected void onPostExecute(List<MyDatalist> myDatalist) {
                MyAdapter adapter=new MyAdapter(myDatalist);
                rv.setAdapter(adapter);
                super.onPostExecute(myDatalist);
            }
        }
            GetData gd=new GetData();
            gd.execute();
        }
    }