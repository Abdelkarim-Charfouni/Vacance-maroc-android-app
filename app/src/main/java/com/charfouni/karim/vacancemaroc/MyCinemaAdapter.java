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

public class MyCinemaAdapter extends BaseAdapter {
    private ArrayList<Cinema> cinemas=new ArrayList<>();
    Context context;

    public MyCinemaAdapter(ArrayList<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    @Override
    public int getCount() {
        return cinemas.size();
    }

    @Override
    public Object getItem(int position) {
        return cinemas.get(position);
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

        MyCinemaAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyCinemaAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(MyCinemaAdapter.ViewHolder) convertView.getTag();
        }
        Cinema cinema=cinemas.get(position);
        holder.relativeLayout.setBackgroundResource(cinema.getImageBackground());
        holder.price.setText(cinema.getPrice()+"");
        holder.name.setText(cinema.getName());
        //holder.address.setText(cinema.getAddress());
        holder.type.setText(cinema.getType());
        holder.city.setText(cinema.getCity());

        return convertView;

    }
}
