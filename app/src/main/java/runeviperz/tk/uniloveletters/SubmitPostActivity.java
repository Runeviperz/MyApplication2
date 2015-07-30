package runeviperz.tk.uniloveletters;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;


public class SubmitPostActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_post);

        Spinner spinner = (Spinner) findViewById(R.id.type_of_post);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.types_of_posts,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner unis = (Spinner) findViewById(R.id.uni_of_post);
        ArrayAdapter<CharSequence> uni_adapter = ArrayAdapter.createFromResource(this, R.array.universities_array,
                android.R.layout.simple_spinner_item);
        uni_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unis.setAdapter(uni_adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_submit_post, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void lolol(View view) {
        //submit button is pressed

        Spinner spinner = (Spinner)findViewById(R.id.type_of_post);
        int type;
        switch(spinner.getSelectedItem().toString()) { //first get type of post
            case "Love Letter": type = Constant.LOVE; break;
            case "Rant": type = Constant.RANT; break;
            case "Confession": type = Constant.CONFESSION; break;
            case "Advice": type = Constant.ADVICE; break;
            default: type = -1; break;
        }

        //now get title and body
        String title, body;
        EditText editText = (EditText) findViewById(R.id.title_of_post);
        title = editText.getText().toString();
        editText = (EditText) findViewById(R.id.body_of_post);
        body = editText.getText().toString();

        //get uni
        Spinner uni_spinner = (Spinner) findViewById(R.id.uni_of_post);
        int uni;
        switch (uni_spinner.getSelectedItem().toString()) {
            case "UNSW": uni = Constant.UNSW; break;
            case "USYD": uni = Constant.USYD; break;
            case "UTS": uni = Constant.UTS; break;
            case "University of Ben": uni = Constant.UNSW; break;
            default: uni = -1; break;
        }
    }
}
