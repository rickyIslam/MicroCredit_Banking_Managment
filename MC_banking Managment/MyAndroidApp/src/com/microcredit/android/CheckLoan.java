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

public class CheckLoan extends Activity {

	private String keyword;
	private static final String SEARCH_URL = "http://10.0.2.2/mc_bank/searchloan.php";
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
							String date = bookObject.getString("date");
							String time = bookObject.getString("time");
							String account_num = bookObject.getString("account_num");
							String loan_id = bookObject.getString("loan_id");
							String name = bookObject.getString("name");
							String amount = bookObject.getString("amount");
							String still_paid = bookObject.getString("still_paid");
							String  deadline = bookObject.getString("deadline");
							

							
							
							
							
							info.add ("") ;
							info.add ("") ;
							info.add ("") ;
							
							info.add ("....Customer's Information....") ;
							info.add ("Account Created:"+date) ;
							info.add ("Time: "+time) ;
							info.add ("Account Id: "+account_num) ;
							info.add ("Loan ID: "+loan_id) ;
							info.add ("Name: "+name) ;
							info.add ("Loan Amount: "+amount) ;
							
							info.add ("Still Paid: "+still_paid) ;
							info.add ("Payment Deadline: "+deadline) ;


							


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
				adapter = new ArrayAdapter<String>(CheckLoan.this,
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
