package cn.tedu.wqhtest.ui;

import android.content.Context;
import android.content.SharedPreferences.Editor;

public class Config {
	
	public static final String SERVER_URL_getCode = "http://192.168.43.87:8080/TestServer/getCode.jsp";
	public static final String SERVER_URL_REGISTERED_OR_FORGET = "http://192.168.43.87:8080/TestServer/registered.jsp";
	public static final String SERVER_URL_LOGIN = "http://192.168.43.87:8080/TestServer/login.jsp";
	
	public static final String KEY_TOKEN = "token";
	public static final String KEY_COUNT = "count";
	public static final String KEY_ACTION = "action";
	public static final String KEY_PHONE_NUM = "phone";
	public static final String KEY_PHONE_MD5 = "phone_md5";
	public static final String KEY_STATUS = "status";
	public static final String KEY_CODE = "code";
	public static final String KEY_PASSWORD = "password";
	public static final String KEY_CONTACTS = "contatcs";
	
	
	public static final int RESULT_STATUS_LOGIN_FAIL = 7;
	public static final int RESULT_STATUS_LOGIN_OK = 6;
	public static final int RESULT_STATUS_MODIFY_OK = 5;
	public static final int RESULT_STATUS_REGISTERED_OK = 4;
	public static final int RESULT_STATUS_CODE_ERROR = 3;
	public static final int RESULT_STATUS_USER_EXIST = 2;
	public static final int RESULT_STATUS_SUCCESS = 1;
	public static final int RESULT_STATUS_FAIL = 0;	
	
	
	public static final String APP_ID = "cn.tedu.wqhtest";
	public static final String CHARSET = "UTF-8";
	
	public static final String ACTION_GET_CODE = "send_pass";
	public static final String ACTION_REGISTERED = "registered";
	public static final String ACTION_FORGET = "forget";
	public static final String ACTION_LOGIN = "login";
	public static final String ACTION_UPLOAD_CONTACTS = "upload_contacts";
	

	public static String getCachedToken(Context context) {
		return context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE)
				.getString(KEY_TOKEN, null);
	}
	
	public static String getCachedCount(Context context) {
		return context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE)
				.getString(KEY_COUNT, null);
	}
	
	public static void cacheToken(Context context,String token){
		Editor e = context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).edit();
		e.putString(KEY_TOKEN, token);
		e.commit();
	}
	
	public static void cacheCount(Context context,String count){
		Editor e = context.getSharedPreferences(APP_ID, Context.MODE_PRIVATE).edit();
		e.putString(KEY_COUNT, count);
		e.commit();
	}
	
}
