package com.bmi.inputrecycler.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bmi.inputrecycler.Model.Details;
import com.bmi.inputrecycler.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder>{
Context context;
List<Details> detailsList;

    public DetailsAdapter(Context context, List<Details> detailsList) {
        this.context = context;
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,parent, false);
        return new DetailsViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
Details details=detailsList.get(position);
holder.imgProfile.setImageResource(details.getImageId());
holder.txtGender.setText(details.getGender());
holder.txtAge.setText(details.getAge());
holder.txtName.setText(details.getName());
    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imgProfile;
        TextView txtName,txtAge,txtGender;
        public DetailsViewHolder(@NonNull View itemView) {

            super(itemView);
            imgProfile=itemView.findViewById(R.id.imgProfile);
            txtName=itemView.findViewById(R.id.txtName);
            txtAge=itemView.findViewById(R.id.txtAge);
            txtGender=itemView.findViewById(R.id.txtGender);

        }
    }

}
