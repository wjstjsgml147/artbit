package artbit.com.artbit;

import android.os.Handler;
import android.os.Message;

import com.google.gson.JsonObject;

import artbit.com.artbit.util.SqlConnector;

/**
 * Created by JoenSeonHee on 2016-12-20.
 */

public class LoginThread extends Thread {

    private Handler handler;
    private String email;
    private String password;

    public LoginThread(Handler handler, String email, String password) {
        this.handler = handler;
        this.email = email;
        this.password = password;
    }

    @Override
    public void run() {
        super.run();
        // Json Object 만들기  >> {email :  , password :    }
        JsonObject object = new JsonObject();
        object.addProperty("email", email);
        object.addProperty("password", password);

        String response = SqlConnector.getInstance().post("http://203.255.81.47/login2.php", object.toString());

        //핸들러를 통해서 메세지를 전달
        if (response.equals("True")) handler.sendEmptyMessage(1);
        else handler.sendEmptyMessage(0);

    }
}
