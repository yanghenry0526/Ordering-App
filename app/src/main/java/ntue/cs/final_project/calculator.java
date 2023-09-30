package ntue.cs.final_project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class calculator extends AppCompatActivity {
    TextView[]txv = new TextView[10];
    String []amount = new String[9];
    String []Price = new String[10];
    TextView result , total;
    String total_amount = "";
    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        txv[0] = (TextView) findViewById(R.id.txv1);
        txv[1] = (TextView) findViewById(R.id.txv2);
        txv[2] = (TextView) findViewById(R.id.txv3);
        txv[3] = (TextView) findViewById(R.id.txv4);
        txv[4] = (TextView) findViewById(R.id.txv5);
        txv[5] = (TextView) findViewById(R.id.txv6);
        txv[6] = (TextView) findViewById(R.id.txv7);
        txv[7] = (TextView) findViewById(R.id.txv8);
        txv[8] = (TextView) findViewById(R.id.txv9);
        txv[9] = (TextView) findViewById(R.id.txv10);


        //讀取商品數量
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

            add(txv ,"巧克力戚風蛋糕" , amount, Integer.toString(Integer.parseInt(amount[0])*120) , 0);
            add(txv ,"起司戚風蛋糕" , amount, Integer.toString(Integer.parseInt(amount[1])*120) , 1);
            add(txv ,"原味戚風蛋糕" , amount, Integer.toString(Integer.parseInt(amount[2])*120) , 2);
            add(txv ,"提拉米蘇" , amount, Integer.toString(Integer.parseInt(amount[3])*150) , 3);
            add(txv ,"巴斯克" , amount, Integer.toString(Integer.parseInt(amount[4])*150) , 4);
            add(txv ,"檸檬塔" , amount, Integer.toString(Integer.parseInt(amount[5])*150) , 5);
            add(txv ,"巧克力塔" , amount, Integer.toString(Integer.parseInt(amount[6])*150) , 6);
            add(txv ,"聖多諾黑" , amount, Integer.toString(Integer.parseInt(amount[7])*180) , 7);
            add(txv ,"肉桂捲" , amount, Integer.toString(Integer.parseInt(amount[8])*180) , 8);

            txv[9].setText("總金額是 : "+Integer.toString(sum));
            Price[9] = Integer.toString(sum);

        }
    }

    public void add(TextView[] txv , String dessert , String[] amount , String price , int i){
        txv[i].setText(dessert + " 數量 : " + amount[i] + " 價錢 : " + price);
        sum += Integer.parseInt(price);
        Price[i] = price;
    }
    public void backTo(View view){
        Intent it =new Intent(calculator.this,customer.class);
        startActivity(it);
    }


    public void order(View view){
        Intent it =new Intent(calculator.this,MainActivity.class);
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


        Toast.makeText(calculator.this,"已送出訂單",Toast.LENGTH_SHORT).show();
        it.putExtras(bundle);
        startActivity(it);
    }
}