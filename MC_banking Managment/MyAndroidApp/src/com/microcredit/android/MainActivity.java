package com.microcredit.android;

import com.mkyong.android.R;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Resources ressources = getResources(); 
		TabHost tabHost = getTabHost(); 
		
		// Android tab
		Intent intentAndroid = new Intent().setClass(this, NewAccount.class);
		TabSpec tabSpecAndroid = tabHost
			.newTabSpec("Android")
			.setIndicator("New A/C", ressources.getDrawable(R.drawable.monitor_add))
			.setContent(intentAndroid);

		// Apple tab
		Intent intentApple = new Intent().setClass(this, Loan.class);
		TabSpec tabSpecApple = tabHost
			.newTabSpec("Apple")
			.setIndicator("Loan", ressources.getDrawable(R.drawable.money_add))
			.setContent(intentApple);
		
		// Windows tab
		Intent intentWindows = new Intent().setClass(this, Payment.class);
		TabSpec tabSpecWindows = tabHost
			.newTabSpec("Windows")
			.setIndicator("Payment", ressources.getDrawable(R.drawable.money_delete))
			.setContent(intentWindows);
		
		// Blackberry tab
		Intent intentBerry = new Intent().setClass(this, AllCusActivity.class);
		TabSpec tabSpecBerry = tabHost
			.newTabSpec("Berry")
			.setIndicator("Members", ressources.getDrawable(R.drawable.report_user))
			.setContent(intentBerry);
	
		// add all tabs 
		tabHost.addTab(tabSpecAndroid);
		tabHost.addTab(tabSpecApple);
		tabHost.addTab(tabSpecWindows);
		tabHost.addTab(tabSpecBerry);
		
		//set Windows tab as default (zero based)
		tabHost.setCurrentTab(0);
	}

}