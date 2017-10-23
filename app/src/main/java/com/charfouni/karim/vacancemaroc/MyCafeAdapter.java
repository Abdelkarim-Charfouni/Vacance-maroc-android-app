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

public class MyCafeAdapter extends BaseAdapter {
    private ArrayList<Cafe> cafes=new ArrayList<>();
    Context context;

    public MyCafeAdapter(ArrayList<Cafe> cafes) {
        this.cafes = cafes;
    }

    @Override
    public int getCount() {
        return cafes.size();
    }

    @Override
    public Object getItem(int position) {
        return cafes.get(position);
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
           // address=(TextView) view.findViewById(R.id.tvAdress);
            city=(TextView) view.findViewById(R.id.tvCity);
            price=(TextView) view.findViewById(R.id.tvPrice);
            relativeLayout=(RelativeLayout)view.findViewById(R.id.relativeLayout);
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyCafeAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyCafeAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(MyCafeAdapter.ViewHolder) convertView.getTag();
        }
        Cafe cafe=cafes.get(position);
        holder.relativeLayout.setBackgroundResource(cafe.getImageBackground());
        holder.price.setText(cafe.getPrice()+"");
        holder.name.setText(cafe.getName());
       // holder.address.setText(cafe.getAddress());
        holder.type.setText(cafe.getType());
        holder.city.setText(cafe.getCity());
        return convertView;
    }
}
