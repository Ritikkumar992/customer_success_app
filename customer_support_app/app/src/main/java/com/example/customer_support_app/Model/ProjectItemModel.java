package com.example.customer_support_app.Model;

public class ProjectItemModel {
    public String  projectName,projectStatus,startDate,projectManager;
    public int  userIcon, rightArrow;

    public ProjectItemModel(String projectName, String projectStatus, String startDate, String projectManager, int userIcon, int rightArrow) {
        this.projectName = projectName;
        this.projectStatus = projectStatus;
        this.startDate = startDate;
        this.projectManager = projectManager;
        this.userIcon = userIcon;
        this.rightArrow = rightArrow;
    }
}
