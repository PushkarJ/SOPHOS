package com.gestures;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.gestures.generated.R;
import com.gestures.utils.Constants;

public class ShowResults extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		Intent intent = getIntent();
		String searchMethod = intent.getExtras().getString(
				Constants.SEARCH_METHOD);
		@SuppressWarnings("unchecked")
		Hashtable<String, Double> results =(Hashtable<String,Double>) intent.getExtras().get(
				Constants.RESULTS);
		StringBuilder resultsCSV = new StringBuilder();
		resultsCSV.append(Constants.SEARCH_METHOD).append(",");
		if(results!=null)
		{
			Set<String> result_header=results.keySet();
		for(String rh:result_header)
		{
			resultsCSV.append(rh).append(",");
		}
		resultsCSV.append("Results");
		resultsCSV.append(System.getProperty("line.separator"));
		resultsCSV.append(searchMethod+",");
		Collection<Double> result_values=results.values();
		double total=0;
		for(Double rh:result_values)
		{
			resultsCSV.append(rh).append(",");
			total+=rh;
		}
		resultsCSV.append(total).append(System.getProperty("line.separator"));

		TextView resultsText = (TextView)findViewById(R.id.results);
		resultsText.setText(resultsCSV.toString());
		}
	}
}