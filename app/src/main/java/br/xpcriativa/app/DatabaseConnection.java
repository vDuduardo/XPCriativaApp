package br.xpcriativa.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseConnection extends SQLiteOpenHelper {
    private static final String name = "Phantom.db";
    private static final int version = 1;


    public DatabaseConnection(Context context){
        super(context, name, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("create table if not exists user (" +
//                "id integer primary key autoincrement, " +
//                "email varchar(50)," +
//                "password varchar(50))");
//
//        db.execSQL("insert into user  (email, password) values" +
//                "('felipe@gmail.com', '123')," +
//                "('dudu@gmail.com', '123')," +
//                "('marco@gmail.com', '123')," +
//                "('ulissera@gmail.com', '123')," +
//                "('adm', 'adm')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean hasEmail(SQLiteDatabase db, String email){
        db = this.getReadableDatabase()
    }
    public boolean isOpen()
}
