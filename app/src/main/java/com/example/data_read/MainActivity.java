package com.example.data_read;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView lv;
    private ArrayList<Student> studentlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentlist = new ArrayList<>();
        SQLdm s = new SQLdm();
        SQLiteDatabase db = s.openDatabase(getApplicationContext());
        Cursor cursor = db.rawQuery("select * from otp_info",null);
        while(cursor.moveToNext()){


            String otp_id = cursor.getString(cursor.getColumnIndex("otp_id"));
             String mobile = cursor.getString(cursor.getColumnIndex("mobile"));
            String otp = cursor.getString(cursor.getColumnIndex("otp"));

            String status = cursor.getString(cursor.getColumnIndex("status"));
        /*    String reference = cursor.getString(cursor.getColumnIndex("reference"));
            String date = cursor.getString(cursor.getColumnIndex("date"));*/






 // 5 data pass

   //  Student st = new Student(otp_id,mobile,otp,status,reference,date);


     // 4 data pass
     Student st = new Student(otp_id,mobile,otp,status);

     // 3 data pass

        // Student st = new Student(otp_id,mobile,otp);

            studentlist.add(st);
        }
        lv = (ListView)findViewById(R.id.student_lv);
        lv.setAdapter(new BaseAdapter() {

            @Override
            public int getCount() {
                return studentlist.size();
            }

            @Override
            public Object getItem(int position) {
             //return studentlist.get(position);
               return null;
            }

            @Override
            public long getItemId(int position) {

                 //return position;
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {


                View view ;

                if(convertView == null )
                {
                    LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                    view = inflater.inflate(R.layout.item,null);
                    //view = View.inflate(getBaseContext(),R.layout.item,null);
                }
                else
                {
                    view = convertView;
                }



                //Remove a row of data from the studentlist, position is equivalent to the array subscript, you can get the data row by row

                //TextView name = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null).findViewById(R.id.stu_name);
                //TextView xuehao = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null).findViewById(R.id.stu_number);
                //TextView Class = (TextView) LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null).findViewById(R.id.stu_age);


                Student st = studentlist.get(position);

                TextView id,mobile,otp,status,reference,date;

                id = (TextView)view.findViewById(R.id.otp_id);
                mobile  = (TextView)view.findViewById(R.id.mobile_id);
                otp  = (TextView)view.findViewById(R.id.otpcode_id);
               status  = (TextView)view.findViewById(R.id.status_id);
/*               reference  = (TextView)view.findViewById(R.id.reference_id);
                date  = (TextView)view.findViewById(R.id.dateid);*/


              id.setText(st.getOtp_id());
              mobile.setText(st.getMobile());
              otp.setText(st.getOtp());
              status.setText(st.getStatus());
            /*  reference.setText(st.getReference());
              date.setText(st.getDate());*/

                return view;
            }
        });
    }



}