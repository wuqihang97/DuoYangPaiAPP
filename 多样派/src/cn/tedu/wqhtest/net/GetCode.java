package cn.tedu.wqhtest.net;

import org.json.JSONException;
import org.json.JSONObject;

import cn.tedu.wqhtest.ui.Config;

public class GetCode {
	public GetCode(String phone_md5, final SuccessCallback successCallback,
			final FailCallback failCallback) {
		new NetConnection(Config.SERVER_URL_getCode, HttpMethod.POST,
				new NetConnection.SuccessCallback() {

					@Override
					public void onSuccess(String result) {

						JSONObject jsonObj;
						try {
							jsonObj = new JSONObject(result);
							switch (jsonObj.getInt(Config.KEY_STATUS)) {
							case Config.RESULT_STATUS_SUCCESS:
								if (successCallback != null) {
									successCallback.onSuccess(Config.RESULT_STATUS_SUCCESS);
								}
								break;
							case Config.RESULT_STATUS_USER_EXIST:
								if (successCallback != null) {
									successCallback.onSuccess(Config.RESULT_STATUS_USER_EXIST);
								}
								break;
							}
						} catch (JSONException e) {
							e.printStackTrace();

							if (failCallback != null) {
								failCallback.onFail();
							}
						}

					}
				}, new NetConnection.FailCallback() {

					@Override
					public void onFail() {
						if (failCallback != null) {
							failCallback.onFail();
						}

					}
				}, Config.KEY_ACTION, Config.ACTION_GET_CODE,
				Config.KEY_PHONE_MD5, phone_md5);
	}

	public static interface SuccessCallback {
		void onSuccess(int status);
	}

	public static interface FailCallback {
		void onFail();
	}
}
