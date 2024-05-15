package dev.bogibek.de.model;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class MyApps {
    String appName;
    Drawable appIcon;
    ArrayList<PermissionModel> permissionModels;


    public MyApps(String appName, Drawable appIcon, ArrayList<PermissionModel> permissionModels) {
        this.appName = appName;
        this.appIcon = appIcon;
        this.permissionModels = permissionModels;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public ArrayList<? extends Parcelable> getPermissionModels() {
        return permissionModels;
    }

    public void setPermissionModels(ArrayList<PermissionModel> permissionModels) {
        this.permissionModels = permissionModels;
    }

    @Override
    public String toString() {
        return "MyApps{" +
                "appName='" + appName + '\'' +
                ", appIcon=" + appIcon +
                ", permissionModels=" + permissionModels +
                '}';
    }
}


