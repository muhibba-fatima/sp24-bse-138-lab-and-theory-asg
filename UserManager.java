package com.example.demo31;

import java.io.*;
import java.util.HashMap;

public class UserManager {
    private HashMap<String, User> users;
    private final String dataFilePath = "file.dat";

    public UserManager() {
        users = readUserDataFromFile();
    }

    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public void createAccount(String username, String password, double balance) {
        if (users.containsKey(username)) {
            throw new IllegalArgumentException("Username already exists.");
        }
        users.put(username, new User(username, password, balance));
        saveUserDataToFile();
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public void deleteAccount(String username) {
        users.remove(username);
        saveUserDataToFile();
    }

    private HashMap<String, User> readUserDataFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataFilePath))) {
            return (HashMap<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    public void saveUserDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataFilePath))) {
            oos.writeObject(users);
        } catch (IOException e) {
            throw new RuntimeException("Error saving user data to file", e);
        }
    }
}