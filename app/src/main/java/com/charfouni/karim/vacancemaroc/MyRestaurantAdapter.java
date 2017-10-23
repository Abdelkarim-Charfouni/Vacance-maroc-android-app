package com.charfouni.karim.vacancemaroc;

import android.content.Context;
import android.view.CollapsibleActionView;
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

public class MyRestaurantAdapter extends BaseAdapter {
    private ArrayList<Restaurant> restaurants=new ArrayList<>();
    Context context;

    public MyRestaurantAdapter(ArrayList<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public int getCount() {
        return restaurants.size();
    }

    @Override
    public Object getItem(int position) {
        return restaurants.get(position);
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
        MyRestaurantAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyRestaurantAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(MyRestaurantAdapter.ViewHolder) convertView.getTag();
        }
        Restaurant restaurant=restaurants.get(position);
        holder.relativeLayout.setBackgroundResource(restaurant.getImageBackground());
        holder.price.setText(restaurant.getPrice()+"");
        holder.name.setText(restaurant.getName());
        //holder.address.setText(restaurant.getAddress());
        holder.type.setText(restaurant.getType());
        holder.city.setText(restaurant.getCity());
        return convertView;
    }
}
