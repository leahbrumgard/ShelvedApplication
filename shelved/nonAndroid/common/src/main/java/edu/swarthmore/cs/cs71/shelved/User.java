package edu.swarthmore.cs.cs71.shelved;

import org.mindrot.jbcrypt.BCrypt;

public interface User {
    void setUserName(String userName);
    void setPassword(String password);
    void setName(String name);
    public void setBio(String bio);
    public void setLocation(String location);
    void setSalt(String salt);
    void changePassword(String oldPassword, String newPassword);

    // getters

    String getPassword();

    String getName();

    String getBio();

    String getLocation();

    String getSalt();


}
