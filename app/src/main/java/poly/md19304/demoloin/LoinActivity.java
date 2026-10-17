package poly.md19304.demoloin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoinActivity extends AppCompatActivity {
    Button btnRegister , btnLoin;
    EditText editGmail , edPasss;
    private FirebaseAuth ath;

    String gmail;
    String edPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loin);
        btnRegister = (Button) findViewById(R.id.butsig);
        btnLoin = (Button) findViewById(R.id.bitGmail);
        editGmail = (EditText) findViewById(R.id.edGmail);
        edPasss = (EditText) findViewById(R.id.edpass);
        ath = FirebaseAuth.getInstance();
//        String gmail = editGmail.getText().toString();
//        String edpass = edPasss.getText().toString();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoinActivity.this, LoinActivity2.class);
                startActivity(intent);
            }
        });
        btnLoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gmail = editGmail.getText().toString();
                edPass = edPasss.getText().toString();
                ath.signInWithEmailAndPassword(gmail , edPass).addOnCompleteListener(LoinActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Dang nhap thanh cong",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getApplicationContext(), "Dang nhap khong thang cong", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}