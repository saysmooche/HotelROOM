package com.bb.hotelroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        List<MyDatalist>myDatalists;

    public MyAdapter(List<MyDatalist> myDatalists) {
            this.myDatalists = myDatalists;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_data,viewGroup,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            MyDatalist md=myDatalists.get(i);

            viewHolder.txtname.setText(md.getName());
            viewHolder.txtemail.setText(md.getEmail());
            viewHolder.txtcity.setText(md.getCity());
        }

        @Override
        public int getItemCount() {
            return myDatalists.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            private TextView txtid,txtname,txtemail,txtcity;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                txtname=(TextView)itemView.findViewById(R.id.txt_name);
                txtemail=(TextView)itemView.findViewById(R.id.txt_email);
                txtcity=(TextView)itemView.findViewById(R.id.txt_city);
            }
        }
    }
