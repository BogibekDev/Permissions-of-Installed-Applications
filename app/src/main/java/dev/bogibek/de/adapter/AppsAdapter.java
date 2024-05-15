package dev.bogibek.de.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.bogibek.de.model.MyApps;
import dev.bogibek.de.R;
import dev.bogibek.de.utils.ClickListener;

public class AppsAdapter extends RecyclerView.Adapter<AppsViewHolder> {

    List<MyApps> apps;
    ClickListener listener;

    public AppsAdapter(List<MyApps> apps, ClickListener listener) {
        this.apps = apps;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AppsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AppsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_apps, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AppsViewHolder holder, int position) {
        MyApps app = apps.get(position);
        holder.appImage.setImageDrawable(app.getAppIcon());
        holder.appName.setText(app.getAppName());

        holder.item.setOnClickListener(v -> listener.onItemClick(position));


    }

    @Override
    public int getItemCount() {
        return apps.size();
    }


}

class AppsViewHolder extends RecyclerView.ViewHolder {

    ImageView appImage;
    TextView appName;
    LinearLayout item;

    public AppsViewHolder(@NonNull View itemView) {
        super(itemView);
        appImage = itemView.findViewById(R.id.ivApp);
        appName = itemView.findViewById(R.id.tvAppName);
        item = itemView.findViewById(R.id.appItem);
    }
}

