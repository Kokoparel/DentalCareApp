package com.example.dentalcareapp.app.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.dentalcareapp.app.R;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private TextView scoreText, questionText, timerText;
    private Button option1, option2, option3, option4;
    private ProgressBar progressBar;
    private ImageView gameImage;

    private int score = 0;
    private int currentQuestion = 0;
    private int timeLeft = 10;
    private Handler timerHandler = new Handler();

    private String[][] questions = {
            {"Berapa kali sehari kita harus sikat gigi?", "1 kali", "2 kali", "3 kali", "4 kali", "2"},
            {"Apa nama bakteri penyebab gigi berlubang?", "Salmonella", "E. Coli", "Streptococcus", "Lactobacillus", "3"},
            {"Berapa menit minimal waktu sikat gigi?", "1 menit", "2 menit", "5 menit", "10 menit", "2"},
            {"Kapan waktu terbaik sikat gigi?", "Setelah sarapan", "Sebelum tidur", "Pagi dan malam", "Siang hari", "3"},
            {"Apa manfaat flossing?", "Memutihkan gigi", "Membersihkan sela gigi", "Menguatkan gusi", "Mencegah bau mulut", "2"},
            {"Berapa bulan sekali ganti sikat gigi?", "1 bulan", "3-4 bulan", "6 bulan", "1 tahun", "2"},
            {"Makanan apa yang baik untuk gigi?", "Permen", "Coklat", "Keju", "Soda", "3"},
            {"Kapan pertama kali ke dokter gigi?", "Gigi pertama tumbuh", "Umur 1 tahun", "Umur 3 tahun", "Umur 5 tahun", "1"},
            {"Apa fungsi fluoride pada pasta gigi?", "Memutihkan", "Menguatkan email", "Membersihkan", "Menyegarkan", "2"},
            {"Berapa kali per tahun harus ke dokter gigi?", "1 kali", "2 kali", "3 kali", "4 kali", "2"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Kuis Kesehatan Gigi");

        initViews();
        loadQuestion();
        startTimer();
    }

    private void initViews() {
        scoreText = findViewById(R.id.scoreText);
        questionText = findViewById(R.id.questionText);
        timerText = findViewById(R.id.timerText);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        progressBar = findViewById(R.id.progressBar);
        gameImage = findViewById(R.id.gameImage);

        option1.setOnClickListener(v -> checkAnswer(1));
        option2.setOnClickListener(v -> checkAnswer(2));
        option3.setOnClickListener(v -> checkAnswer(3));
        option4.setOnClickListener(v -> checkAnswer(4));
    }

    private void loadQuestion() {
        if (currentQuestion < questions.length) {
            String[] q = questions[currentQuestion];
            questionText.setText(q[0]);
            option1.setText(q[1]);
            option2.setText(q[2]);
            option3.setText(q[3]);
            option4.setText(q[4]);

            progressBar.setProgress((currentQuestion + 1) * 10);
            timeLeft = 10;

            enableOptions(true);
        } else {
            showFinalScore();
        }
    }

    private void startTimer() {
        timerHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (timeLeft > 0 && currentQuestion < questions.length) {
                    timeLeft--;
                    timerText.setText("⏱ " + timeLeft + "s");
                    startTimer();
                } else if (timeLeft == 0) {
                    Toast.makeText(GameActivity.this, "Waktu habis!", Toast.LENGTH_SHORT).show();
                    nextQuestion();
                }
            }
        }, 1000);
    }

    private void checkAnswer(int selectedOption) {
        timerHandler.removeCallbacksAndMessages(null);

        String correctAnswer = questions[currentQuestion][5];
        enableOptions(false);

        if (String.valueOf(selectedOption).equals(correctAnswer)) {
            score += 10;
            scoreText.setText("Skor: " + score);
            Toast.makeText(this, "Benar! +10 poin", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Salah! Jawaban yang benar: " +
                            questions[currentQuestion][Integer.parseInt(correctAnswer)],
                    Toast.LENGTH_LONG).show();
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                nextQuestion();
            }
        }, 2000);
    }

    private void nextQuestion() {
        currentQuestion++;
        loadQuestion();
        if (currentQuestion < questions.length) {
            startTimer();
        }
    }

    private void enableOptions(boolean enable) {
        option1.setEnabled(enable);
        option2.setEnabled(enable);
        option3.setEnabled(enable);
        option4.setEnabled(enable);
    }

    private void showFinalScore() {
        timerHandler.removeCallbacksAndMessages(null);

        String message;
        if (score >= 80) {
            message = "Luar biasa! 🎉\nAnda sangat memahami kesehatan gigi!";
        } else if (score >= 60) {
            message = "Bagus! 👍\nTerus belajar tentang kesehatan gigi!";
        } else {
            message = "Tetap semangat! 💪\nYuk pelajari lebih banyak!";
        }

        Toast.makeText(this,
                "Kuis selesai!\nSkor akhir: " + score + "/100\n" + message,
                Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 3000);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timerHandler.removeCallbacksAndMessages(null);
    }
}