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
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class ProjectItemAdapter extends FirebaseRecyclerAdapter<ProjectItemModel, ProjectItemAdapter.ViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ProjectItemAdapter(@NonNull FirebaseRecyclerOptions<ProjectItemModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, final int position, @NonNull ProjectItemModel model) {
        holder.ProjectName.setText(model.getProjectName());
        holder.ProjectStatus.setText(model.getProjectStatus());
        holder.ProjectStatus.setBackgroundColor(model.getProjectStatusColor());
        holder.ProjectStartDate.setText(model.getProjectStartDate());
        holder.projectManagerImg.setImageResource(model.getProjectMangerImg());
        holder.ProjectManagerName.setText(model.getProjectManagerName());

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_data_row,parent,false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        TextView ProjectName, ProjectStatus,ProjectStartDate,ProjectManagerName;
        ImageView projectManagerImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ProjectName = itemView.findViewById(R.id.projectName);
            ProjectStatus = itemView.findViewById(R.id.projectStatus);
            ProjectStartDate = itemView.findViewById(R.id.projectStartDate);
            ProjectManagerName = itemView.findViewById(R.id.projectManager);
            projectManagerImg = itemView.findViewById(R.id.userIcon);

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
