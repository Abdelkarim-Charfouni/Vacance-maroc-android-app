package com.charfouni.karim.vacancemaroc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by karim on 9/24/2017.
 */

public class MyAubergeAdapter extends BaseAdapter {
    private ArrayList<Auberge> auberges=new ArrayList<Auberge>();
    Context context;

    public MyAubergeAdapter(ArrayList<Auberge> auberges) {
        this.auberges = auberges;
    }

    @Override
    public int getCount() {
        return auberges.size();
    }

    @Override
    public Object getItem(int position) {
        return auberges.get(position);
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
        MyAubergeAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyAubergeAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(MyAubergeAdapter.ViewHolder) convertView.getTag();
        }
        Auberge auberge=auberges.get(position);
        holder.relativeLayout.setBackgroundResource(auberge.getImageBackground());
        holder.price.setText(auberge.getPrice()+"");
        holder.name.setText(auberge.getName());
        //holder.address.setText(auberge_icon.getAddress());
        holder.type.setText(auberge.getType());
        holder.city.setText(auberge.getCity());

        return convertView;
    }
}
