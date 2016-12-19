package artbit.com.artbit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by JoenSeonHee on 2016-12-19.
 */

public class MainActivity extends AppCompatActivity {
    private EditText idInput;
    private EditText passwordInput;

    private Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idInput = (EditText) findViewById(R.id.id_input);
        passwordInput = (EditText) findViewById(R.id.password_input);
        loginButton = (Button) findViewById(R.id.login_button);

        loginButton.setOnClickListener(new LoginButtonListener());

    }

    private class LoginButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            //E-mail 가져오기
            String email = idInput.getText().toString();

            //password 가져오기
            String password = passwordInput.getText().toString();

            //서버와 비교

            //결과를 가져온다.
        }
    }

}
