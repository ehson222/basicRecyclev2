package com.ea222.reminderlistt4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/*
from activity_details xml, put the associated references to MyAdapter class

then add the necessary references below
 */
public class DetailsActivity extends AppCompatActivity {

    private TextView name, description, rating;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        extras = getIntent().getExtras();

        name = (TextView) findViewById(R.id.dNameId);
        description = (TextView) findViewById(R.id.dDescriptionId);
        rating = (TextView) findViewById(R.id.dRatingId);

        if(extras != null){
            name.setText(extras.getString("name"));
            description.setText(extras.getString("description"));
            rating.setText(extras.getString("rating"));
        }
    }
}
