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

public class MyInternationalBrandAdapter extends BaseAdapter {
    private ArrayList<InternationalBrand> internationalBrands=new ArrayList<>();
    Context context;

    public MyInternationalBrandAdapter(ArrayList<InternationalBrand> internationalBrands) {
        this.internationalBrands = internationalBrands;
    }

    @Override
    public int getCount() {
        return internationalBrands.size();
    }

    @Override
    public Object getItem(int position) {
        return internationalBrands.get(position);
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

        MyInternationalBrandAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyInternationalBrandAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(MyInternationalBrandAdapter.ViewHolder) convertView.getTag();
        }
        InternationalBrand internationalBrand=internationalBrands.get(position);
        holder.relativeLayout.setBackgroundResource(internationalBrand.getImageBackground());
        holder.price.setText(internationalBrand.getPrice()+"");
        holder.name.setText(internationalBrand.getName());
       // holder.address.setText(internationalbrand.getAddress());
        holder.type.setText(internationalBrand.getType());
        holder.city.setText(internationalBrand.getCity());

        return convertView;

    }
}
