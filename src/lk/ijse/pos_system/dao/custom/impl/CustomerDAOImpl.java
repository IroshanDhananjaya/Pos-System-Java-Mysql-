package lk.ijse.pos_system.dao.custom.impl;

import lk.ijse.pos_system.dao.CrudDAO;
import lk.ijse.pos_system.dao.CrudUtil;
import lk.ijse.pos_system.dao.custom.CustomerDAO;
import lk.ijse.pos_system.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO Customer VALUES (?,?,?,?,?,?,?)",customer.getCustID(),
                customer.getCustTitle(),customer.getCustName(),customer.getCustAddress(),customer.getCity(),
                customer.getProvince(),customer.getPostCode());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM Customer WHERE CustID=?",s);
    }

    @Override
    public boolean update(Customer customer) throws SQLException, ClassNotFoundException {
      return CrudUtil.executeUpdate("UPDATE Customer SET  CustTitle=?,CustName=?,CustAddress=?,City=?,Povince=?,PostCode=?WHERE CustID=?", customer.getCustTitle(),customer.getCustName(),customer.getCustAddress(),customer.getCity(),
               customer.getProvince(),customer.getPostCode(),customer.getCustID());
    }

    @Override
    public Customer search(String s) throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM Customer WHERE CustID=?",s);
        rst.next();
        return new Customer( rst.getString(1),
                rst.getString(2),
                rst.getString(3),
                rst.getString(4),
                rst.getString(5),
                rst.getString(6),
                rst.getString(7));
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM Customer");
        ArrayList<Customer> allCustomers=new ArrayList<>();
        while (rst.next()){
            allCustomers.add(new Customer( rst.getString(1), rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)));
        }
        return allCustomers;
    }

    @Override
    public List<String> getCustomerIds() throws SQLException, ClassNotFoundException {
        List <String> ids=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("SELECT * FROM Customer");
        while (rst.next()){
            ids.add(rst.getString(1));

        }
        return ids;
    }
}
