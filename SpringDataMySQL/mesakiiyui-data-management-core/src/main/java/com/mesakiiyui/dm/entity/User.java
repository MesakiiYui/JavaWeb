package com.mesakiiyui.dm.entity;


import java.io.Serializable;
public class User implements Serializable {
    private static final long serialVersionUID = 5237730257103305078L;
    private String userName;
    private String passwd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
