package dev.bogibek.de.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;


public class PermissionModel implements Parcelable {
    String name;
    boolean isGranted;

    public PermissionModel(String name, boolean isGranted) {
        this.name = name;
        this.isGranted = isGranted;
    }

    protected PermissionModel(Parcel in) {
        name = in.readString();
        isGranted = in.readByte() != 0;
    }

    public static final Creator<PermissionModel> CREATOR = new Creator<PermissionModel>() {
        @Override
        public PermissionModel createFromParcel(Parcel in) {
            return new PermissionModel(in);
        }

        @Override
        public PermissionModel[] newArray(int size) {
            return new PermissionModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGranted() {
        return isGranted;
    }

    public void setGranted(boolean granted) {
        isGranted = granted;
    }

    @Override
    public String toString() {
        return "PermissionModel{" +
                "name='" + name + '\'' +
                ", isGranted=" + isGranted +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeByte((byte) (isGranted ? 1 : 0));
    }
}
