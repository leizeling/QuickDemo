package com.example.quickdemo.android.application;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Activity生命周期回调接口实现
 */
class MyActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
	public static final String TAG = MyActivityLifecycleCallbacks.class.getSimpleName();

	@Override
	public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
		Log.i(TAG, "onActivityCreated: " + activity.getClass().getSimpleName());
	}

	@Override
	public void onActivityStarted(@NonNull Activity activity) {
		Log.i(TAG, "onActivityStarted: " + activity.getClass().getSimpleName());
	}

	@Override
	public void onActivityResumed(@NonNull Activity activity) {
		Log.i(TAG, "onActivityResumed: " + activity.getClass().getSimpleName());
	}

	@Override
	public void onActivityPaused(@NonNull Activity activity) {
		Log.i(TAG, "onActivityPaused: " + activity.getClass().getSimpleName());
	}

	@Override
	public void onActivityStopped(@NonNull Activity activity) {
		Log.i(TAG, "onActivityStopped: " + activity.getClass().getSimpleName());
	}

	@Override
	public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
		Log.i(TAG, "onActivitySaveInstanceState: " + activity.getClass().getSimpleName());
	}

	@Override
	public void onActivityDestroyed(@NonNull Activity activity) {
		Log.i(TAG, "onActivityDestroyed: " + activity.getClass().getSimpleName());
	}
}