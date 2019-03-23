package cn.tedu.wqhtest.net;

import org.json.JSONException;
import org.json.JSONObject;

import cn.tedu.wqhtest.ui.Config;

public class Login {
	public Login(String phone_md5,String password, final SuccessCallback successCallback,final FailCallback failCallback){
		new NetConnection(Config.SERVER_URL_LOGIN, HttpMethod.POST, new NetConnection.SuccessCallback() {
			
			@Override
			public void onSuccess(String result) {
				try {
					JSONObject obj = new JSONObject(result);
					switch (obj.getInt(Config.KEY_STATUS)) {
					case Config.RESULT_STATUS_LOGIN_OK:
						if(successCallback!=null){
							successCallback.onSuccess(Config.RESULT_STATUS_LOGIN_OK);
						}
						break;
					case Config.RESULT_STATUS_LOGIN_FAIL:
						if(successCallback!=null){
							successCallback.onSuccess(Config.RESULT_STATUS_LOGIN_FAIL);
						}
						break;
					default:
						if(failCallback!=null){
							failCallback.onFail();
						}
						break;
					}
					
				} catch (JSONException e) {
					e.printStackTrace();
					
					if(failCallback!=null){
						failCallback.onFail();
					}
				}
				
			}
		}, new NetConnection.FailCallback() {
			
			@Override
			public void onFail() {
				if(failCallback!=null){
					failCallback.onFail();
				}
			}
		}, Config.KEY_ACTION,Config.ACTION_LOGIN,Config.KEY_PHONE_MD5,phone_md5,Config.KEY_PASSWORD,password);
	}
	
	public static interface SuccessCallback{
		void onSuccess(int status);
	}
	
	public static interface FailCallback{
		void onFail();
	}
}
