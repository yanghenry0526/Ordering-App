package ntue.cs.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.audiofx.LoudnessEnhancer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import android.widget.Toast;

public class customer extends AppCompatActivity implements View.OnClickListener{
    View view;
    EditText []edt = new EditText[9];
    String []item_amount;
    Button clear , check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        int[] btn_id={R.id.btn1,R.id.btn3,R.id.btn5,R.id.btn7,R.id.btn9,R.id.btn11,R.id.btn13,R.id.btn15,R.id.btn17,R.id.btn2,R.id.btn4,R.id.btn6,R.id.btn8,R.id.btn10,R.id.btn12,R.id.btn14,R.id.btn16,R.id.btn18};
        clear = (Button) findViewById(R.id.btn_clear);
        check = (Button) findViewById(R.id.btn_check);
        clear.setOnClickListener(this);
        check.setOnClickListener(this);
        for (int id:btn_id)        ((Button)findViewById(id)).setOnClickListener(this);

        edt[0] = (EditText)findViewById(R.id.edt1);
        edt[1] = (EditText)findViewById(R.id.edt2);
        edt[2] = (EditText)findViewById(R.id.edt3);
        edt[3] = (EditText)findViewById(R.id.edt4);
        edt[4] = (EditText)findViewById(R.id.edt5);
        edt[5] = (EditText)findViewById(R.id.edt6);
        edt[6] = (EditText)findViewById(R.id.edt7);
        edt[7] = (EditText)findViewById(R.id.edt8);
        edt[8] = (EditText)findViewById(R.id.edt9);


    }

    public void backToHome(View view){
        Intent home =new Intent(customer.this,MainActivity.class);
        startActivity(home);
    }

    @Override
    public void onClick(View view) {
        int temp = 0;
        switch (view.getId()){
            case R.id.btn1:
                plus_oue(edt ,0);
                break;
            case R.id.btn2:
                minus_one(edt , 0);
                break;
            case R.id.btn3:
                plus_oue(edt , 1);
                break;
            case R.id.btn4:
                minus_one(edt , 1);
                break;
            case R.id.btn5:
                plus_oue(edt ,2);
                break;
            case R.id.btn6:
                minus_one(edt , 2);
                break;
            case R.id.btn7:
                plus_oue(edt ,3);
                break;
            case R.id.btn8:
                minus_one(edt , 3);
                break;
            case R.id.btn9:
                plus_oue(edt ,4);
                break;
            case R.id.btn10:
                minus_one(edt , 4);
                break;
            case R.id.btn11:
                plus_oue(edt ,5);
                break;
            case R.id.btn12:
                minus_one(edt , 5);
                break;
            case R.id.btn13:
                plus_oue(edt ,6);
                break;
            case R.id.btn14:
                minus_one(edt , 6);
                break;
            case R.id.btn15:
                plus_oue(edt ,7);
                break;
            case R.id.btn16:
                minus_one(edt , 7);
                break;
            case R.id.btn17:
                plus_oue(edt ,8);
                break;
            case R.id.btn18:
                minus_one(edt , 8);
                break;
            case R.id.btn_clear:
                Clear();
                break;
            case R.id.btn_check:
                Check(view);
                break;
        }
    }

    public void plus_oue(EditText[] edt ,int i){
        int temp = 0;
        temp = Integer.parseInt(edt[i].getText().toString());
        temp += 1;
        edt[i].setText(Integer.toString(temp));
    }

    public void minus_one(EditText[] edt , int i){
        int temp = 0;
        temp = Integer.parseInt(edt[i].getText().toString());
        temp -= 1;
        if(temp == -1 ) {
            Toast.makeText(this,"數量不能小於0" , Toast.LENGTH_SHORT).show();
            return;}
        edt[i].setText(Integer.toString(temp));
    }

    public void Clear(){
        for(int j = 0 ; j < edt.length ; j++){
            edt[j].setText("0");
        }
    }
    public void Check(View view){
        Intent it = new Intent(customer.this , calculator.class);
        Bundle bundle = new Bundle();
        bundle.putString("One",edt[0].getText().toString());
        bundle.putString("Two",edt[1].getText().toString());
        bundle.putString("Three",edt[2].getText().toString());
        bundle.putString("Four",edt[3].getText().toString());
        bundle.putString("Five",edt[4].getText().toString());
        bundle.putString("Six",edt[5].getText().toString());
        bundle.putString("Seven",edt[6].getText().toString());
        bundle.putString("Eight",edt[7].getText().toString());
        bundle.putString("Nine",edt[8].getText().toString());

        it.putExtras(bundle);
        startActivity(it);
    }
}