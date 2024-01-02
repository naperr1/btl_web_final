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
import model.ItemAdmin;

/**
 *
 * @author Fattt
 */
public class ItemAdminDAO extends DBContext {
//    Get all item

    public List<ItemAdmin> getAllItem() {
        List<ItemAdmin> list = new ArrayList<>();
        String sql = "select * from item";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            CategoryAdminDAO cdb = new CategoryAdminDAO();
            while (rs.next()) {
                ItemAdmin x = new ItemAdmin();
                x.setId(rs.getString("ID"));
                x.setName(rs.getString("name"));
                x.setStock(rs.getInt("stock"));
                x.setCost(rs.getDouble("costPrice"));
                x.setSell(rs.getDouble("sellPrice"));
                x.setRating(rs.getDouble("rating"));
                x.setImage(rs.getString("image"));
                x.setDescription(rs.getString("description"));
                CategoryAdmin c = cdb.getCategoryById(rs.getString("categoryID"));
                x.setCategory(c);
                list.add(x);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

//    public static void main(String[] args) {
//        ItemDAO hsd = new ItemDAO();
//        List<Item> list = hsd.getAllItem();
//        System.out.println(list.get(0).getName());
//    }
//    Add item
    public void addItem(ItemAdmin item) {
        String sql = "insert into item values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, item.getId());
            st.setString(2, item.getName());
            st.setInt(3, item.getStock());
            st.setDouble(4, item.getCost());
            st.setDouble(5, item.getSell());
            st.setString(6, item.getCategory().getId());
            st.setString(7, item.getImage());
            st.setDouble(8, item.getRating());
            st.setString(9, item.getDescription());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    Get item by id
    public ItemAdmin getItemById(String itemID) {
        String sql = "select * from item where ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, itemID);
            ResultSet rs = st.executeQuery();
            CategoryAdminDAO cdb = new CategoryAdminDAO();
            if (rs.next()) {
                ItemAdmin x = new ItemAdmin();
                x.setId(rs.getString("ID"));
                x.setName(rs.getString("name"));
                x.setStock(rs.getInt("stock"));
                x.setCost(rs.getDouble("costPrice"));
                x.setSell(rs.getDouble("sellPrice"));
                x.setRating(rs.getDouble("rating"));
                x.setImage(rs.getString("image"));
                x.setDescription(rs.getString("description"));
                CategoryAdmin c = cdb.getCategoryById(rs.getString("categoryID"));
                x.setCategory(c);
                return x;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
//    public static void main(String[] args) {
//        ItemDAO hsd = new ItemDAO();
//        System.out.println();
//        hsd.deleteItem("it01");
//    }

//    Delete item
    public void deleteItem(String itemID) {
        String sql = "DELETE FROM item WHERE ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, itemID);
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    Update item
    public void updateItem(ItemAdmin item) {
        String sql = "UPDATE item SET "
                + "name = ?,"
                + "stock = ?,"
                + "costPrice = ?,"
                + "sellPrice = ?,"
                + "image = ?,"
                + "description = ?,"
                + "categoryID = ?"
                + "WHERE ID = ?;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, item.getName());
            st.setInt(2, item.getStock());
            st.setDouble(3, item.getCost());
            st.setDouble(4, item.getSell());
            st.setString(5, item.getImage());
            st.setString(6, item.getDescription());
            st.setString(7, item.getCategory().getId());
            st.setString(8, item.getId());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
