package dev.bogibek.de.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dev.bogibek.de.model.MyApps;
import dev.bogibek.de.model.PermissionModel;

public class AppPermissionsHelper {

    public static List<MyApps> getInstalledApps(Context context) {
        List<MyApps> installedAppsList = new ArrayList<>();
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<PackageInfo> packageInfoList = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS);

        for (PackageInfo packageInfo : packageInfoList) {
            String packageName = packageInfo.packageName;
            ArrayList<PermissionModel> permissionModels = new ArrayList<>();
            if (packageInfo.requestedPermissions != null) {
                for (String permission : packageInfo.requestedPermissions) {
                    boolean isGranted = packageManager.checkPermission(permission, packageName)
                            == PackageManager.PERMISSION_GRANTED;
                    permissionModels.add(new PermissionModel(permission, isGranted));
                }
            }
            if (!permissionModels.isEmpty()) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 0);
                    String appName = packageManager.getApplicationLabel(applicationInfo).toString();
                    Drawable appIcon = packageManager.getApplicationIcon(applicationInfo);
                    Log.d("Icon ", appName +" : "+ appIcon);
                    installedAppsList.add(new MyApps(appName, appIcon, permissionModels));
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return installedAppsList;
    }
}


