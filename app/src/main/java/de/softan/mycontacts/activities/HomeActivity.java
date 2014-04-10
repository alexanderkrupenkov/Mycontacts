package de.softan.mycontacts.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import de.softan.mycontacts.R;
import de.softan.mycontacts.adapters.ContactsAdapter;
import de.softan.mycontacts.db.dao.UsersI;
import de.softan.mycontacts.db.dao.impl.UsersImpl;
import de.softan.mycontacts.db.entity.User;

public class HomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        UsersI users = new UsersImpl(this);


        try {
            users.open();



        } catch(Exception e) {
            Log.e("xxx", "Exception " + e);
        } finally {

        }

        User user = new User();
        user.setFirstName("Alexander");
        user.setLastName("Krupiankou2");
        users.setUser(user);
        User use2r = new User();
        use2r.setFirstName("Dmitry");
        use2r.setLastName("Borovoi2");
        users.setUser(use2r);

        ListView listView = (ListView) findViewById(R.id.lvData);

        // DBHelper db = new DBHelper(this);
        users.getUser(use2r);
        Cursor cursor = ((UsersImpl)users).getCurrentCursor();
        ContactsAdapter adapter = new ContactsAdapter(this, cursor, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }
        );
        users.close();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
