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
 * Created by karim on 9/28/2017.
 */

public class MyPlaceAdapter extends BaseAdapter {
    private ArrayList<Place> places=new ArrayList<>();
    Context context;

    public MyPlaceAdapter(ArrayList<Place> places) {
        this.places = places;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Object getItem(int position) {
        return places.get(position);
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
        MyPlaceAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyPlaceAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(MyPlaceAdapter.ViewHolder) convertView.getTag();
        }
        Place place=places.get(position);
        holder.relativeLayout.setBackgroundResource(place.getImageBackground());
        holder.price.setText(place.getPrice()+"");
        holder.name.setText(place.getName());
        //holder.address.setText(cinema.getAddress());
        holder.type.setText(place.getType());
        holder.city.setText(place.getCity());

        return convertView;
    }
}
