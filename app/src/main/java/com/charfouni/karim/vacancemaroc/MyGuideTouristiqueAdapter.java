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

public class MyGuideTouristiqueAdapter extends BaseAdapter {
    private ArrayList<GuideTouristique> guideTouristiques=new ArrayList<>();
    Context context;
    @Override
    public int getCount() {
        return guideTouristiques.size();
    }

    @Override
    public Object getItem(int position) {
        return guideTouristiques.get(position);
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
        MyGuideTouristiqueAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyGuideTouristiqueAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(MyGuideTouristiqueAdapter.ViewHolder) convertView.getTag();
        }
        GuideTouristique guideTouristique=guideTouristiques.get(position);
        holder.relativeLayout.setBackgroundResource(guideTouristique.getImageBackground());
        holder.price.setText(guideTouristique.getPrice()+"");
        holder.name.setText(guideTouristique.getName());
        // holder.address.setText(cafe.getAddress());
        holder.type.setText(guideTouristique.getType());
        holder.city.setText(guideTouristique.getCity());
        return convertView;
    }

    public MyGuideTouristiqueAdapter(ArrayList<GuideTouristique> guideTouristiques) {
        this.guideTouristiques = guideTouristiques;
    }
}
