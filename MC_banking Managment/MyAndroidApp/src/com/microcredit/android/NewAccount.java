package com.microcredit.android;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;




import com.mkyong.android.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NewAccount extends Activity implements OnClickListener {
	private EditText etAcc, etName, etPhone, etNid, etOccupation, etAddress, etKeyword;
	private Button btnAdd, btnSearch;


	private Book book;
	public static final int SUCCESS = 1;
	public static final int FAILURE = 0;
	public static final String ADD_URL = "http://10.0.2.2/mc_bank/addaccount.php";
	public String serverResponse;
	private Uri outputFileUri;

  

	private ProgressDialog pd;
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newaccount);
		
    etAcc = (EditText) findViewById(R.id.pass) ;
    etName = (EditText) findViewById(R.id.editText2) ;
    etPhone= (EditText) findViewById(R.id.editText3) ;
    etNid = (EditText) findViewById(R.id.editText4) ;
    etOccupation = (EditText) findViewById(R.id.editText5) ;
    etAddress = (EditText) findViewById(R.id.editText6) ;
    etKeyword = (EditText) findViewById(R.id.editText7  );
		

		
	btnAdd = (Button) findViewById(R.id.btnAdd);
	btnAdd.setOnClickListener(this);
	
	btnSearch = (Button) findViewById(R.id.btnSearch);
	btnSearch.setOnClickListener(this);


	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnAdd:
			// validation

			Calendar c1 = Calendar.getInstance();
			SimpleDateFormat sdf1 = new SimpleDateFormat("(d+3)/M/yy");
			String date = sdf1.format(c1.getTime());
			
			String cusAcc = etAcc.getText().toString();
			String cusName = etName.getText().toString();
			String cusPhone = etPhone.getText().toString();
			String cusNid = etNid.getText().toString();
			String cusOccupation = etOccupation.getText().toString();
			String cusAddress = etAddress.getText().toString();
			

		
		
	book = new Book(cusAcc, date, cusName, cusPhone, cusNid, cusOccupation, cusAddress) ;
			
			if (isNetworkAvailable()) {
				pd = ProgressDialog.show(this, "",
					"Posting the book information...");
				PostThread thread = new PostThread();
				thread.start();
			} else {
				showAlert("Error", "Internet not available");
			}

			break;
			
		case R.id.btnSearch:
			Intent i = new Intent(this, SearchAccount.class);
			i.putExtra("keyword", etKeyword.getText().toString());
			startActivity(i);
			break;
		

		default:
			break;
			
		
		}
		
		
		

	}
		
	

	class PostThread extends Thread {
		public void run() {


			try {
				DefaultHttpClient client = new DefaultHttpClient();
				HttpPost post = new HttpPost(ADD_URL);

				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("acc", book.getAcc()));
				params.add(new BasicNameValuePair("date", book.getDate()));
				params.add(new BasicNameValuePair("name", book.getName()));
				params.add(new BasicNameValuePair("phone", book.getPhone()));
				params.add(new BasicNameValuePair("nid", book.getNid() ));
				params.add(new BasicNameValuePair("occupation", book.getOccupation() ));
				params.add(new BasicNameValuePair("address", book.getAddress()));
		
//				
//				List<NameValuePair> params = new ArrayList<NameValuePair>();
//				params.add(new BasicNameValuePair("acc", "aaa"));
//				params.add(new BasicNameValuePair("date", "aaa"));
//				params.add(new BasicNameValuePair("name", "aaa"));
//				params.add(new BasicNameValuePair("phone", "aaa"));
//				params.add(new BasicNameValuePair("nid", "aaa"));
//				params.add(new BasicNameValuePair("occupation", "aaa"));
//				params.add(new BasicNameValuePair("address", "aaa"));
				
				post.setEntity(new UrlEncodedFormEntity(params));

				HttpResponse response = client.execute(post);
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					HttpEntity entity = response.getEntity();
					String jsonStr = EntityUtils.toString(entity);
					Log.d("JSON Response", jsonStr);

					JSONObject obj = new JSONObject(jsonStr);
					String success = obj.getString("success");
					serverResponse = obj.getString("message");
					if (success.equals("1")) {
						handler.sendEmptyMessage(SUCCESS);
					} else {
						handler.sendEmptyMessage(FAILURE);
					}

				} else {
					serverResponse = "Server Error: "
							+ response.getStatusLine().getStatusCode();
					handler.sendEmptyMessage(FAILURE);
				}

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				serverResponse = e.getMessage();
				handler.sendEmptyMessage(FAILURE);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
				serverResponse = e.getMessage();
				handler.sendEmptyMessage(FAILURE);
			} catch (IOException e) {
				e.printStackTrace();
				serverResponse = e.getMessage();
				handler.sendEmptyMessage(FAILURE);
			} catch (JSONException e) {
				e.printStackTrace();
				serverResponse = e.getMessage();
				handler.sendEmptyMessage(FAILURE);
			}

		}
	}

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			pd.dismiss();
			if (msg.what == SUCCESS) {
				showAlert("Success", serverResponse);
			} else {
				showAlert("Error", serverResponse);
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