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

public class MyArtisanatMarocaineAdapter extends BaseAdapter {
    private ArrayList<ArtisanatMarocaine> artisanatMarocaines=new ArrayList<>();
    Context context;

    public MyArtisanatMarocaineAdapter(ArrayList<ArtisanatMarocaine> artisanatMarocaines) {
        this.artisanatMarocaines = artisanatMarocaines;
    }

    @Override
    public int getCount() {
        return artisanatMarocaines.size();
    }

    @Override
    public Object getItem(int position) {
        return artisanatMarocaines.get(position);
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
        MyArtisanatMarocaineAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyArtisanatMarocaineAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(MyArtisanatMarocaineAdapter.ViewHolder) convertView.getTag();
        }
        ArtisanatMarocaine artisanatMarocaine=artisanatMarocaines.get(position);
        holder.relativeLayout.setBackgroundResource(artisanatMarocaine.getImageBackground());
        holder.price.setText(artisanatMarocaine.getPrice()+"");
        holder.name.setText(artisanatMarocaine.getName());
        //holder.address.setText(artisanatMarocaine.getAddress());
        holder.type.setText(artisanatMarocaine.getType());
        holder.city.setText(artisanatMarocaine.getCity());

        return convertView;

    }
}
