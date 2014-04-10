package de.softan.mycontacts.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import de.softan.mycontacts.R;
import de.softan.mycontacts.db.table.UserTable;


/**
 * Created by Alexander on 30.03.14.
 */
public class ContactsAdapter extends CursorAdapter {

    private LayoutInflater mInflater;

    public ContactsAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = mInflater.inflate(R.layout.item_contact, parent, false);
        final ViewHolder holder = new ViewHolder();
        holder.fullName = (TextView) view.findViewById(R.id.tvFullName);
        holder.imageViewProfile = (ImageView) view.findViewById(R.id.ivProfile);
        view.setTag(holder);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final ViewHolder holder = (ViewHolder) view.getTag();

        String firstName = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_FIRST_NAME));
        String lastName = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_LAST_NAME));
        String photoProfile = cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_PHOTO_PROFILE));

        holder.fullName.setText(firstName + " " + lastName);
        holder.imageViewProfile.setImageResource(R.drawable.ic_launcher);
    }

    static class ViewHolder {
        ImageView imageViewProfile;
        TextView fullName;
    }
}
