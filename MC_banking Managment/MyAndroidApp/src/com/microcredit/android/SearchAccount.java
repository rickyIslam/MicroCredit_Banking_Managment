package com.microcredit.android;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mkyong.android.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SearchAccount extends Activity {

	private String keyword;
	private static final String SEARCH_URL = "http://10.0.2.2/mc_bank/searchaccount.php";
	public static final int SUCCESS = 1;
	public static final int FAILURE = 0;
	public String serverResponse;

	private ArrayAdapter<String> adapter;
	private ArrayList<String> info;

	private ProgressDialog pd;
	
	private ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
setContentView(R.layout.activity_search);
listView = (ListView) findViewById(R.id.listView1);
		
		
		keyword = getIntent().getStringExtra("keyword");

		if (isNetworkAvailable()) {
			pd = ProgressDialog.show(this, "", "searching...");
			SearchThread thread = new SearchThread();
			thread.start();
		} else {
			//showAlert("Error", "Internet not available");
		}

	}

	class SearchThread extends Thread {
		public void run() {

			try {
				DefaultHttpClient client = new DefaultHttpClient();
				HttpGet get = new HttpGet(SEARCH_URL + "?keyword=" + keyword);
				HttpResponse response = client.execute(get);

				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					HttpEntity entity = response.getEntity();
					String jsonStr = EntityUtils.toString(entity);
					Log.d("JSON Response", jsonStr);

					JSONObject obj = new JSONObject(jsonStr);
					String success = obj.getString("success");
					if (success.equals("1")) {
						JSONArray arr = obj.getJSONArray("info");
						info =new ArrayList<String>();
						for (int i = 0; i < arr.length(); i++) {
							JSONObject bookObject = arr.getJSONObject(i);
							String acc = bookObject.getString("acc");
							String date = bookObject.getString("date");
							String name = bookObject.getString("name");
							String phone = bookObject.getString("phone");
							String nid = bookObject.getString("nid");
							String occupation = bookObject.getString("occupation");
							String address = bookObject.getString("address");
							
							
							
							
							info.add ("") ;
							info.add ("") ;
							info.add ("") ;
							info.add ("") ;
							info.add ("~~Customer's Information~~") ;
							info.add ("A/C ID:"+acc) ;
							info.add ("A/C Created: "+date) ;
							info.add ("Name: "+name) ;
							info.add ("Phone No.: "+phone) ;
						    info.add("National ID: "+nid) ;
						    info.add ("Occupation: "+occupation) ;
						 
							info.add ("Address: "+address) ;
							
//							Book b = new Book(acc, date, name, phone, nid, occupation, address) ;
//							info.add(b.toString());

						}

						handler.sendEmptyMessage(SUCCESS);
					} else {
						serverResponse = obj.getString("message");
						handler.sendEmptyMessage(FAILURE);
					}
				} else {
					serverResponse = "Server Error";
					handler.sendEmptyMessage(FAILURE);
				}

			} catch (ClientProtocolException e) {
				serverResponse = e.getMessage();
				handler.sendEmptyMessage(FAILURE);
				e.printStackTrace();
			} catch (IOException e) {
				serverResponse = e.getMessage();
				handler.sendEmptyMessage(FAILURE);
				e.printStackTrace();
			} catch (JSONException e) {
				serverResponse = e.getMessage();
				handler.sendEmptyMessage(FAILURE);
				e.printStackTrace();
			}
		}
	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			pd.dismiss();
			if (msg.what == SUCCESS) {
				adapter = new ArrayAdapter<String>(SearchAccount.this,
						R.layout.search, R.id.search_text, info);
				listView.setAdapter(adapter);
			} else {
				showAlert("Failure", serverResponse);
			}
		}
	};

	public boolean isNetworkAvailable() {
		// network state
		ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = manager.getActiveNetworkInfo();
		if (netInfo != null) {
			if (netInfo.isAvailable() && netInfo.isAvailable()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void showAlert(String title, String message) {
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setTitle(title);
		alert.setMessage(message);
		alert.show();
	}
}
