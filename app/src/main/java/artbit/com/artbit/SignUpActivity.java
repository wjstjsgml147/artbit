package artbit.com.artbit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by JoenSeonHee on 2016-12-20.
 */

public class SignUpActivity extends AppCompatActivity {
    private EditText nameInput;
    private  EditText emailInput;
    private EditText password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //보여줄 화면을 결정하는 함수
        setContentView(R.layout.activity_signup);

        nameInput = (EditText) findViewById(R.id.name);
        emailInput = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);




    }
}
