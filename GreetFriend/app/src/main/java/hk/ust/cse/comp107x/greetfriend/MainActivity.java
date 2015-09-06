package hk.ust.cse.comp107x.greetfriend;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

//The mainactivity has been changed so that it now extends listactivity instead of activity
public class MainActivity extends ListActivity {

// introduce a new array with the name 'names'
    String [] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Construct a string array from the String Array resource "friends" in the
        // strings.xml file
        names = getResources().getStringArray(R.array.friends);

        // This method call sets the names string array as the source of the names
        // for the list of items in the listview. The ArrayAdapter object is used
        // to adapt the string array and construct a list of layout items that are
        // then used by the ListView of the ListActivity to construct the list of friends.
        // The layout of each item is specified by the friend_item.xml file
        setListAdapter( new ArrayAdapter<String>(this, R.layout.friend_item, names));

    }

//public class MainActivity extends Activity implements View.OnClickListener {

   // Button greetButton;

    //@Override
    //protected void onCreate(Bundle savedInstanceState) {
      //  super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //greetButton = (Button) findViewById(R.id.greetButton);
        //greetButton.setOnClickListener(this);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

   // @Override
    //public void onClick(View v) {

        // get a reference to the TextView on the UI so that we can show the display later
        //TextView textMessage = (TextView) findViewById(R.id.textMessage);

        //get a reference to the EditText so that we can read in the value typed
        // by the user
        //EditText editFriendName = (EditText) findViewById(R.id.editFriendName);

        // get the name of the friend typed in by the user in the EditText field, then convert to string
        //String friendName = editFriendName.getText().toString();

        //find the id of the button that is being clicked (In Scenarios with multiple buttons)
        //switch (v.getId()) {

            //in the case of the button clicked being greetButton,
           // case R.id.greetButton:

                // set the text being displayed by the TextView to the greeting
                // message for the friend
                //We give "Good Day" an id (greetstring) and store the actual value in values>strings.xml
                //textMessage.setText(getString(R.string.greetstring)+friendName+"!");

               // break;

            //must be included
           // default:

               // break;
       // }
    //}

    //@Override
    //public void onClick(View view) {

      //  TextView textMessage = (TextView) findViewById(R.id.textMessage);

        //EditText editFriendName = (EditText) findViewById(R.id.editFriendName);

        //String friendName = editFriendName.getText().toString();

        //switch (view.getId()) {

          //  case R.id.greetButton:

                // create a new intent. The first parameter is the Context which is the current Activity.
                // Hence we use "this". The second parameter is the Activity class that we wish to start.
                // Hence it is specified as ShowMessage.class
            //    Intent in = new Intent(this,ShowMessage.class);

                // Add the message as a payload to the Intent. We add data to be carried by the intern using
                // the putExtra() methods. The data is specified as a key-value pair. The first parameter is
                // the key, specified as a string, and the second parameter is the value.
                //in.putExtra("message", getString(R.string.greetstring) + friendName + "!");

                // We start the new activity by calling this method to inform the Android framework to start
                // the new activity. The parameter is the Intent we just created earlier
                //startActivity(in);

                //break;

           // default:
             //   break;
     //   }
    //}

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // The parameter "id" indicates the index of the item that was selected from
        // the list of friends. This is used to index into the names[] array to get
        // the name of the friend selected. Rest of the code is similar to the earlier
        // exercise.

        // create a new intent. The first parameter is the Context which is the current Activity.
        // Hence we use "this". The second parameter is the Activity class that we wish to start.
        // Hence it is specified as ShowMessage.class
        Intent in = new Intent(this,ShowMessage.class);

        // Add the message as a payload to the Intent. We add data to be carried by the intern using
        // the putExtra() methods. The data is specified as a key-value pair. The first parameter is
        // the key, specified as a string, and the second parameter is the value.
        in.putExtra("message", getString(R.string.greetstring) + names[(int) id] + "!");

        // We start the new activity by calling this method to inform the Android framework to start
        // the new activity. The parameter is the Intent we just created earlier
        startActivity(in);

    }



}
