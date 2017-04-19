package com.wristwatch.domain;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by web on 19/04/17.
 */
public class LoginForm {
    @NotEmpty
    String accountname;
    @NotEmpty
    String password;

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
