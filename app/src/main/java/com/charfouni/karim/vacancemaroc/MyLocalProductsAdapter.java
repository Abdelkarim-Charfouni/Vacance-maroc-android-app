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

public class MyLocalProductsAdapter extends BaseAdapter {
    private ArrayList<LocalProduct> localProducts=new ArrayList<>();
    Context context;

    public MyLocalProductsAdapter(ArrayList<LocalProduct> localProducts) {
        this.localProducts = localProducts;
    }

    @Override
    public int getCount() {
        return localProducts.size();
    }

    @Override
    public Object getItem(int position) {
        return localProducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder{
        TextView type;
        TextView name;
       // TextView address;
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
        MyLocalProductsAdapter.ViewHolder holder=null;
        if(convertView==null) {
            //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //inflater.inflate(R.layout.place_layout, parent, false);
            convertView= LayoutInflater.from(parent.getContext()).inflate(R.layout.hotel_layout,null);
            holder=new MyLocalProductsAdapter.ViewHolder(convertView);
            convertView.setTag(holder);

        }else{
            holder=(MyLocalProductsAdapter.ViewHolder) convertView.getTag();
        }
        LocalProduct localProduct=localProducts.get(position);
        holder.relativeLayout.setBackgroundResource(localProduct.getImageBackground());
        holder.price.setText(localProduct.getPrice()+"");
        holder.name.setText(localProduct.getName());
        //holder.address.setText(localProduct.getAddress());
        holder.type.setText(localProduct.getType());
        holder.city.setText(localProduct.getCity());

        return convertView;

    }
}
