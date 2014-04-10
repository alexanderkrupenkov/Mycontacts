package de.softan.mycontacts.db.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;
import java.util.List;

import de.softan.mycontacts.db.DBHelper;
import de.softan.mycontacts.db.dao.UsersI;
import de.softan.mycontacts.db.entity.User;
import de.softan.mycontacts.db.table.UserTable;

public class UsersImpl implements UsersI {

    private SQLiteDatabase mDatabase;
    private DBHelper mDBHelper;

    private Cursor mCurrentCursor;

    public Cursor getCurrentCursor() {
        String sqlQuery = "select * "
                + "from "+ UserTable.TABLE_NAME + " ; ";

       return mCurrentCursor = mDatabase.rawQuery(sqlQuery, null);
    }

    public UsersImpl(Context context) {
        mDBHelper = new DBHelper(context);
    }

    @Override
    public User setUser(User user) {
        User userFromBase = getUser(user);

        if(userFromBase == null) {
            Log.d("xxx", "setUser ROW_ID " + user.getId() + " HAS NAME "
                    + user.getFirstName());
            ContentValues cv = new ContentValues();
            cv.put(UserTable.COLUMN_FIRST_NAME, user.getFirstName());
            cv.put(UserTable.COLUMN_LAST_NAME, user.getLastName());
            cv.put(UserTable.COLUMN_PHOTO_PROFILE, user.getPhotoProfile());
            mDatabase.insert(UserTable.TABLE_NAME, null, cv);

            return getUser(user);
        }

       return userFromBase;
    }

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public User getUser(User user) {

        String sqlQuery = "select * "
                + "from "+ UserTable.TABLE_NAME + " " +
                " where " +
                " " + UserTable.COLUMN_FIRST_NAME + " = ?;" ;//+ user.getFirstName() + " " + "  ;";
              //  " and " + UserTable.COLUMN_LAST_NAME + " = " + user.getFirstName()+


        mCurrentCursor = mDatabase.rawQuery(sqlQuery, new String[]{user.getFirstName()});

     //   mCurrentCursor.moveToFirst();

        while (mCurrentCursor.moveToNext()) {
            User userInBase = new User();

            userInBase.setId(mCurrentCursor.getInt(mCurrentCursor
                    .getColumnIndex(UserTable.COLUMN_ID)));
            userInBase.setFirstName(mCurrentCursor.getString(mCurrentCursor
                    .getColumnIndex(UserTable.COLUMN_FIRST_NAME)));
            userInBase.setLastName(mCurrentCursor.getString(mCurrentCursor
                    .getColumnIndex(UserTable.COLUMN_LAST_NAME)));


            Log.i("MY_LOG", "ROW_ID " + userInBase.getId() + " HAS NAME "
                    + userInBase.getFirstName());

            return userInBase;
        }
        mCurrentCursor.close();

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void open() throws SQLException {
        mDatabase = mDBHelper.getWritableDatabase();
    }

    @Override
    public void close() {
        mDBHelper.close();
    }
}
