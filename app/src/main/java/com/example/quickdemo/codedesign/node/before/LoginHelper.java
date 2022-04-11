package com.example.quickdemo.codedesign.node.before;

/**
 * 登录辅助类
 */
public class LoginHelper {
	private boolean isLogin;


	private static final LoginHelper INSTANCE = new LoginHelper();

	private LoginHelper() {
	}

	public static LoginHelper getInstance() {
		return INSTANCE;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void requestLogin(final LoginCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				isLogin = false;
				if (callback != null) {
					callback.onResult(isLogin);
				}
			}
		}).start();
	}


	public interface LoginCallback {
		void onResult(boolean success);
	}
}
