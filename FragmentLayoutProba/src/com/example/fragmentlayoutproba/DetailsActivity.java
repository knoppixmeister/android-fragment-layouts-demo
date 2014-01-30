package com.example.fragmentlayoutproba;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

//!!!!! WARNING !!!!!!!!!!
//Add this class as activity into AndroidManifes.xml
public class DetailsActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);

    	ActionBar ab = getSupportActionBar();

    	ab.setDisplayHomeAsUpEnabled(true);

    	ab.show();

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // If the screen is now in landscape mode, we can show the
            // dialog in-line with the list so we don't need this activity.
            finish();
            return;
        }

        if(savedInstanceState == null) {
            DetailsFragment details = new DetailsFragment();
            details.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }
	}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if(item.getItemId() == android.R.id.home) {
    		super.onBackPressed();
    	}

    	return true;
    }
}
