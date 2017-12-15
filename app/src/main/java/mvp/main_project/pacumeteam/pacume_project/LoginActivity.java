package mvp.main_project.pacumeteam.pacume_project;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private AlertDialog mDialogNoLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEtUsername = (EditText)findViewById(R.id.etUserName);
        mEtPassword = (EditText)findViewById(R.id.etPassword);
        mBtnLogin = (Button) findViewById(R.id.btnLogin);

        mDialogNoLogin = new AlertDialog.Builder(LoginActivity.this, R.style.Theme_AppCompat_Dialog_Alert).create();
        mDialogNoLogin.setButton(AlertDialog.BUTTON_NEGATIVE, "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        cleanDataLogin();
                    }
                });
        mDialogNoLogin.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                cleanDataLogin();
            }
        });

        mEtUsername.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mEtUsername.setFocusableInTouchMode(true);
                return false;
            }
        });

        mEtPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mEtPassword.setFocusableInTouchMode(true);
                return false;
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEtUsername.getText().toString().equals("") ||
                        mEtUsername.getText().toString().trim().isEmpty()) {

                    Snackbar snackbar = Snackbar.make(view, "Insira o seu usuário", Snackbar.LENGTH_SHORT);
                    snackbar.show();

                } else if (mEtPassword.getText().toString().equals("") ||
                        mEtPassword.getText().toString().trim().isEmpty()) {

                    Snackbar snackbar = Snackbar.make(view, "Insira sua senha", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                } else if (mEtUsername.getText().toString().equals("pacume") && mEtPassword.getText().toString().equals("pacume")) {
                    Snackbar snackbar = Snackbar.make(view, "Login Realizado com Sucesso", Snackbar.LENGTH_SHORT);
                    cleanDataLogin();
                    snackbar.show();
                    // Start Establishment Activity (for now)
                    Intent intent = new Intent(getApplication(), Trending.class);
                    startActivity(intent);
                } else {
                    mDialogNoLogin.setMessage("Falha ao efetuar login");
                    mDialogNoLogin.show();
                }

            }
        });

    }

    private void cleanDataLogin() {
        mEtPassword.setText(null);
        mDialogNoLogin.dismiss();
        mEtUsername.setFocusable(false);
        mEtPassword.setFocusable(false);
    }
}