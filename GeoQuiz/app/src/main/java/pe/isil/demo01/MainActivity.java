package pe.isil.demo01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btYes, btNo, btPrevious, btNext, btScore;
    private TextView tvSentence;

    private ArrayList<Question> questions;

    private int actualPosition, score;

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
            intent.putExtra("score", score);
            startActivity(intent);
        });

    }

    private void loadQuestions() {

        questions = new ArrayList<>();
        actualPosition = 0;
        score = 0;

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
        setContentView(R.layout.activity_main);

        initViews();
        initViewListeners();
        loadQuestions();
        showActualQuestion();

    }


}