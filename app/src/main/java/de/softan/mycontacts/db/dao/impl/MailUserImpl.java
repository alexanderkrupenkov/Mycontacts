package de.softan.mycontacts.db.dao.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;

import de.softan.mycontacts.db.DBHelper;
import de.softan.mycontacts.db.dao.MailUserI;
import de.softan.mycontacts.db.entity.MailUser;

public class MailUserImpl implements MailUserI {

    private SQLiteDatabase mDatabase;

    private DBHelper mDBHelper;

    public MailUserImpl(Context context) {
        mDBHelper = new DBHelper(context);
    }

    @Override
    public void open() throws SQLException {
        mDatabase = mDBHelper.getWritableDatabase();
    }

    @Override
    public void close() {
        mDBHelper.close();
    }

    @Override
    public MailUserI getMailByUserId(int userId) {
        return null;
    }

    @Override
    public void setMailForUser(MailUser mailForUser) {

    }
}
