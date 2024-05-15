package dev.bogibek.de.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.bogibek.de.utils.AppPermissionsHelper;
import dev.bogibek.de.model.MyApps;
import dev.bogibek.de.R;
import dev.bogibek.de.adapter.AppsAdapter;
import dev.bogibek.de.utils.ClickListener;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> appList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

        List<MyApps> apps = AppPermissionsHelper.getInstalledApps(this);

        ArrayList<MyApps> myApps = new ArrayList<>(apps);
        RecyclerView rvApps = findViewById(R.id.rvApps);
        AppsAdapter adapter = new AppsAdapter(apps, new ClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, PermissionsActivity.class);
                intent.putParcelableArrayListExtra("permissions", myApps.get(position).getPermissionModels());
                intent.putExtra("appName",myApps.get(position).getAppName());
                startActivity(intent);
            }
        });
        rvApps.setAdapter(adapter);

    }


}