package com.example.quickdemo.codedesign.node.before;

/**
 * 帐号辅助类
 */
public class AccountHelper {
	public static final int ACCOUNT_TYPE_ADULT = 1;

	private static final AccountHelper INSTANCE = new AccountHelper();

	private AccountHelper() {
	}

	public static AccountHelper getInstance() {
		return INSTANCE;
	}

	public void checkAccountType(AccountInfo accountInfo, final AccountCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (callback != null) {
					callback.onResult(ACCOUNT_TYPE_ADULT);
				}
			}
		}).start();
	}

	public interface AccountCallback {
		void onResult(int type);
	}
}
