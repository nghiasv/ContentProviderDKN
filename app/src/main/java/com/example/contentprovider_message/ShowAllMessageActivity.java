package com.example.contentprovider_message;
import java.util.ArrayList;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.CursorLoader;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ShowAllMessageActivity extends Activity {
	Button btnback;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_all_message);
		btnback=(Button) findViewById(R.id.btnback);
		btnback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		showAllContacts1();
	}


	public void showAllContacts1() {
		ArrayList<String> list = new ArrayList<String>();
		ContentResolver contentResolver = getContentResolver();
		Cursor cursor = contentResolver.query(Uri.parse("content://sms/"), null, null, null, null);

		if (cursor != null) {
			int addressIndex = cursor.getColumnIndex("address");
			int bodyIndex = cursor.getColumnIndex("body");

			while (cursor.moveToNext()) {
				String address = cursor.getString(addressIndex);
				String body = cursor.getString(bodyIndex);
				String s = "";
				s = "$DT : " + address + "_ND : " + body;

				list.add(s);
			}
			cursor.close();
		}

		ListView lv = (ListView) findViewById(R.id.listView1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		lv.setAdapter(adapter);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_show_all_message, menu);
		return true;
	}

}
