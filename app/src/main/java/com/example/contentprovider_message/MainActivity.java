package com.example.contentprovider_message;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.Manifest;
import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends Activity implements OnClickListener{

	Button btnshowallcontact;
	Button btnaccesscalllog;
	Button btnaccessmediastore;
	Button btnaccessbookmarks;

	private static final int REQUEST_READ_SMS_PERMISSION = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnshowallcontact=(Button) findViewById(R.id.btnshowallcontact);
		btnshowallcontact.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_SMS)
						!= PackageManager.PERMISSION_GRANTED) {
					ActivityCompat.requestPermissions(MainActivity.this,
							new String[]{Manifest.permission.READ_SMS}, REQUEST_READ_SMS_PERMISSION);
				} else {
					startActivity(new Intent(MainActivity.this, ShowAllMessageActivity.class));
				}

			}
		});
		btnaccesscalllog=(Button) findViewById(R.id.btnaccesscalllog);
		btnaccesscalllog.setOnClickListener(this);
		btnaccessmediastore=(Button) findViewById(R.id.btnmediastore);
		btnaccessmediastore.setOnClickListener(this);
		btnaccessbookmarks=(Button) findViewById(R.id.btnaccessbookmarks);
		btnaccessbookmarks.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		Intent intent=null;
		if(v==btnshowallcontact)
		{
//			intent=new Intent(this, ShowAllMessageActivity.class);
//			startActivity(intent);
		}
		else if(v==btnaccesscalllog)
		{
			//accessTheCallLog();
		}
		else if(v==btnaccessmediastore)
		{
			//accessMediaStore();
		}
		else if(v==btnaccessbookmarks)
		{
			//accessBookmarks();
		}
	}

//	public void accessTheCallLog()
//	{
//		String [] projection=new String[]{
//				Calls.DATE,
//				Calls.NUMBER,
//				Calls.DURATION
//				};
//		Cursor c=getContentResolver().query(
//				Calls.CONTENT_URI,
//				projection,
//				Calls.DURATION+"<?",new String[]{"30"},
//				Calls.DATE +" Asc");
//		c.moveToFirst();
//		String s="";
//		while(c.isAfterLast()==false){
//			for(int i=0;i<c.getColumnCount();i++){
//				s+=c.getString(i)+" - ";
//			}
//			s+="\n";
//			c.moveToNext();
//		}
//		c.close();
//		Toast.makeText(this, s, Toast.LENGTH_LONG).show();
//	}
//	/**
//	 * hàm đọc danh sách các Media trong SD CARD
//	 */
//	public void accessMediaStore()
//	{
//		String []projection={
//				MediaStore.MediaColumns.DISPLAY_NAME,
//				MediaStore.MediaColumns.DATE_ADDED,
//				MediaStore.MediaColumns.MIME_TYPE
//				};
//		CursorLoader loader=new CursorLoader
//				(this, Media.EXTERNAL_CONTENT_URI,
//						projection, null, null, null);
//		Cursor c=loader.loadInBackground();
//		c.moveToFirst();
//		String s="";
//		while(!c.isAfterLast()){
//			for(int i=0;i<c.getColumnCount();i++){
//				s+=c.getString(i)+" - ";
//			}
//			s+="\n";
//			c.moveToNext();
//		}
//		Toast.makeText(this, s, Toast.LENGTH_LONG).show();
//		c.close();
//	}
//	/**
//	 * hàm đọc danh sách Bookmark trong trình duyệt
//	 */
//	public void accessBookmarks()
//	{
//		String []projection={
//				Browser.BookmarkColumns.TITLE,
//				Browser.BookmarkColumns.URL,
//			};
//		Cursor c=getContentResolver()
//				.query(Browser.BOOKMARKS_URI, projection,
//						null, null, null);
//		c.moveToFirst();
//		String s="";
//		int titleIndex=c.getColumnIndex
//						(Browser.BookmarkColumns.TITLE);
//		int urlIndex=c.getColumnIndex
//						(Browser.BookmarkColumns.URL);
//		while(!c.isAfterLast())
//		{
//			s+=c.getString(titleIndex)+" - "+
//					c.getString(urlIndex);
//			c.moveToNext();
//		}
//		c.close();
//		Toast.makeText(this, s, Toast.LENGTH_LONG).show();
//	}
}
