package com.example.quickdemo.codedesign.node.before;

public class Test {
	public static void main(String[] args) {
		onClickTip();
	}

	/**
	 * 点击打赏按钮
	 */
	private static void onClickTip() {
		if (!NetworkHelper.getInstance().isConnect()) {
			System.out.println("网络未连接");
			NetworkHelper.getInstance().requestConnectNetwork(new NetworkHelper.NetworkCallback() {
				@Override
				public void onResult(boolean result) {
					if (result) {
						System.out.println("网络连接成功");
						if (!LoginHelper.getInstance().isLogin()) {
							System.out.println("用户未登录");
							LoginHelper.getInstance().requestLogin(new LoginHelper.LoginCallback() {
								@Override
								public void onResult(boolean success) {
									if (success) {
										System.out.println("用户登录成功");
										AccountHelper.getInstance().checkAccountType(new AccountInfo(),
											new AccountHelper.AccountCallback() {
												@Override
												public void onResult(int type) {
													if (type == AccountHelper.ACCOUNT_TYPE_ADULT) {
														System.out.println("是成人帐号");
														doTip();
													} else {
														System.out.println("不是成人帐号");
													}
												}
											});
									} else {
										System.out.println("用户登录失败，结束流程");
									}
								}
							});
						}
					}
				}
			});
		}
	}

	/**
	 * 进行打赏
	 */
	public static void doTip() {
		System.out.println("通过了一系列合法性校验，可以进行打赏");
	}
}
