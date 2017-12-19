package com.justtide.webviewproject.util;

import android.util.Log;

/**
 * Created by whrr5 on 2017/6/26.
 */

public final class L {
	private static String TAG="wuhaoran";
	public static void a(String msg){
		e(TAG,msg);
	}
	//开关
	private final static boolean flag = true;//true 测试                 false  上线

	public static void v(String tag, String msg){
		if(flag){
			Log.v(tag, msg);
		}
	}
	public static void d(String tag, String msg){
		if(flag){
			Log.d(tag, msg);
		}
	}
	public static void i(String tag, String msg){
		if(flag){
			Log.i(tag, msg);
		}
	}
	public static void w(String tag, String msg){
		if(flag){
			Log.w(tag, msg);
		}
	}
	public static void e(String tag, String msg){
		if(flag){
			Log.e(tag, msg);
		}
	}
}
