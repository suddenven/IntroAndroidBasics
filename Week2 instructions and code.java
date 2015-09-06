//Exercise: Greet Friend with Activity
/*
Step 1: Adding a new Activity

You can start with the version of the GreetFriend app that you completed at the end of the GreetFriend Exercise Part 2 in the previous section. Alternately, you can download the updated GreetFriend.zip file, unzip it and import it into Android Studio.
Open the activity_main.xml file. Then, delete the TextView with the ID textMessage from the UI layout and save the file.
Go to the left side under the project tree and right click on the location specified in the figure below and add a new Blank Activity.
When the new activity configuration window opens, type in the name of the new activity as ShowMessage.
Open activity_show_message.xml file. Then, position the "Hello world!" string to the center of the screen and change its text size to 24sp.
Double click on the "Hello world!" string and key in textMessage as the ID. We will be using this TextView to display the greeting message.

Step 2: Modifying the Code

Open MainActivity.java file and update the onClick() method code as shown below. You can read the comments in the code to understand the reasons for the modification, or watch the video instructions in the previous unit. Then save the changes to the file.
*/

    @Override
    public void onClick(View view) {

        TextView textMessage = (TextView) findViewById(R.id.textMessage);

        EditText editFriendName = (EditText) findViewById(R.id.editFriendName);

        String friendName = editFriendName.getText().toString();

        switch (view.getId()) {

            case R.id.greetButton:

                // create a new intent. The first parameter is the Context which is the current Activity.
                // Hence we use "this". The second parameter is the Activity class that we wish to start.
                // Hence it is specified as ShowMessage.class
                Intent in = new Intent(this,ShowMessage.class);

                // Add the message as a payload to the Intent. We add data to be carried by the intern using
                // the putExtra() methods. The data is specified as a key-value pair. The first parameter is
                // the key, specified as a string, and the second parameter is the value.
                in.putExtra("message", getString(R.string.greetstring) + friendName + "!");

                // We start the new activity by calling this method to inform the Android framework to start
                // the new activity. The parameter is the Intent we just created earlier
                startActivity(in);

                break;

            default:
                break;
        }
    }
	
	/*
	Open ShowMessage.java file and update the onCreate() method code as shown below. You can read the comments in the code to understand the reasons for the modification, or watch the video instructions in the previous unit. Then save the changes to the file.
	*/
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);

        // We first get a reference to the Intent that resulted in this activity
        // being started by the Android framework.
        Intent in = getIntent();

        // From the Intent we retrieve the message that was sent from MainActivity
        // Note the use of the same key, "message", to retrieve the message
        String message = in.getStringExtra("message");

        // Get the reference to the TextView on the ShowMessage UI
        TextView textMessage = (TextView) findViewById(R.id.textMessage);

        // set the text of the TextView to display the incoming greeting message
        textMessage.setText(message);
    }

	/*
	Now, run the application and see how the app starts with the GreetFriend activity. See the updated UI. When you type in your friend's name and click the Greetings button, it switches to the ShowMessage activity and displays the greetings message on the screen.
	*/
	
	//Exercise Greet friend with list activity
	/*
	Step 1: Adding String Resources

Open the strings.xml file and update its contents by adding the string-array resource as shown below.
*/

<resources>
    <string name="app_name">GreetFriend</string>

    <string name="hello_world">Hello world!</string>
    <string name="action_settings">Settings</string>
    <string name="greetstring">"Good Day "</string>
    <string name="title_activity_show_message">ShowMessage</string>

    <string-array name="friends">
        <item>John</item>
        <item>Paul</item>
        <item>George</item>
        <item>Ringo</item>
    </string-array>

</resources>

/*
Step 2: Adding a Layout for the ListItem

Right click on res->layout folder and add a new resource file. Specify the name of the file as friend_item and the root element as TextView in the selection window.
Once the layout file named friend_item.xml is created, edit the properties of the TextView by setting its text to "Friend Name", its gravity to center_horizontal and center_vertical, its padding to 20dp and text size to 24sp.
Step 3: Modifying the Code

Open MainActivity.java file and update the class definition and the onCreate() method as shown below.
*/
public class MainActivity extends ListActivity {


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
	//Then, at the bottom, replace the onClick() method with the following onListItemClick() method code as shown below.
	
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
	
