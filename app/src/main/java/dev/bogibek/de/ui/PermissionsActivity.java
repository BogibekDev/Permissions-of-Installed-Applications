package dev.bogibek.de.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dev.bogibek.de.R;
import dev.bogibek.de.adapter.PermissionAdapter;
import dev.bogibek.de.model.PermissionModel;

public class PermissionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);
        initViews();
    }

    private void initViews() {

        String appName = getIntent().getStringExtra("appName");
        ArrayList<PermissionModel> permissionModels = getIntent().getParcelableArrayListExtra("permissions");

        RecyclerView rvPermissions = findViewById(R.id.rvPermissions);
        TextView tvAppName = findViewById(R.id.tvAppName);
        tvAppName.setText(appName);
        PermissionAdapter adapter = new PermissionAdapter(permissionModels);
        rvPermissions.setAdapter(adapter);

    }
}