package pe.isil.camerasample;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private Button btCamera;

    private ActivityResultLauncher<Intent> launcher;

    private File imageFile;

    private void registerLauncher() {
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        if (imageFile.exists()) {
                            Toast.makeText(MainActivity.this, "File has been save in" + imageFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Error saving file", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void initViews() {
        btCamera = findViewById(R.id.btCamera);
    }

    private void initViewListeners() {
        btCamera.setOnClickListener(view -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            imageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "test.jpg");
            Uri uri = FileProvider.getUriForFile(MainActivity.this, "pe.isil.camerasample.provider", imageFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
            launcher.launch(intent);
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerLauncher();
        initViews();
        initViewListeners();
    }
}