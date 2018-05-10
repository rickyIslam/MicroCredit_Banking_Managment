package com.microcredit.android;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.mkyong.android.R;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener {
	//LOG_IN URL
	private static final String LOG_IN_URL = "http://10.0.2.2/mc_bank/checkLogin.php" ; 
		//	+ "json_response/checkLogIn.php";
	public static final int SUCCESS = 1;
	public static final int FAILURE = 0;
	public String serverResponse;
	private ProgressDialog pd;
	
	private Button continueButton;
	private EditText email, password;

	
	String userEmail, userPassword;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_login);
		
	
		
		continueButton  = (Button)findViewById(R.id.continueButton);
         password  = (EditText) findViewById (R.id.et) ;

		continueButton.setOnClickListener(this);

	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.continueButton:
			checkLogIn();
			break;

			
		default:
			break;
		
		}
		
	}
	
	private void checkLogIn(){

		userPassword = password.getText().toString();
		
		if((userPassword.isEmpty())){
			Toast.makeText(getApplicationContext(), "Please, Enter your Password.",
					Toast.LENGTH_SHORT).show();

		}else{
			//checking network connectivity
			if (isNetworkAvailable()) {
				
				//***checking weather email is used in another id or not
				pd = ProgressDialog.show(this, "", "Logging in...");
				CheckLogInThread clit = new CheckLogInThread();
				clit.start();

				
			} else {
				serverResponse = "Internet not available";
				Toast.makeText(getApplicationContext(), serverResponse,
						Toast.LENGTH_SHORT).show();
				
			}
			
		}
	}
	
	//Thread class for checking email validity
	class CheckLogInThread extends Thread {
		public void run() {
			try {
				DefaultHttpClient client = new DefaultHttpClient();
				HttpPost post = new HttpPost(LOG_IN_URL);
				
				List<NameValuePair> params = new ArrayList<NameValuePair>();
			
				params.add(new BasicNameValuePair("password", userPassword));
				post.setEntity(new UrlEncodedFormEntity(params));
				
				HttpResponse response = client.execute(post); //receiving response

				//checking response
				if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
					HttpEntity entity = response.getEntity();
					String jsonStr = EntityUtils.toString(entity);
					Log.d("JSON Response", jsonStr);

					//converting into json formate
					JSONObject obj = new JSONObject(jsonStr);
					String success = obj.getString("success");
					if (success.equals("1")) { //means valid id
						serverResponse = obj.getString("message");
						handler.sendEmptyMessage(SUCCESS);
						
					}else { //means error
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
				Toast.makeText(getApplicationContext(),serverResponse,
						Toast.LENGTH_SHORT).show();
				Intent userProfile = new Intent(Login.this, MainActivity.class);
//			
//				userProfile.putExtra("PASSWORD", userPassword);
				startActivity(userProfile);
				finish();
				
			} else {
				showAlert("Failure", serverResponse);
				//finish();
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
