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

public class MyAgenceVoyageAdapter extends BaseAdapter {
    private ArrayList<AgenceVoyage> agenceVoyages=new ArrayList<>();
    Context context;

    public MyAgenceVoyageAdapter(ArrayList<AgenceVoyage> agenceVoyages) {
        this.agenceVoyages = agenceVoyages;
    }

    @Override
    public int getCount() {
        return agenceVoyages.size();
    }

    @Override
    public Object getItem(int position) {
        return agenceVoyages.get(position);
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
        MyAgenceVoyageAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyAgenceVoyageAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(MyAgenceVoyageAdapter.ViewHolder) convertView.getTag();
        }
        AgenceVoyage agenceVoyage=agenceVoyages.get(position);
        holder.relativeLayout.setBackgroundResource(agenceVoyage.getImageBackground());
        holder.price.setText(agenceVoyage.getPrice()+"");
        holder.name.setText(agenceVoyage.getName());
        //holder.address.setText(agenceVoyage.getAddress());
        holder.type.setText(agenceVoyage.getType());
        holder.city.setText(agenceVoyage.getCity());

        return convertView;
    }
}
