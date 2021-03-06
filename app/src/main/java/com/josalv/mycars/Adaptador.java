package com.josalv.mycars;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private ArrayList<Car> listItems;
    private Context context;
    private static LayoutInflater inflater = null;


    public Adaptador(Context context, ArrayList<Car> listItems){
        this.context = context;
        this.listItems = listItems;

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Car item = (Car) getItem(position);

        // aquí se crea cada item de la lista
        convertView = inflater.inflate(R.layout.list_item_car, null);
        TextView tvMarca = (TextView) convertView.findViewById(R.id.tvMarca);
        TextView tvColor = (TextView) convertView.findViewById(R.id.tvColor);
        TextView tvModelo = (TextView) convertView.findViewById(R.id.tvModelo);
        TextView tvDescripcion = (TextView) convertView.findViewById(R.id.tvDescripcion);

        tvMarca.setText(item.getMarca());
        tvColor.setText(item.getColor());
        tvModelo.setText(item.getModelo());
        tvDescripcion.setText(item.getDescripcion());

        return convertView;
    }
}
