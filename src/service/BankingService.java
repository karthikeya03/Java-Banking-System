package service;

import dao.CustomerDAO;

public class BankingService {

    public static boolean transfer(int from,int to,double amount){

        if(CustomerDAO.withdraw(from,amount)){

            return CustomerDAO.deposit(to,amount);
        }

        return false;
    }
}