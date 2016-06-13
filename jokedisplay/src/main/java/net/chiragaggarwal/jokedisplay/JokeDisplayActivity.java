package net.chiragaggarwal.jokedisplay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import net.chiragaggarwal.jokesrepository.Jokes;

public class JokeDisplayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        String joke = getIntent().getStringExtra(Jokes.TAG);
        TextView textJoke = (TextView) findViewById(R.id.text_joke);
        textJoke.setText(joke);
        setupToolbar();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar() {
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setElevation(0);
        supportActionBar.setTitle("");
    }
}
