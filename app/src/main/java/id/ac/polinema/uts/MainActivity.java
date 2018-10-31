package id.ac.polinema.uts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText edtEmail, edtPassword;
    Button buttonLogin;
    Context mContext;
    SessionManagement s;
    HashMap<String,String> loginUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail     = findViewById(R.id.editEmail);
        edtPassword  = findViewById(R.id.editPassword);
        buttonLogin  = findViewById(R.id.buttonLogin);

        //final SessionManagement s = new SessionManagement(this);
        s = new SessionManagement(this);

        if(s.isLoggedIn()){
            goToActivity();
        }
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                if(email.matches("")||email.trim().isEmpty()||password.matches("")||password.trim().isEmpty()){
                    Toast.makeText(MainActivity.this,"Email dan Password Tidak Boleh Kosong / spasi",Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    s.createLoginSession(edtEmail.getText().toString(), edtPassword.getText().toString());
                    goToActivity();
                }
            }
        });
    }

    private void goToActivity() {
        Intent mIntent = new Intent(getApplicationContext(),Prefences.class);
        startActivity(mIntent);
    }
}
