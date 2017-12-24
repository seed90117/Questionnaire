package com.example.questionnaire;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends Activity {

	EditText nameET,bornET,studentidET; //宣告EditText物件
	RadioGroup sexRG; //宣告RadioGroup物件
	Spinner gradeSP; //宣告Spinner物件
	Button btn; //宣告Button物件
	ArrayAdapter<String> spinnerlist;
	String[] gradarray = {"一年級","二年級","三年級","四年級","延畢生","碩一","碩二","碩三","碩四"};
	String name,sex,born,studentid,grade;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//*****初始化設定*****//
		sex = "男";
		grade = "一年級";
		
		//*****將物件對應至指定的元件*****//
		nameET = (EditText)findViewById(R.id.EditText01); 
		bornET = (EditText)findViewById(R.id.EditText02);
		studentidET = (EditText)findViewById(R.id.EditText03);
		sexRG = (RadioGroup)findViewById(R.id.RadioGroup01);
		gradeSP = (Spinner)findViewById(R.id.Spinner01);
		btn = (Button)findViewById(R.id.Button01);
		
		//*****Spinner設定*****//
		spinnerlist = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,gradarray); //new一個ArrayAdapter，並設定
		gradeSP.setAdapter(spinnerlist); //將ArrayAdapter放進Spinner
		
		//*****Spinner聆聽事件*****//
		gradeSP.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				grade = gradarray[position]; //選擇到的選項放入變數
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}});
		
		//*****Button按鈕事件*****//
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//*****取得輸入數值*****//
				name = nameET.getText().toString();
				born = bornET.getText().toString();
				studentid = studentidET.getText().toString();
				
				//*****取得選擇的RadioButton*****//
				switch(sexRG.getCheckedRadioButtonId())
				{
				case R.id.Radio01:
					sex = "男";
				case R.id.Radio02:
					sex = "女";
				}
				
				//*****轉跳頁面程式碼*****//
				Intent i = new Intent(MainActivity.this,ShowActivity.class);//設定Intent物件並指定轉跳頁面
				Bundle b = new Bundle();
				
				//*****將數值放入Bundle*****//
				b.putString("name", name);
				b.putString("sex",sex);
				b.putString("born", born);
				b.putString("studentid", studentid);
				b.putString("grade", grade);
				
				//*****將Bundle放入Intent*****//
				i.putExtras(b);
				
				//*****轉跳頁面*****//
				startActivity(i);
				
			}});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
