package project.dao;

import project.Manager.CustomerManager;
import project.Manager.EmployeeManager;
import project.Manager.ProductManager;
import project.jdbcutil.JDBCUtil;
import project.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BillManagerDAO {
    //
    public static String productToString(Order order){
        String s= new String();
        for (SoldProduct e : order.getList())
            s=s+e.getProduct().getId()+",";
        return s;
    }
    public static String countToString(Order order){
        String s=new String();
        for (SoldProduct e : order.getList())
            s=s+e.getCount()+",";
        return s;
    }
    public static String priceToString(Order order){
        String s=new String();
        for (SoldProduct e : order.getList())
            s=s+e.getPrice()+",";
        return s;
    }
    public static Order getOrder(String productList,String countList,String priceList){
        Order order= new Order();
        int beginIndexProduct=0,endIndexCount=0;
        int beginIndexCount=0,endIndexProduct=0;
        int beginIndexPrice=0,endIndexPrice=0;
        while (1==1){
            int p=productList.indexOf(',',beginIndexProduct);
            int c=countList.indexOf(',',beginIndexCount);
            int r=countList.indexOf(',',beginIndexPrice);
            if (p==-1) break;
            endIndexProduct=p;
            endIndexCount=c;
            endIndexPrice=r;
            String s1=productList.substring(beginIndexProduct,endIndexCount);
            Product product= ProductManager.get(s1);
            String s2=countList.substring(beginIndexCount,endIndexCount);
            int count=Integer.parseInt(s2);
            String s3=countList.substring(beginIndexPrice,endIndexPrice);
            int price=Integer.parseInt(s3);
            order.add(product,count,price);
            beginIndexProduct=endIndexProduct+1;
            beginIndexCount=endIndexCount+1;
            beginIndexPrice=endIndexPrice+1;
        }
        return order;
    }
    public static int insert(Bill bill) {
        int ans=0;
        try{
            Connection con= JDBCUtil.getConnection();
            String sql="INSERT INTO bill(id,date,employeeID,customerID,productList,countList,priceList,totalPayout)"
                    +" VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1,bill.getId());
            st.setDate(2,bill.getDate());
            st.setString(3,bill.getEmployee().getId());
            st.setString(4,bill.getCustomer().getId());
            st.setString(5,productToString(bill.getOrder()));
            st.setString(6,countToString(bill.getOrder()));
            st.setString(7,priceToString(bill.getOrder()));
            st.setInt(8,bill.getTotalPayout());
            ans=st.executeUpdate();
            System.out.println("Bạn đã thực thi: "+sql);
            System.out.println("Có "+ans+" dòng bị thay đổi");
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return ans;
    }
    public static ArrayList<Bill> importAll(){
        ArrayList<Bill> ans=new ArrayList<>();
        try{
            Connection con=JDBCUtil.getConnection();
            String sql="SELECT * FROM bill order by date asc";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Bill bill=new Bill();
                bill.setId(rs.getString("id"));
                bill.setDate(rs.getDate("date"));
                bill.setEmployee(EmployeeManager.get(rs.getString("employeeID")));
                bill.setCustomer(CustomerManager.get(rs.getString("customerID")));
                Order order= new Order();
                String s1= rs.getString("productList");
                String s2=rs.getString("countList");
                String s3=rs.getString("priceList");
                bill.setOrder(getOrder(s1,s2,s3));
                bill.setTotalPayout(rs.getInt("totalPayout"));
                ans.add(bill);

            }
            JDBCUtil.closeConnection(con);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return ans;
    }

}
