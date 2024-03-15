package com.example.customer_support_app.Model;

public class ExcalationMatrixItemModel {
    public int userIcon;
    public String name, role, level;

    public ExcalationMatrixItemModel(int userIcon, String name, String role, String level) {
        this.userIcon = userIcon;
        this.name = name;
        this.role = role;
        this.level = level;
    }
}
