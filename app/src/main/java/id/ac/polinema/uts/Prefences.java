package id.ac.polinema.uts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Prefences extends AppCompatActivity {
    SessionManagement s;
    TextView tvEmail;
    Button buttonLogout;
    HashMap<String,String> loginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prefences);

        tvEmail = findViewById(R.id.tvEmail);
        buttonLogout = findViewById(R.id.btnInsert);

        s = new SessionManagement(this);
        loginUser = s.getUserInformation();

        Toast.makeText(this, s.isLoggedIn()+"",Toast.LENGTH_LONG).show();

        tvEmail.setText(loginUser.get(SessionManagement.KEY_EMAIL));
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //s.logoutUser();
                goToActivity();
            }
        });
    }
    private void goToActivity() {
        Intent mIntent = new Intent(getApplicationContext(),InputKota.class);
        startActivity(mIntent);
    }
}
