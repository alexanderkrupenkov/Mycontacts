package de.softan.mycontacts.db.dao.impl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.List;

import de.softan.mycontacts.db.DBHelper;
import de.softan.mycontacts.db.dao.PhoneUserI;
import de.softan.mycontacts.db.entity.PhoneUser;
import de.softan.mycontacts.db.table.PhoneUserTable;

public class PhoneUserImlp implements PhoneUserI {

    private SQLiteDatabase mDatabase;
    private DBHelper mDBHelper;

    @Override
    public void open() throws SQLException {

    }

    @Override
    public void close() {

    }

    @Override
    public List<PhoneUserI> getPhonesByUserId(int userId) {

        return null;
    }

    @Override
    public void setPhoneForUser(PhoneUser phoneForUser) {
        ContentValues cv = new ContentValues();
        cv.put(    PhoneUserTable.COLUMN_USER_ID, phoneForUser.getUser().getId());
        cv.put(PhoneUserTable.COLUMN_NUMBER, phoneForUser.getNumber());

        mDatabase.insert(PhoneUserTable.TABLE_NAME, null, cv);
    }
}
