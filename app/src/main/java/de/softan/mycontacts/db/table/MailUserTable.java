package de.softan.mycontacts.db.table;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MailUserTable {

    // Database table
    public static final String TABLE_NAME = "days_cultures";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USER_ID = "id_user";
    public static final String COLUMN_MAIL = "mail";


    // Database creation SQL statement
    private static final String DATABASE_CREATE = "create table " + TABLE_NAME
            + "(" + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_USER_ID + " integer not null, " + COLUMN_MAIL
            + " text not null " + ");";

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
