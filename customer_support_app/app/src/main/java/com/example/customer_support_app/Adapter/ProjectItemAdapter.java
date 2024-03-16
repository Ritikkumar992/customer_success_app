package com.example.customer_support_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customer_support_app.Model.ProjectItemModel;
import com.example.customer_support_app.R;

import java.util.ArrayList;

public class ProjectItemAdapter extends RecyclerView.Adapter<ProjectItemAdapter.ViewHolder> {

    Context context;
    ArrayList<ProjectItemModel> arrayProjectItem;
    public ProjectItemAdapter(Context context, ArrayList<ProjectItemModel> arrayContact){
        this.context = context;
        this.arrayProjectItem = arrayContact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.project_data_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.ProjectName.setText(arrayProjectItem.get(position).projectName);
        holder.ProjectStatus.setText(arrayProjectItem.get(position).projectStatus);
        holder.ProjectStatus.setBackgroundColor(arrayProjectItem.get(position).backgroundColor);
        holder.StartDate.setText(arrayProjectItem.get(position).startDate);
        holder.ProjectManager.setText(arrayProjectItem.get(position).projectManager);
        holder.userIcon.setImageResource(arrayProjectItem.get(position).userIcon);
        holder.rightArrow.setImageResource(arrayProjectItem.get(position).rightArrow);
    }

    @Override
    public int getItemCount() {
        return arrayProjectItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView ProjectName, ProjectStatus,StartDate,ProjectManager;
        ImageView userIcon,rightArrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ProjectName = itemView.findViewById(R.id.projectName);
            ProjectStatus = itemView.findViewById(R.id.projectStatus);
            StartDate = itemView.findViewById(R.id.projectStartDate);
            ProjectManager = itemView.findViewById(R.id.projectManager);
            userIcon = itemView.findViewById(R.id.userIcon);
            rightArrow = itemView.findViewById(R.id.rightArrowIcon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}