	//Exercise Greet friend with lifecycle
	//Step 1 Adding activity lifecycle methods
	//Modify the  MainActivity.java file by adding in various lifecycle methods for the activity as shown below.
	
	

    String [] names;

    private static final String TAG = "MainActivity";

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

        Log.i(TAG, "in onCreate()");

    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "in onStart()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "in onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "in onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "in onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "in onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "in onDestroy()");
    }

	//Similarly, modify the ShowMessage.java file to add the lifecycle methods to this activity as shown below.
	
	
    private static final String TAG = "ShowMessage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);

        // We first get a reference to the Intent that resulted in this activity
        // being started by the Android framework.
        Intent in = getIntent();

        // From the Intent we retrieve the message that was sent from MainActivity
        // Note the use of the same key, "message", to retrieve the message
        String message = in.getStringExtra("message");

        // Get the reference to the TextView on the ShowMessage UI
        TextView textMessage = (TextView) findViewById(R.id.textMessage);

        // set the text of the TextView to display the incoming greeting message
        textMessage.setText(message);

        Log.i(TAG, "in onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "in onStart()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "in onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "in onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "in onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "in onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "in onDestroy()");
    }

	//After updating both the activities, run the application to see how the lifecycle methods of each activity are invoked by the Android framework as the app starts. Then move from MainActivity to ShowMessage. See the messages being printed out in the Logcat window.
	
	//Exercise: Chat client app
	/*
	Step 1: Examining the Project Files

Download the SimpleChatClient.zip file to your projects folder. Unzip it and import the SimpleChatClient project into Android Studio.
Open the activity_chat_client.xml and message.xml layout files and see the use of LinearLayout, RelativeLayout and the positioning of the views on the UI.
Open the Message.java file to see the implementation of the Message class that is used to create message objects.
Step 2: Modifying the Custom Array Adapter

Update the getView() method in the MyArrayAdapter.java as shown below.
*/


    // This method constructs the ListItem's view from the data obtained
    // from the Message object. This will be called by ListView while it
    // is being drawn.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View messageView;

        // Get a reference to the LayoutInflater. This helps construct the
        // view from the layout file
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // The messageView is constructed by inflating the message.xml layout file
        messageView = inflater.inflate(R.layout.message, parent, false);

        // Get the reference to the two TextViews in the message layout and set them
        // to the time and message string respectively
        TextView timeView = (TextView) messageView.findViewById(R.id.timeTextView);
        timeView.setText(messages.get(position).getTime());
        TextView msgView = (TextView) messageView.findViewById(R.id.messageTextView);
        msgView.setText(messages.get(position).getMessage());

        return messageView;
    }

	/*
	Step 3: Modifying the ChatClient Activity

First, modify the onCreate() method of the ChatClient activity as shown below.
*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_client);

        sendButton = (Button) findViewById(R.id.sendButton);
        sendButton.setOnClickListener(this);

        messageText = (EditText) findViewById(R.id.messageText);

        // Get the reference to the ListView on the UI
        messageList = (ListView) findViewById(R.id.messageList);

        // Create a new ArrayList of Message objects
        messages = new ArrayList<Message>();

        // Create a new custom ArrayAdapter. This custom Adapter is
        // implemented by us, and illustrates how an ArrayAdapter is
        // constructed given the data (from the Message objects)
        mAdapter = new MyArrayAdapter(this, messages);

        // Set the ListView's adapter to be the adapter that we just constructed.
        messageList.setAdapter((ListAdapter) mAdapter);
    }

	//Then, modify the onClick() method of the ChatClient activity as shown below.
	
	    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.sendButton:

                String messString = messageText.getText().toString();

                // If the message is not empty string
                if (!messString.equals("")) {

                    // Create a new Message object and initialize it with the information
                    Message message = new Message("", messString, true, new Date());

                    // Add the Message object to the ArrayList
                    messages.add(message);

                    // Notify the adapter that the data has changed due to the addition
                    // of a new message object. This triggers an update of the ListView
                    mAdapter.notifyDataSetChanged();

                    message = null;
                    messageText.setText("");

                }

                break;

            default:
                break;
        }
    }




