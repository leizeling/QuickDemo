package com.example.quickdemo.codedesign.node.before;

/**
 * 网络辅助类
 */
public class NetworkHelper {
	private boolean connect;

	private static final NetworkHelper INSTANCE = new NetworkHelper();

	private NetworkHelper() {
	}

	public static NetworkHelper getInstance() {
		return INSTANCE;
	}

	public boolean isConnect() {
		return connect;
	}

	public void setConnect(boolean connect) {
		this.connect = connect;
	}

	public void requestConnectNetwork(final NetworkCallback callback) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				connect = true;
				if (callback != null) {
					callback.onResult(connect);
				}
			}
		}).start();
	}

	public interface NetworkCallback {
		void onResult(boolean result);
	}
}
