package ntue.cs.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String []amount = new String[9];
    String []Price = new String[10];

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        Button customer=(Button)findViewById(R.id.customer_b);
        Button seller = (Button)findViewById(R.id.seller_b);

        customer.setOnClickListener(this);
        seller.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.customer_b) {
            Intent customer =new Intent(MainActivity.this,customer.class);
            startActivity(customer);
        }else if(view.getId()==R.id.seller_b){
            Intent seller =new Intent(MainActivity.this,logIn.class);
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
            seller.putExtras(bundle);
            startActivity(seller);
        }
    }
}