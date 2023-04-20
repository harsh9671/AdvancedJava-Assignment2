package com.example.UsedCarDealer;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Vehicle implements Parcelable {

    private String make;
    private String model;
    private String condition;
    private String engineCylinders;
    private int year;
    private int numberOfDoors;
    private double price;
    private String color;
    private Integer image;
    private String soldDate;



    public Vehicle(String make, String model, String condition, String engineCylinders, int year, int numberOfDoors, double price, String color, int image, String soldDate) {
        this.make = make;
        this.model = model;
        this.condition = condition;
        this.engineCylinders = engineCylinders;
        this.year = year;
        this.numberOfDoors = numberOfDoors;
        this.price = price;
        this.color = color;
        this.image = image;
        this.soldDate = soldDate;
    }

    protected Vehicle(Parcel in) {
        make = in.readString();
        model = in.readString();
        condition = in.readString();
        engineCylinders = in.readString();
        year = in.readInt();
        numberOfDoors = in.readInt();
        price = in.readDouble();
        color = in.readString();
        if (in.readByte() == 0) {
            image = null;
        } else {
            image = in.readInt();
        }
        soldDate = in.readString();
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getEngineCylinders() {
        return engineCylinders;
    }

    public void setEngineCylinders(String engineCylinders) {
        this.engineCylinders = engineCylinders;
    }

    public String getYear() {
        return String.valueOf(year);
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNumberOfDoors() {
        return String.valueOf(numberOfDoors);
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getPrice() {
        return String.valueOf(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getImage() {
        return image;
    }

    public void setImageUrl(Integer image) {
        this.image = image;
    }

    public String getSoldDate() {
        return soldDate;
    }

    public void setSoldDate(String soldDate) {
        this.soldDate = soldDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(make);
        parcel.writeString(model);
        parcel.writeString(condition);
        parcel.writeString(engineCylinders);
        parcel.writeInt(year);
        parcel.writeInt(numberOfDoors);
        parcel.writeDouble(price);
        parcel.writeString(color);
        if (image == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(image);
        }
        parcel.writeString(soldDate);
    }
}
