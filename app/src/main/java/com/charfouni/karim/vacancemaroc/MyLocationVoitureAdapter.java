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
 * Created by karim on 9/25/2017.
 */

public class MyLocationVoitureAdapter extends BaseAdapter {
    private ArrayList<LocationVoiture> locationVoitures=new ArrayList<>();
    Context context;

    public MyLocationVoitureAdapter(ArrayList<LocationVoiture> locationVoitures) {
        this.locationVoitures = locationVoitures;
    }

    @Override
    public int getCount() {
        return locationVoitures.size();
    }

    @Override
    public Object getItem(int position) {
        return locationVoitures.get(position);
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
        MyLocationVoitureAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyLocationVoitureAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(MyLocationVoitureAdapter.ViewHolder) convertView.getTag();
        }
        LocationVoiture locationVoiture=locationVoitures.get(position);
        holder.relativeLayout.setBackgroundResource(locationVoiture.getImageBackground());
        holder.price.setText(locationVoiture.getPrice()+"");
        holder.name.setText(locationVoiture.getName());
        //holder.address.setText(locationVoiture.getAddress());
        holder.type.setText(locationVoiture.getType());
        holder.city.setText(locationVoiture.getCity());

        return convertView;

    }
}
