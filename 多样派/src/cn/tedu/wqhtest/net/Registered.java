package cn.tedu.wqhtest.net;

import org.json.JSONException;
import org.json.JSONObject;

import cn.tedu.wqhtest.ui.Config;

public class Registered {
	public Registered(String phone_md5,String code,String password, final SuccessCallback successCallback,final FailCallback failCallback){
		new NetConnection(Config.SERVER_URL_REGISTERED_OR_FORGET, HttpMethod.POST, new NetConnection.SuccessCallback() {
			
			@Override
			public void onSuccess(String result) {
				try {
					JSONObject obj = new JSONObject(result);
					switch (obj.getInt(Config.KEY_STATUS)) {
					case Config.RESULT_STATUS_REGISTERED_OK:
						if(successCallback!=null){
							successCallback.onSuccess(Config.RESULT_STATUS_REGISTERED_OK);
						}
						break;
					case Config.RESULT_STATUS_CODE_ERROR:
						if(successCallback!=null){
							successCallback.onSuccess(Config.RESULT_STATUS_CODE_ERROR);
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
		}, Config.KEY_ACTION,Config.ACTION_REGISTERED,Config.KEY_PHONE_MD5,phone_md5,Config.KEY_CODE,code,Config.KEY_PASSWORD,password);
	}
	
	public static interface SuccessCallback{
		void onSuccess(int status);
	}
	
	public static interface FailCallback{
		void onFail();
	}
}
