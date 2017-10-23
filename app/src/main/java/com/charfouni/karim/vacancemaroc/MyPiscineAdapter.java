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
 * Created by karim on 9/24/2017.
 */

public class MyPiscineAdapter extends BaseAdapter {
    private ArrayList<Piscine> piscines=new ArrayList<Piscine>();
    Context context;

    public MyPiscineAdapter(ArrayList<Piscine> piscines) {
        this.piscines = piscines;
    }

    @Override
    public int getCount() {
        return piscines.size();
    }

    @Override
    public Object getItem(int position) {
        return piscines.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        TextView type;
        TextView name;
       // TextView address;
        TextView city;
        TextView price;
        RelativeLayout relativeLayout;

        ViewHolder(View view){
            type=(TextView) view.findViewById(R.id.tvType);
            name=(TextView) view.findViewById(R.id.tvName);
           // address=(TextView) view.findViewById(R.id.tvAdress);
            city=(TextView) view.findViewById(R.id.tvCity);
            price=(TextView) view.findViewById(R.id.tvPrice);
            relativeLayout=(RelativeLayout)view.findViewById(R.id.relativeLayout);
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyPiscineAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyPiscineAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(MyPiscineAdapter.ViewHolder) convertView.getTag();
        }
        Piscine piscine=piscines.get(position);
        holder.relativeLayout.setBackgroundResource(piscine.getImageBackground());
        holder.price.setText(piscine.getPrice()+"");
        holder.name.setText(piscine.getName());
        //holder.address.setText(piscine.getAddress());
        holder.type.setText(piscine.getType());
        holder.city.setText(piscine.getCity());
        return convertView;
    }
}
