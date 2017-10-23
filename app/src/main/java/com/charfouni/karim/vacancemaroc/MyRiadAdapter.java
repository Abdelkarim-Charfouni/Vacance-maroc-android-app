package com.charfouni.karim.vacancemaroc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by karim on 9/23/2017.
 */

public class MyRiadAdapter extends BaseAdapter {
    private ArrayList<Riad> riads=new ArrayList<Riad>();
    Context context;

    public MyRiadAdapter(ArrayList<Riad> riads) {
        this.riads = riads;
    }

    @Override
    public int getCount() {
        return riads.size();
    }

    @Override
    public Object getItem(int position) {
        return riads.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        TextView type;
        TextView name;
        //TextView address;
        TextView city;
        TextView price;
        RelativeLayout relativeLayout;

        ViewHolder(View view){
            type=(TextView) view.findViewById(R.id.tvType);
            name=(TextView) view.findViewById(R.id.tvName);
            //address=(TextView) view.findViewById(R.id.tvAdress);
            city=(TextView) view.findViewById(R.id.tvCity);
            price=(TextView) view.findViewById(R.id.tvPrice);
            relativeLayout=(RelativeLayout)view.findViewById(R.id.relativeLayout);
        }

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyRiadAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyRiadAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(ViewHolder) convertView.getTag();
        }
        Riad riad=riads.get(position);
        holder.relativeLayout.setBackgroundResource(riad.getImageBackground());
        holder.price.setText(riad.getPrice()+"");
        holder.name.setText(riad.getName());
        //holder.address.setText(riad.getAddress());
        holder.type.setText(riad.getType());
        holder.city.setText(riad.getCity());



        return convertView;
    }
}
