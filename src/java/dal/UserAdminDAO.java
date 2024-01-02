/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.UserAdmin;

/**
 *
 * @author Fattt
 */
public class UserAdminDAO extends DBContext{
    //    Get All Customer
    public List<UserAdmin> getAllCustomer() {
        List<UserAdmin> list = new ArrayList<>();
        String sql = "select * from `user`";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String image = rs.getString("image");
                int role = rs.getInt("role");
                UserAdmin x = new UserAdmin(id, username, password, fullname, email, address, phone, image, role);
                list.add(x);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    //    Add user
    public void addUser(UserAdmin c){
        String sql = "insert into `user` values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getId());
            st.setString(2, c.getUsername());
            st.setString(3, c.getPassword());
            st.setString(4, c.getFullname());
            st.setString(5, c.getEmail());
            st.setString(6, c.getAddress());
            st.setString(7, c.getPhone());
            st.setInt(8, c.getRole());
            st.setString(9, c.getImage());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //    Find user by id
    public UserAdmin getCustomerById(String userID){
        String sql = "select * from `user` where ID = ?";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String id = rs.getString("ID");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String image = rs.getString("image");
                int role = rs.getInt("role");
                UserAdmin x = new UserAdmin(id, username, password, fullname, email, address, phone, image, role);
                return x;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    //    Delete a custormer
    public void deleteUser(String userID){
        String sql = "DELETE FROM `user` WHERE ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, userID);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //    Update category
    public void updateCustomer(UserAdmin c){
        String sql = "UPDATE `user` SET "
                            + "username = ?,"
                            + "password = ?,"
                            + "fullname = ?,"
                            + "email = ?,"
                            + "address = ?,"
                            + "phone = ?,"
                            + "role = ? "
                            + "WHERE ID = ?;";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getUsername());
            st.setString(2, c.getPassword());
            st.setString(3, c.getFullname());
            st.setString(4, c.getAddress());
            st.setString(5, c.getEmail());
            st.setString(6, c.getPhone());
            st.setInt(7, c.getRole());
            st.setString(8, c.getId());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
