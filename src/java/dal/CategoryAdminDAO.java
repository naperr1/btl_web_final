/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.CategoryAdmin;

/**
 *
 * @author Fattt
 */
public class CategoryAdminDAO extends DBContext{
    //    Get All Category
    public List<CategoryAdmin> getAllCategory() {
        List<CategoryAdmin> list = new ArrayList<>();
        String sql = "select * from category";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CategoryAdmin category = new CategoryAdmin(
                        rs.getString("ID"),
                        rs.getString("name")
                );
                list.add(category);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
//    public static void main(String[] args) {
//        CategoryDAO hsd = new CategoryDAO();
//        List<Category> list = hsd.getAllCategory();
//        System.out.println(list.get(0).getName());
//    }
    
    //    Add category
    public void addCategory(CategoryAdmin c){
        String sql = "insert into category values(?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getId());
            st.setString(2, c.getName());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //    Find category by id
    public CategoryAdmin getCategoryById(String categoryID){
        String sql = "select * from category where ID=?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, categoryID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                CategoryAdmin c = new CategoryAdmin(
                        rs.getString("ID"),
                        rs.getString("name")
                );
                return c;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
        
//    Delete a category
    public void deleteCategory(String categoryID){
        String sql = "DELETE FROM category WHERE ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, categoryID);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    //    Update category
    public void updateCategory(CategoryAdmin c){
        String sql = "UPDATE category SET "
                + "name = ?"
                + "WHERE ID = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getName());
            st.setString(2, c.getId());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
