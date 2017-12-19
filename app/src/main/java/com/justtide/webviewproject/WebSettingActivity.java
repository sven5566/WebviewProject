package com.justtide.webviewproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

public class WebSettingActivity extends AppCompatActivity {
	EditText et;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_setting);
		et = findViewById(R.id.web_setting_et);
		btn = findViewById(R.id.web_setting_btn);
		btn.setOnClickListener(v -> {
			final String text = String.valueOf(et.getText());
			Intent intent = new Intent(this, MainActivity.class);
			intent.putExtra(MainActivity.INTENT_KEY,text);
			startActivity(intent);
		});
	}
}
