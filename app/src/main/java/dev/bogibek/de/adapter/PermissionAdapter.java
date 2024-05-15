package dev.bogibek.de.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dev.bogibek.de.R;
import dev.bogibek.de.model.PermissionModel;

public class PermissionAdapter extends RecyclerView.Adapter<PermissionViewHolder> {
    ArrayList<PermissionModel> permissionModels;

    public PermissionAdapter(ArrayList<PermissionModel> permissionModels) {
        this.permissionModels = permissionModels;
    }

    @NonNull
    @Override
    public PermissionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PermissionViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_permission, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PermissionViewHolder holder, int position) {
        PermissionModel permission = permissionModels.get(position);
        holder.permission.setText(permission.getName());
        holder.permission.setChecked(permission.isGranted());
    }

    @Override
    public int getItemCount() {
        return permissionModels.size();
    }
}

class PermissionViewHolder extends RecyclerView.ViewHolder {

    CheckBox permission;

    public PermissionViewHolder(@NonNull View itemView) {
        super(itemView);
        permission = itemView.findViewById(R.id.permission);
    }
}
