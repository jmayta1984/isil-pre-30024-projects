package pe.isil.demo01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    private TextView tvScore;

    private void initViews() {
        tvScore = findViewById(R.id.tvScore);
    }

    private void showScore() {
        Intent intent = getIntent();
        int score = intent.getIntExtra("score",0);
        tvScore.setText(String.valueOf(score));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        initViews();
        showScore();

    }
}