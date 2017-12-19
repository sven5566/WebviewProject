package com.justtide.webviewproject.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.justtide.webviewproject.R;


/**
 * Created by whrr5 on 2017/7/18.
 */

public class LoadingDialog extends DialogFragment {
	TextView textView;
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final View view = View
				.inflate(getActivity(), R.layout
						.dialog_loading, null);
		textView= (TextView) view.findViewById(R.id.loading_dialog_txt);
		final AlertDialog dialog = new AlertDialog.Builder(getActivity()).setView(view)
				.create();
		Window window = dialog.getWindow();
		if (window != null) {
			WindowManager.LayoutParams attr = window.getAttributes();
			if (attr != null) {
				attr.height = ViewGroup.LayoutParams.WRAP_CONTENT;
				attr.width = ViewGroup.LayoutParams.WRAP_CONTENT;
				attr.gravity = Gravity.CENTER;//设置dialog 在布局中的位置
			}
		}
		return dialog;
	}

	public void setText(String msg){
		textView.setText(msg);
	}
	public void show(FragmentManager manager) {
		super.show(manager, LoadingDialog.class.getName());
	}

	@Override
	public void dismiss() {
		textView.setText("正在处理中...");
		super.dismiss();
	}
}
