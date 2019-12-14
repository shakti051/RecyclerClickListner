package com.example.employeerecycler;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmpAdapter extends RecyclerView.Adapter<EmpAdapter.ViewHolder> {
    private ArrayList<EmpModel> employe;
    Context activity;
    private RecyclerViewClickListener mListener;

    public EmpAdapter(ArrayList<EmpModel> employe, Context activity,EmpAdapter.RecyclerViewClickListener clickListener) {
        this.employe = employe;
        this.activity = activity;
        mListener = clickListener;
    }

    public interface RecyclerViewClickListener {

        void onClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtName,txtJobProfile,txtCompanyName,txtAddress;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtJobProfile = itemView.findViewById(R.id.txtjobProfile);
            txtCompanyName = itemView.findViewById(R.id.txtCompanyName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onClick(v,getAdapterPosition());
        }
    }
    @NonNull
    @Override
    public EmpAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpAdapter.ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(employe.get(i));
        viewHolder.txtName.setText(employe.get(i).getName());
        viewHolder.txtJobProfile.setText(employe.get(i).getJobProfile());
        viewHolder.txtCompanyName.setText(employe.get(i).getCompanyName());
        viewHolder.txtAddress.setText(employe.get(i).getAddresss());
    }


    @Override
    public int getItemCount() {
        return employe.size();
    }
}
