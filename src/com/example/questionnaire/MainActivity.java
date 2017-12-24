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

	EditText nameET,bornET,studentidET; //�ŧiEditText����
	RadioGroup sexRG; //�ŧiRadioGroup����
	Spinner gradeSP; //�ŧiSpinner����
	Button btn; //�ŧiButton����
	ArrayAdapter<String> spinnerlist;
	String[] gradarray = {"�@�~��","�G�~��","�T�~��","�|�~��","������","�Ӥ@","�ӤG","�ӤT","�ӥ|"};
	String name,sex,born,studentid,grade;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//*****��l�Ƴ]�w*****//
		sex = "�k";
		grade = "�@�~��";
		
		//*****�N��������ܫ��w������*****//
		nameET = (EditText)findViewById(R.id.EditText01); 
		bornET = (EditText)findViewById(R.id.EditText02);
		studentidET = (EditText)findViewById(R.id.EditText03);
		sexRG = (RadioGroup)findViewById(R.id.RadioGroup01);
		gradeSP = (Spinner)findViewById(R.id.Spinner01);
		btn = (Button)findViewById(R.id.Button01);
		
		//*****Spinner�]�w*****//
		spinnerlist = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,gradarray); //new�@��ArrayAdapter�A�ó]�w
		gradeSP.setAdapter(spinnerlist); //�NArrayAdapter��iSpinner
		
		//*****Spinner��ť�ƥ�*****//
		gradeSP.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				grade = gradarray[position]; //��ܨ쪺�ﶵ��J�ܼ�
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}});
		
		//*****Button���s�ƥ�*****//
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				//*****���o��J�ƭ�*****//
				name = nameET.getText().toString();
				born = bornET.getText().toString();
				studentid = studentidET.getText().toString();
				
				//*****���o��ܪ�RadioButton*****//
				switch(sexRG.getCheckedRadioButtonId())
				{
				case R.id.Radio01:
					sex = "�k";
				case R.id.Radio02:
					sex = "�k";
				}
				
				//*****��������{���X*****//
				Intent i = new Intent(MainActivity.this,ShowActivity.class);//�]�wIntent����ë��w�������
				Bundle b = new Bundle();
				
				//*****�N�ƭȩ�JBundle*****//
				b.putString("name", name);
				b.putString("sex",sex);
				b.putString("born", born);
				b.putString("studentid", studentid);
				b.putString("grade", grade);
				
				//*****�NBundle��JIntent*****//
				i.putExtras(b);
				
				//*****�������*****//
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
