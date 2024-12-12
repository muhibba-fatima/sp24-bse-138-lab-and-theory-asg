package com.example.demo31;

import java.io.Serializable;
import java.util.ArrayList;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class User implements Serializable {

        private String username;
        private String password;
        private double balance;
        private ArrayList<String> transactionHistory;

        public User(String username, String password, double balance) {
            this.username = username;
            this.password = password;
            this.balance = balance;
            this.transactionHistory = new ArrayList<>();
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public ArrayList<String> getTransactionHistory() {
            return transactionHistory;
        }

        public void addTransaction(String transaction) {
            transactionHistory.add(transaction);
        }

        public void setPassword(String newPassword) {
            this.password = newPassword;
        }
    }

