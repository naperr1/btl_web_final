/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.OrderAdmin;
import model.OrderDetailsAdmin;
import model.OrderItemAdmin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mr.Thai
 */
public class OrdersDAO extends DBContext{
    public List<OrderAdmin> getAllOrders(){
        List<OrderAdmin> list = new ArrayList<>();
        String sql = "select web.order.ID, username, orderDate, total, status\n" +
                        "from web.order, user\n" +
                            "where user.ID = userID";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();           
            while (rs.next()) {
                String status = "Processing";
                if(rs.getInt("status") == 2)
                    status = "Shipping";
                else if(rs.getInt("status") == 3)
                    status = "Completed";
                OrderAdmin order = new OrderAdmin(
                rs.getString("ID"),
                rs.getString("username"),             
                rs.getDouble("total"),
                status,
                rs.getString("orderDate")           
            );
            list.add(order);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
      public OrderDetailsAdmin getOrderDetailsById(String orderID) {   
          String sql = "select web.order.ID, username, user.fullname, user.phone, orderDate, total, status\n" +
                        "from web.order, user\n" +
                        "where web.order.ID = ?\n" +
                        "and user.ID = userID";
        try {      
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, orderID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String status = "Processing";
                if(rs.getInt("status") == 2)
                    status = "Shipping";
                else if(rs.getInt("status") == 3)
                    status = "Completed";
                OrderDetailsAdmin order = new OrderDetailsAdmin(
                    rs.getString("ID"), 
                    rs.getString("username"), 
                    rs.getString("fullname"), 
                    rs.getString("phone"), 
                    rs.getString("orderDate"), 
                    status,
                    rs.getDouble("total"));
                return order;  
            }
                 
        } catch(Exception e) {   
            System.out.println(e);
        }
        return null;
      }
      public OrderAdmin getOrderById(String orderID){
        String sql = "select web.order.ID, username, orderDate, total, status\n" +
                        "from web.order, user\n" +
                            "where user.ID = userID and web.order.ID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, orderID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String status = "Processing";
                if(rs.getInt("status") == 2)
                    status = "Shipping";
                else if(rs.getInt("status") == 3)
                    status = "Completed";
                OrderAdmin od = new OrderAdmin(
                rs.getString("ID"),
                rs.getString("username"),
                rs.getDouble("total"),
                status,
                rs.getString("orderDate")
            );
               return od;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
     public void updateOrder(OrderAdmin order){
       String sql = "UPDATE web.order SET \n"
            + "total = ?,\n"
            + "orderDate = ?,\n"
            + "status = ?\n"
            + "WHERE ID = ?;"; 
       
        try {
           PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, order.getTotalMoney());
            st.setString(2, order.getOrderDate());
            
            int status = 1;
            if("Shipping".equals(order.getStatus()))
                status = 2;
            else if("Completed".equals(order.getStatus()))
                status = 3;
            st.setInt(3, status);
            st.setString(4, order.getOrderID());
            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
     public List<OrderItemAdmin> getOrderItemByOrderId(String orderID) {
         List<OrderItemAdmin> list = new ArrayList<OrderItemAdmin>();
         String sql = "SELECT image, name, sellPrice, quantity\n" +
                        "from orderitem, item\n" +
                        "where orderID = ?" +
                            "and itemID = item.ID";
         try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, orderID);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                double total = rs.getDouble("sellPrice") * rs.getInt("quantity");
                 DecimalFormat df = new DecimalFormat("#.##");
                 String formattedNumber = df.format(total);
                 double totalNumber = Double.parseDouble(formattedNumber);
                OrderItemAdmin odi = new OrderItemAdmin(
                        rs.getString("image"), 
                        rs.getString("name"), 
                        rs.getDouble("sellPrice"),                      
                        rs.getInt("quantity"),
                        totalNumber);
                list.add(odi);
            }
         } catch(Exception e) {
            System.out.println(e); 
         }
         return list;
     }
}
