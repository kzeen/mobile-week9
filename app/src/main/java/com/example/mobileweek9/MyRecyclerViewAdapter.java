package com.example.mobileweek9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter {
    private Context context;
    private List<Fruit> itemList;

    // Constructor
    public MyRecyclerViewAdapter(Context context, List<Fruit> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder_, int position) {
        Fruit item = itemList.get(position);
        MyViewHolder holder = (MyViewHolder) holder_;

        holder.tv_name.setText(item.getName());
        holder.iv_icon.setImageResource(item.getImageResId());
        holder.tv_keyBenefit.setText(item.getKeyBenefit());
        holder.tv_Calories.setText(item.getCalories()+"");
        holder.tv_Carbs.setText(item.getCarbs()+"");
        holder.tv_fiber.setText(item.getFiber()+"");
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_icon;
        TextView tv_name;
        TextView tv_Calories;
        TextView tv_Carbs;
        TextView tv_fiber;
        TextView tv_keyBenefit;
        public MyViewHolder(View convertView)
        {
            super(convertView);
            iv_icon = convertView.findViewById(R.id.itemImage);
            tv_name = convertView.findViewById(R.id.itemText);
            tv_fiber = convertView.findViewById(R.id.tv_fiber);
            tv_Calories = convertView.findViewById(R.id.tv_Calories);
            tv_Carbs = convertView.findViewById(R.id.tv_Carbs);
            tv_keyBenefit = convertView.findViewById(R.id.tv_keyBenefit);
        }
    }
}
