package br.xpcriativa.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


public class UserDAO {

    private DatabaseConnection con;
    private SQLiteDatabase db;

    public UserDAO(Context context){
        con = new DatabaseConnection(context);

    }

    public long insertUser(User user){
        if(!db.isOpen())
        db = con.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", user.getEmail());
        values.put("password", user.getPassword());
        return db.insert("user", null, values);
    }

    public void createDatabase(){
        try{
            db.execSQL("create table if not exists user (" +
                    "id integer primary key autoincrement, " +
                    "email varchar(50)," +
                    "password varchar(50))");

            db.execSQL("insert into user (email, password) values" +
                    "('felipe@gmail.com', '123')," +
                    "('dudu@gmail.com', '123')," +
                    "('marco@gmail.com', '123')," +
                    "('ulissera@gmail.com', '123')," +
                    "('adm', 'adm')");
        }
        catch(Exception e){
            System.out.println("Erro ao criar o banco: " + e);
        }
    }


}
