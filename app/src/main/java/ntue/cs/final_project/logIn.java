package ntue.cs.final_project;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class logIn extends AppCompatActivity implements View.OnClickListener {

    private EditText useraccount,userpassword;
    private Button userregister,signin;
    String []amount = new String[9];
    String []Price = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        useraccount=(EditText)findViewById(R.id.useraccount);
        userpassword=(EditText)findViewById(R.id.userpassword);
        userregister=(Button)findViewById(R.id.userregister);
        signin=(Button)findViewById(R.id.signin);

        userregister.setOnClickListener(this);
        signin.setOnClickListener(this);

        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null){
            amount[0] = bundle.getString("One");
            amount[1] = bundle.getString("Two");
            amount[2] = bundle.getString("Three");
            amount[3] = bundle.getString("Four");
            amount[4] = bundle.getString("Five");
            amount[5] = bundle.getString("Six");
            amount[6] = bundle.getString("Seven");
            amount[7] = bundle.getString("Eight");
            amount[8] = bundle.getString("Nine");

            Price[0] = bundle.getString("One_P");
            Price[1] = bundle.getString("Two_P");
            Price[2] = bundle.getString("Three_P");
            Price[3] = bundle.getString("Four_P");
            Price[4] = bundle.getString("Five_P");
            Price[5] = bundle.getString("Six_P");
            Price[6] = bundle.getString("Seven_P");
            Price[7] = bundle.getString("Eight_P");
            Price[8] = bundle.getString("Nine_P");
            Price[9] = bundle.getString("Total");
        }

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.userregister) {
            Intent main =new Intent(logIn.this,Register.class);
            Bundle bundle = new Bundle();
            bundle.putString("One",amount[0]);
            bundle.putString("Two",amount[1]);
            bundle.putString("Three",amount[2]);
            bundle.putString("Four",amount[3]);
            bundle.putString("Five",amount[4]);
            bundle.putString("Six",amount[5]);
            bundle.putString("Seven",amount[6]);
            bundle.putString("Eight",amount[7]);
            bundle.putString("Nine",amount[8]);

            bundle.putString("One_P",Price[0]);
            bundle.putString("Two_P",Price[1]);
            bundle.putString("Three_P",Price[2]);
            bundle.putString("Four_P",Price[3]);
            bundle.putString("Five_P",Price[4]);
            bundle.putString("Six_P",Price[5]);
            bundle.putString("Seven_P",Price[6]);
            bundle.putString("Eight_P",Price[7]);
            bundle.putString("Nine_P",Price[8]);
            bundle.putString("Total",Price[9]);
            main.putExtras(bundle);
            startActivity(main);
        } else if (v.getId()==R.id.signin){
            String userid=useraccount.getText().toString();
            String userpasswd=userpassword.getText().toString();
            //取得sharedpreference
            SharedPreferences preference=getSharedPreferences("data",MODE_PRIVATE);
            //判斷登入畫面輸入的帳號密碼是否跟註冊的帳號密碼一樣
            if (userid.equals(preference.getString("id","")) && userpasswd.equals(preference.getString("password",""))){
                SharedPreferences.Editor edit =preference.edit();
                edit.apply();
                //是的話顯示成功登入
                Intent it =new Intent(logIn.this,seller.class);    //跳轉道Transfer
                Bundle bundle = new Bundle();
                bundle.putString("One",amount[0]);
                bundle.putString("Two",amount[1]);
                bundle.putString("Three",amount[2]);
                bundle.putString("Four",amount[3]);
                bundle.putString("Five",amount[4]);
                bundle.putString("Six",amount[5]);
                bundle.putString("Seven",amount[6]);
                bundle.putString("Eight",amount[7]);
                bundle.putString("Nine",amount[8]);

                bundle.putString("One_P",Price[0]);
                bundle.putString("Two_P",Price[1]);
                bundle.putString("Three_P",Price[2]);
                bundle.putString("Four_P",Price[3]);
                bundle.putString("Five_P",Price[4]);
                bundle.putString("Six_P",Price[5]);
                bundle.putString("Seven_P",Price[6]);
                bundle.putString("Eight_P",Price[7]);
                bundle.putString("Nine_P",Price[8]);
                bundle.putString("Total",Price[9]);
                Toast.makeText(logIn.this,"成功登入",Toast.LENGTH_SHORT).show();
                it.putExtras(bundle);
                startActivity(it);
            } else {
                //不是則顯示登入失敗
                Toast.makeText(logIn.this,"登入失敗",Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(logIn.this, "Error !!!", Toast.LENGTH_SHORT).show();
        }
    }
}