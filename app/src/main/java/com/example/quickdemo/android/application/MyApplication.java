package com.example.quickdemo.android.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class MyApplication extends Application {
	private static final String TAG = MyApplication.class.getSimpleName();

	private static MyApplication INSTANCE;

	public static MyApplication getInstance() {
		return INSTANCE;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i(TAG, "onCreate");
		INSTANCE = this;
		registerActivityLifecycleCallbacks(new MyActivityLifecycleCallbacks());
	}

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		Log.i(TAG, "attachBaseContext");
	}
}