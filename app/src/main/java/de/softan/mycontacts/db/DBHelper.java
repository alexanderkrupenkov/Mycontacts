package de.softan.mycontacts.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import de.softan.mycontacts.db.table.MailUserTable;
import de.softan.mycontacts.db.table.PhoneUserTable;
import de.softan.mycontacts.db.table.UserTable;

/**
 * Created by Alexander on 27.02.14.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contacts";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 33);
    }

    public void onCreate(SQLiteDatabase db) {
        UserTable.onCreate(db);
        PhoneUserTable.onCreate(db);
        MailUserTable.onCreate(db);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
