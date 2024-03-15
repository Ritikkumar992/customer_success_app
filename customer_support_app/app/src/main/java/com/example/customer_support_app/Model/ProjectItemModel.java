package com.example.customer_support_app.Model;

import android.graphics.drawable.Drawable;

public class ProjectItemModel {
    public String  projectName,projectStatus,startDate,projectManager;
    public int  userIcon, rightArrow,backgroundColor;

    public ProjectItemModel(String projectName, String projectStatus, int backgroundColor, String startDate, String projectManager, int userIcon, int rightArrow) {
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.backgroundColor = backgroundColor;
        this.startDate = startDate;
        this.projectManager = projectManager;
        this.userIcon = userIcon;
        this.rightArrow = rightArrow;
    }
}
