package com.example.UsedCarDealer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements VehicleAdapter.OnItemClickListener{

    private VehicleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle("Audi", "R8", "Good", "v8", 2018, 2, 120000, "white", R.drawable.audiga6fc41f1d_1280, "12 feb 2023"));
        vehicleList.add(new Vehicle("BMW", "M4", "Excellent", "v8", 2021, 2, 150000, "black", R.drawable.bmwm4g40c696129_1280, "not sold"));
        vehicleList.add(new Vehicle("Mercedes-Benz", "S-Class", "Excellent", "v8", 2019, 4, 130000, "red", R.drawable.sclass, "15 May 2022"));
        vehicleList.add(new Vehicle("Porsche", "Porsche 418", "Like New", "v6", 2020, 2, 180000, "silver", R.drawable.porscheg217ee228a_1280, "01 Jul 2023"));
        vehicleList.add(new Vehicle("Tesla", "Model S", "Good", "electric", 2017, 4, 70000, "blue", R.drawable.teslagdb8ecaef0_1920, "not sold"));
        vehicleList.add(new Vehicle("Ford", "Mustang GT", "Fair", "v8", 2015, 2, 40000, "yellow", R.drawable.fordg2296461b4_1280, "17 Nov 2022"));
        vehicleList.add(new Vehicle("Chevrolet", "Camaro", "Excellent", "v8", 2022, 1, 160000, "orange", R.drawable.camarog30b9542ba_1280, "not sold"));
        vehicleList.add(new Vehicle("Lamborghini", "Aventador", "Like New", "v12", 2018, 2, 300000, "green", R.drawable.lamborghiniaventadorgda8915f8f_1280, "18 Sep 2022"));
        vehicleList.add(new Vehicle("Ferrari", "488 GTB", "Excellent", "v8", 2019, 2, 250000, "red", R.drawable.ferrari9d76442e4_1280, "12 Dec 2022"));
        vehicleList.add(new Vehicle("Nissan", "GTR", "Excellent", "v8", 2020, 2, 220000, "gray", R.drawable.nissangtr, "not sold"));

      VehicleAdapter mAdapter = new VehicleAdapter(vehicleList);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(this);
    }

   @Override
    public void onItemClick(int position) {

       Vehicle clickedVehicle = VehicleAdapter.getVehicleList().get(position);
        System.out.println("all done");

        Intent intent = new Intent(MainActivity.this, VehicleInfoActivity.class);
       intent.putExtra("vehicle", clickedVehicle);

        intent.putExtra("make", clickedVehicle.getMake());
        intent.putExtra("model", clickedVehicle.getModel());
        intent.putExtra("condition", clickedVehicle.getCondition());

        intent.putExtra("engineCylinder", clickedVehicle.getEngineCylinders());
        intent.putExtra("year", clickedVehicle.getYear());
        intent.putExtra("numberOfDoors", clickedVehicle.getNumberOfDoors());
        intent.putExtra("price", clickedVehicle.getPrice());
        intent.putExtra("color", clickedVehicle.getColor());
        intent.putExtra("imageView", clickedVehicle.getImage());
        intent.putExtra("soldDate", clickedVehicle.getSoldDate());

        startActivity(intent);


    }

}
