package ntue.cs.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener {
    private Button cler,comfirm;
    private EditText userid,userpasswd;
    String []amount = new String[9];
    String []Price = new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userid=(EditText)findViewById(R.id.userid);
        userpasswd=(EditText)findViewById(R.id.userpasswd);
        comfirm=(Button)findViewById(R.id.comfirm);
        cler=(Button)findViewById(R.id.cler);

        comfirm.setOnClickListener(this);
        cler.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.comfirm) {
            //新增一個sharedpreference
            SharedPreferences sharedPreferences =getSharedPreferences("data",MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            //存入資料
            editor.putString("id",userid.getText().toString());
            editor.putString("password",userpasswd.getText().toString());
            editor.apply();

            String str =userid.getText().toString();
            String str1 =userpasswd.getText().toString();
            //判斷輸入的值是否為空值
            if (TextUtils.isEmpty(str)) {
                Toast.makeText(Register.this, "帳號不能為空",Toast.LENGTH_SHORT).show();
            }else if (TextUtils.isEmpty(str1)) {
                Toast.makeText(Register.this, "密碼不能為空", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(Register.this,"註冊成功!",Toast.LENGTH_SHORT).show();
                Intent intent1=new Intent(Register.this,logIn.class);
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
                intent1.putExtras(bundle);
                startActivity(intent1);
            }
        } else if (v.getId()==R.id.cler){
            userid.setText("");
            userpasswd.setText("");
        } else {
            Toast.makeText(Register.this, "Error !!!", Toast.LENGTH_SHORT).show();
        }
    }
}