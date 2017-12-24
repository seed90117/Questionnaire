package com.example.questionnaire;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ShowActivity extends Activity {

	TextView name,sex,born,studentid,grade; //�ŧiTextView����
	
	String na,se,bo,st,gr;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		
		//*****�N��������ܫ��w������*****//
		name = (TextView)findViewById(R.id.ShowTextView1);
		sex = (TextView)findViewById(R.id.ShowTextView2);
		born = (TextView)findViewById(R.id.ShowTextView3);
		studentid = (TextView)findViewById(R.id.ShowTextView4);
		grade = (TextView)findViewById(R.id.ShowTextView5);
		
		//*****�qBundle����*****//
		Bundle b = new Bundle();
		b = this.getIntent().getExtras();
		na = b.getString("name");
		se = b.getString("sex");
		bo = b.getString("born");
		st = b.getString("studentid");
		gr = b.getString("grade");
		
		
		//*****�]�wTextView�r��*****//
		name.setText("�m�W�G   "+na);
		sex.setText("�ʧO�G   "+se);
		born.setText("�X�͡G   "+bo);
		studentid.setText("�Ǹ��G   "+st);
		grade.setText("�~�šG   "+gr);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show, menu);
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
