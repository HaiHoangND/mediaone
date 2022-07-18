package project.dao;

import project.Manager.*;
import project.model.*;

import java.util.ArrayList;

public class tesst {
    public static void main(String[] args) {
        ProductManager.productList=ProductManagerDAO.importAll();
        EmployeeManager.employeeList=EmployeeManagerDAO.importAll();

        CustomerManager.customerList= CustomerManagerDAO.importALl();
        BillManager.billList=BillManagerDAO.importAll();
        Bill bill1= BillManager.billList.get(0);
        System.out.println(BillManager.billList);
        ArrayList<SoldProduct> order1=bill1.getOrder().getList();
        System.out.println(order1.get(0));
        System.out.println(order1.get(1));
        System.out.println(order1.get(2));
    }
}
