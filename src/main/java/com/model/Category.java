package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int categoryId;
    private String categoryName;
    private String description;
    private Boolean active;

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Category(int categoryId, String categoryName, String description, Boolean active) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.active = active;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                '}';
    }
    public static List<Category> finAllCategory(Connection con) throws SQLException {
        String sql = "select * from Category";
        List<Category> list = new ArrayList<Category>();
        PreparedStatement state = con.prepareStatement(sql);
        ResultSet result = state.executeQuery();
        while(result.next()){
            Category c = new Category();
            c.setCategoryId(result.getInt("categoryId"));
            c.setCategoryName(result.getString("categoryName"));
            c.setDescription(result.getString("Description"));
            list.add(c);
        }
        return list;
    }
    public static String findByCategoryId(Connection con,int categoryId) throws SQLException {
        String categoryName = null;
        String query = "select CategoryName from Category where categoryId=?";
        PreparedStatement state = con.prepareStatement(query);
        state.setInt(1,categoryId);
        ResultSet result = state.executeQuery();
        while(result.next()){
            categoryName =result.getString("categoryName");
        }
        return categoryName;
    }
}
