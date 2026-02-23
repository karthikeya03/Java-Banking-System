package dao;

import util.DBConnection;
import model.Customer;

import java.sql.*;
import java.util.*;

public class CustomerDAO {

    public static boolean create(Customer c){

        try{

            Connection con=DBConnection.getConnection();

            String q="insert into customers(name,email,phone,balance) values(?,?,?,?)";

            PreparedStatement ps=con.prepareStatement(q);

            ps.setString(1,c.getName());
            ps.setString(2,c.getEmail());
            ps.setString(3,c.getPhone());
            ps.setDouble(4,c.getBalance());

            ps.executeUpdate();

            return true;
        }
        catch(Exception e){e.printStackTrace();}

        return false;
    }

    public static boolean deposit(int id,double amount){

        try{

            Connection con=DBConnection.getConnection();

            String q="update customers set balance=balance+? where id=?";

            PreparedStatement ps=con.prepareStatement(q);

            ps.setDouble(1,amount);
            ps.setInt(2,id);

            return ps.executeUpdate()>0;
        }
        catch(Exception e){e.printStackTrace();}

        return false;
    }

    public static boolean withdraw(int id,double amount){

        try{

            Connection con=DBConnection.getConnection();

            String q="update customers set balance=balance-? where id=? and balance>=?";

            PreparedStatement ps=con.prepareStatement(q);

            ps.setDouble(1,amount);
            ps.setInt(2,id);
            ps.setDouble(3,amount);

            return ps.executeUpdate()>0;
        }
        catch(Exception e){e.printStackTrace();}

        return false;
    }

    public static List<Customer> getAll(){

        List<Customer> list=new ArrayList<>();

        try{

            Connection con=DBConnection.getConnection();

            Statement st=con.createStatement();

            ResultSet rs=st.executeQuery("select * from customers");

            while(rs.next()){

                list.add(new Customer(

                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getDouble("balance")
                ));
            }
        }
        catch(Exception e){e.printStackTrace();}

        return list;
    }
}