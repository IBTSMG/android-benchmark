package com.ibtech.smg.android_benchmark;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MySimpleArrayAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private final List<OrderItem> items;

    public MySimpleArrayAdapter(Activity activity, List<OrderItem> array) {
        this.inflater = activity.getLayoutInflater();
        this.items = array;
    }

    public int getCount() {
        return items.size();
    }

    public OrderItem getItem(int position) {
        return items.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        OrderItem item = items.get(position);

        View rowView;

        if (convertView == null) {
            rowView = inflater.inflate(R.layout.row_layout, parent, false);
        } else {
            rowView = (View) convertView;
        }

        TextView idView = (TextView) rowView.findViewById(R.id.row_id);
        TextView accountView = (TextView) rowView.findViewById(R.id.row_account);
        TextView itemView = (TextView) rowView.findViewById(R.id.row_item);
        TextView quantityView = (TextView) rowView.findViewById(R.id.row_quantity);
        TextView priceView = (TextView) rowView.findViewById(R.id.row_price);

        idView.setText(Integer.toString(item.getId()));
        accountView.setText(item.getAccount());
        itemView.setText(item.getItem());
        quantityView.setText(Integer.toString(item.getQuantity()));
        priceView.setText(Double.toString(item.getPrice()));

        return rowView;
    }
}
