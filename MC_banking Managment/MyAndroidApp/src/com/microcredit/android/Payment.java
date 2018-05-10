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

public class Payment extends Activity implements OnClickListener {
	private EditText etAcc, etLoan, etAmount;
	private Button btnAdd ;


	private Book book;
	public static final int SUCCESS = 1;
	public static final int FAILURE = 0;
	public static final String ADD_URL = "http://10.0.2.2/mc_bank/payment.php";
	public String serverResponse;
	private Uri outputFileUri;

	

	private ProgressDialog pd;
	
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment_activity);
		
    etAcc = (EditText) findViewById(R.id.editText1) ;

    etLoan= (EditText) findViewById(R.id.editText2) ;
    etAmount = (EditText) findViewById(R.id.editText3) ;
   
		

		
	btnAdd = (Button) findViewById(R.id.button1);
	btnAdd.setOnClickListener(this);
	



	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			// validation

			
			if (isNetworkAvailable()) {
				pd = ProgressDialog.show(this, "",
					"Posting the book information...");
				PostThread thread = new PostThread();
				thread.start();
			} else {
				showAlert("Error", "Internet not available");
			}

			break;

		default:
			break;
			
		
		}
		
		
		

	}
		
	

	class PostThread extends Thread {
		public void run() {

			Calendar c1 = Calendar.getInstance();
			SimpleDateFormat sdf1 = new SimpleDateFormat("d/M/yy");
			
			
			
			String strdate1 = sdf1.format(c1.getTime());
			
			String cusAcc = etAcc.getText().toString();
			String cusLoan = etLoan.getText().toString();
			String cusAmount = etAmount.getText().toString();
			
			try {
				DefaultHttpClient client = new DefaultHttpClient();
				HttpPost post = new HttpPost(ADD_URL);

				List<NameValuePair> params = new ArrayList<NameValuePair>();
				
				params.add(new BasicNameValuePair("date", strdate1));
				params.add(new BasicNameValuePair("acc", cusAcc));
				params.add(new BasicNameValuePair("loan", cusLoan));
			
				params.add(new BasicNameValuePair("amount", cusAmount));
		

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