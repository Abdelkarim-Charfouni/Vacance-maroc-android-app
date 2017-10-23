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
 * Created by karim on 10/8/2017.
 */

public class MyAvisiterAdapter extends BaseAdapter {
    private ArrayList<Avisiter> avisiters=new ArrayList<>();
    Context context;

    public MyAvisiterAdapter(ArrayList<Avisiter> avisiters) {
        this.avisiters = avisiters;
    }
    @Override
    public int getCount() {
        return avisiters.size();
    }

    @Override
    public Object getItem(int position) {
        return avisiters.get(position);
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

        MyAvisiterAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyAvisiterAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(MyAvisiterAdapter.ViewHolder) convertView.getTag();
        }
        Avisiter avisiter=avisiters.get(position);
        holder.relativeLayout.setBackgroundResource(avisiter.getImageBackground());
        holder.price.setText(avisiter.getPrice()+"");
        holder.name.setText(avisiter.getName());
        // holder.address.setText(cafe.getAddress());
        holder.type.setText(avisiter.getType());
        holder.city.setText(avisiter.getCity());
        return convertView;
    }
}
