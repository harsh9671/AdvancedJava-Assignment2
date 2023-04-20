package com.example.UsedCarDealer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.ViewHolder> {


    private static ArrayList<Vehicle> mVehicleList = null;
    private OnItemClickListener mListener;
    Context context;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView vehicle_make,vehicle_model,vehicle_condition,vehicle_enginecylinder,vehicle_year,vehicle_doors,vehicle_price,vehicle_color,vehicle_datesold;
        public ImageView vehicle_image;
        public ViewHolder(View itemView) {
            super(itemView);
            vehicle_make = (TextView) itemView.findViewById(R.id.vehicle_make);
            vehicle_model = (TextView) itemView.findViewById(R.id.vehicle_model);
            vehicle_condition = (TextView) itemView.findViewById(R.id.vehicle_condition);
            vehicle_enginecylinder = (TextView) itemView.findViewById(R.id.vehicle_enginecylinder);
            vehicle_doors = (TextView) itemView.findViewById(R.id.vehicle_doors);
            vehicle_year =(TextView)  itemView.findViewById(R.id.vehicle_year);
            vehicle_color = (TextView) itemView.findViewById(R.id.vehicle_color);
            vehicle_price =(TextView)  itemView.findViewById(R.id.vehicle_price);
            vehicle_datesold =(TextView)  itemView.findViewById(R.id.vehicle_datesold);
            vehicle_image =(ImageView)  itemView.findViewById(R.id.vehicle_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    public VehicleAdapter(ArrayList<Vehicle> vehicleList) {
        mVehicleList = vehicleList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.vehice_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vehicle currentVehicle = mVehicleList.get(position);

        holder.vehicle_image.setImageResource(currentVehicle.getImage());
        holder.vehicle_make.setText("Make: "+ currentVehicle.getMake());
        holder.vehicle_model.setText("Model: "+ currentVehicle.getModel());
        holder.vehicle_condition.setText("Condition: "+ currentVehicle.getCondition());
        holder.vehicle_enginecylinder.setText("Engine Cylinder: "+ currentVehicle.getEngineCylinders());
        holder.vehicle_year.setText("Year: "+ currentVehicle.getYear());
        holder.vehicle_doors.setText("Doors: "+ currentVehicle.getNumberOfDoors());
        holder.vehicle_price.setText("Price: $"+ currentVehicle.getPrice());
        holder.vehicle_color.setText("Color: "+ currentVehicle.getColor());
        holder.vehicle_datesold.setText("Sold date: "+ currentVehicle.getSoldDate());


    }

    @Override
    public int getItemCount() {
        return  mVehicleList.size();
    }

    public static ArrayList<Vehicle> getVehicleList() {
        return mVehicleList;
    }

}
