package pe.isil.demo01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btYes, btNo, btPrevious, btNext, btScore;
    private TextView tvSentence;

    private ArrayList<Question> questions;

    private int actualPosition = 0, score = 0;

    private static final String TAG = "MainActivity";

    private static final String KEY_ACTUAL_POSITION = "actual_position";

    private static final String KEY_SCORE = "score";


    private void initViews() {
        btYes = findViewById(R.id.btYes);
        btNo = findViewById(R.id.btNo);
        btNext = findViewById(R.id.btNext);
        btPrevious = findViewById(R.id.btPrevious);
        btScore = findViewById(R.id.btScore);
        tvSentence = findViewById(R.id.tvSentence);
    }

    private void initViewListeners() {
        btYes.setOnClickListener(view -> verifyResponse(true));
        btNo.setOnClickListener(view -> verifyResponse(false));

        btNext.setOnClickListener(view -> {
            actualPosition += 1;
            showActualQuestion();
        });

        btPrevious.setOnClickListener(view -> {
            actualPosition -= 1;
            showActualQuestion();
        });


        btScore.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ScoreActivity.class);
            intent.putExtra(KEY_SCORE, score);
            startActivity(intent);
        });

    }

    private void loadQuestions() {

        questions = new ArrayList<>();

        Question questionPeru = new Question("La capital de Perú es Lima", true);
        questions.add(questionPeru);

        Question questionChile = new Question("La capital de Chile es Caracas", false);
        questions.add(questionChile);

        Question questionArgentina = new Question("La capital de Argentina es Buenos Aires", true);
        questions.add(questionArgentina);
    }

    private void showActualQuestion() {

        if (actualPosition == questions.size()) {
            actualPosition = 0;
        } else {

            if (actualPosition == -1) {
                actualPosition = questions.size() - 1;
            }
        }

        tvSentence.setText(questions.get(actualPosition).getSentence());
    }

    private void verifyResponse(Boolean option) {

        if (questions.get(actualPosition).isVerified()) {
            Toast.makeText(this, "Pregunta ya contestada", Toast.LENGTH_SHORT).show();
            return;
        }

        if (questions.get(actualPosition).isResponse() == option) {
            Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show();
            score += 5;
        } else {
            Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show();
            score -= 2;
        }

        questions.get(actualPosition).setVerified(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called");

        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            actualPosition = savedInstanceState.getInt(KEY_ACTUAL_POSITION, 0);
            score = savedInstanceState.getInt(KEY_SCORE, 0);
        }


        initViews();
        initViewListeners();
        loadQuestions();
        showActualQuestion();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState() called");
        outState.putInt(KEY_ACTUAL_POSITION, actualPosition);
        outState.putInt(KEY_SCORE, score);
    }
}