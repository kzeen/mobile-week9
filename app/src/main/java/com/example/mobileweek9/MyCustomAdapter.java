package com.example.mobileweek9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyCustomAdapter extends BaseAdapter {
    private Context context;
    private List<Fruit> itemList;

    // Constructor
    public MyCustomAdapter(Context context, List<Fruit> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size(); // Returns the total number of items
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position); // Returns the item at the given position
    }

    @Override
    public long getItemId(int position) {
        return position; // Returns the item's ID (usually the position)
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Get the current item
        Fruit item = itemList.get(position);

        // Set data to the views
        holder.tv_name.setText(item.getName());
        holder.iv_icon.setImageResource(item.getImageResId());
        holder.tv_keyBenefit.setText(item.getKeyBenefit());
        holder.tv_Calories.setText(item.getCalories()+"");
        holder.tv_Carbs.setText(item.getCarbs()+"");
        holder.tv_fiber.setText(item.getFiber()+"");
        return convertView;
    }

    // ViewHolder class to optimize performance
    static class ViewHolder {
        ImageView iv_icon;
        TextView tv_name;
        TextView tv_Calories;
        TextView tv_Carbs;
        TextView tv_fiber;
        TextView tv_keyBenefit;
        public ViewHolder(View convertView)
        {
            iv_icon = convertView.findViewById(R.id.itemImage);
            tv_name = convertView.findViewById(R.id.itemText);
            tv_fiber = convertView.findViewById(R.id.tv_fiber);
            tv_Calories = convertView.findViewById(R.id.tv_Calories);
            tv_Carbs = convertView.findViewById(R.id.tv_Carbs);
            tv_keyBenefit = convertView.findViewById(R.id.tv_keyBenefit);
        }
    }
}