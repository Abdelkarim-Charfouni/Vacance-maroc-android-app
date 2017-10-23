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
 * Created by karim on 22/09/17.
 */

public class MyHotelAdapter extends BaseAdapter {
    private ArrayList<Hotel> hotels=new ArrayList<Hotel>();
    Context context;

    public MyHotelAdapter(ArrayList<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public int getCount() {
        return hotels.size();
    }

    @Override
    public Object getItem(int position) {
        return hotels.get(position);
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
        ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(ViewHolder)convertView.getTag();
        }
        Hotel hotel=hotels.get(position);
        holder.relativeLayout.setBackgroundResource(hotel.getImageBackground());
        holder.price.setText(hotel.getPrice()+"");
        holder.name.setText(hotel.getName());
       // holder.address.setText(hotel.getAddress());
        holder.type.setText(hotel.getType());
        holder.city.setText(hotel.getCity());


        return convertView;
    }
}
