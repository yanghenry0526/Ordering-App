package ntue.cs.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class seller extends AppCompatActivity  {
    SQLiteDatabase db;
    Cursor c;
    static final String db_name = "MaiWo_DB";
    static final String tb_name = "MaiWo";


    int sum = 0;
    TextView result , money;
    String []amount = new String[9];
    String []Price = new String[10];

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);
        result = (TextView) findViewById(R.id.order);
        money = (TextView) findViewById(R.id.money);
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

        //開啟資料庫
        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE , null);
        String createTable = " CREATE TABLE IF NOT EXISTS " + tb_name +"(id INTEGER PRIMARY KEY AUTOINCREMENT,"+"dessert VARCHAR(32),"+ "amount VARCAHR(16)," + "dollar VARCAHR(16))";
        db.execSQL(createTable); //建立資料表

        //新增資料
        c = db.rawQuery(" SELECT * FROM " + tb_name , null);
        if(c.getCount() == 0){
            addData("巧克力戚風蛋糕" , amount[0], Price[0]);
            addData("起司戚風蛋糕" , amount[1], Price[1]);
            addData("原味戚風蛋糕" , amount[2], Price[2]);
            addData("提拉米蘇" , amount[3], Price[3]);
            addData("巴斯克" , amount[4],Price[4]);
            addData("檸檬塔" , amount[5], Price[5]);
            addData("巧克力塔" , amount[6], Price[6]);
            addData("聖多諾黑" , amount[7], Price[7]);
            addData("肉桂捲" , amount[8], Price[8]);
        }
        else{       //更新資料庫
            for(int i = 0; i<8 ; i++){
                update(amount[i] ,  Price[i], i+1);
            }
        }

        //印出資料庫
        c = db.rawQuery(" SELECT * FROM " + tb_name , null);
        String str = "";
        if(c.moveToFirst()) {
            do{
                str += "Dessert : " + c.getString(1) + "\n";
                str += "Amount :" + c.getString(2) + "\n";
                str += "Dollor :" + c.getString(3) + "\n";

                sum += Integer.parseInt(c.getString(3));    //計算總金額

            }while (c.moveToNext());
            result.setText(str);
        }
        money.setText("您的金額是 : " + sum);
    }

    private void addData(String dessert , String amount , String dollar){
        ContentValues cv = new ContentValues(3);
        cv.put("dessert" , dessert);
        cv.put("amount" , amount);
        cv.put("dollar" , dollar);

        db.insert(tb_name , null , cv);     //將資料加到資料表
    }
    private void update(String amount,String dollar, int id) {
        ContentValues cv=new ContentValues(2);

        cv.put("amount" , amount);
        cv.put("dollar" , dollar);

        db.update(tb_name, cv, "id="+id, null);
    }
    public void backTo(View view){
        Intent it =new Intent(seller.this,MainActivity.class);
        startActivity(it);
    }
}
