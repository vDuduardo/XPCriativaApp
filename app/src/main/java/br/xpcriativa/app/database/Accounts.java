package br.xpcriativa.app.database;

import java.util.HashMap;

public class Accounts {
    HashMap<String, String> logins;

    public Accounts() {
        this.logins = new HashMap<>();
        createLogins();
    }

    private void createLogins(){
        logins.put("felipe@gmail.com", "123");
        logins.put("dudu@gmail.com", "123");
        logins.put("ulissera@gmail.com", "123");
        logins.put("marco@gmail.com", "123");
        logins.put("adm", "adm");
    }

    public void insertLogin(String email, String password){
        logins.put(email, password);
    }

    public boolean isValidLogin(String email, String password){
        String pwd = logins.getOrDefault(email, "");
        if(logins.containsKey(email) && password.equals(pwd))
            return true;
        return false;
    }

    public boolean hasLogin(String email){
        return logins.containsKey(email);
    }
}
