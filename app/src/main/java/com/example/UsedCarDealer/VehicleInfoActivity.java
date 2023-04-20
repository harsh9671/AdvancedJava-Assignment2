package com.example.UsedCarDealer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VehicleInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vehicle_specific);

        // Get the vehicle object passed from MainActivity
        Vehicle vehicle = getIntent().getParcelableExtra("vehicle");

        if (vehicle != null) {
            //Set the views in the layout to display the vehicle details
            ImageView vehicle_image = findViewById(R.id.vehicle_image);
            vehicle_image.setImageResource(vehicle.getImage());

            TextView vehicle_make = findViewById(R.id.vehicle_make);
            vehicle_make.setText("Make: "+vehicle.getMake());

            TextView vehicle_model = findViewById(R.id.vehicle_model);
            vehicle_model.setText("Model: "+vehicle.getModel());

            TextView vehicle_condition = findViewById(R.id.vehicle_condition);
            vehicle_condition.setText("Condition: "+vehicle.getCondition());

            TextView vehicle_enginecylinder = findViewById(R.id.vehicle_enginecylinder);
            vehicle_enginecylinder.setText("Engine Cylinder: "+vehicle.getEngineCylinders());

            TextView vehicle_year = findViewById(R.id.vehicle_year);
            vehicle_year.setText("Year: "+vehicle.getYear());

            TextView vehicle_doors = findViewById(R.id.vehicle_doors);
            vehicle_doors.setText("Doors: "+ vehicle.getNumberOfDoors());

            TextView vehicle_price = findViewById(R.id.vehicle_price);
            vehicle_price.setText("Price: $" +vehicle.getPrice());


            TextView vehicle_color = findViewById(R.id.vehicle_color);
            vehicle_color.setText("Color: "+ vehicle.getColor());



            TextView vehicle_datesold = findViewById(R.id.vehicle_datesold);
            vehicle_datesold.setText("Sold date: "+ vehicle.getSoldDate());
        } else {
            Log.e("VehicleInfoActivity", "Vehicle object is null");
        }
//
    }
}
