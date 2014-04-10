package de.softan.mycontacts.db.table;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class UserTable {

    // Database table
    public static final String TABLE_NAME = "users_contacts";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LAST_NAME = "last_name";
    public static final String COLUMN_FIRST_NAME = "first_name";
    public static final String COLUMN_PHOTO_PROFILE = "photo";


    // Database creation SQL statement
    private static final String DATABASE_CREATE = "create table " + TABLE_NAME
            + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_LAST_NAME + " text not null, " + COLUMN_FIRST_NAME + " text not null, "
            + COLUMN_PHOTO_PROFILE + " text not null" + ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                 int newVersion) {
        Log.w(UserTable.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }



}
