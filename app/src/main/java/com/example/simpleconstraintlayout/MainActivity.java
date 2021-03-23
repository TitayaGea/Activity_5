package com.example.simpleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan passoword
    String nama;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    String password;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar) {
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);

        }
        return super.onOptionsItemSelected(item);
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada Layout
        btnLogin=findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan componen button pada Layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada Layout
        edpassword=findViewById(R.id.edPassword);


        //membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //menyimpan input user di edittext email keddalam variabel nama
                nama= edemail.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //menegeset email yang benar
                String email = "admin@mail.com";

                //mengeset password yang benar
                String pass = "321";

                //mengecek apakah isi dari email dann password sudah sama dengan email dan
                //password yang sudah diset
                if (nama.equals("admin@mail.com") && password.equals("321")){
                    //membuat variabel toast dan menampilan pesan " Login sukses"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "login sukses",Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();

                } else if (!nama.equals("admin@mail.com") && password.equals("321")) {
                    //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                    Toast t = Toast.makeText(getApplicationContext(),
                            "email salah", Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();

                    //membuat objek bundle
                    Bundle b = new Bundle();
                    //memasukkan value dari variabel nama dengan kunci "a"
                    //dan dimasukkan kedalam bundle
                    b.putString("a", nama.trim());

                    //memasukkan value dari variabel password dengan kunci "b"
                    //dan dimasukkan kedalam bundle
                    b.putString("b", password.trim());

                    //membuat objek intent berpindah activity dari mainactivity ke activity hasil
                    Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                    //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityHAsil
                    i.putExtras(b);

                    //berpindah ke ActivityHasil
                    startActivity(i);






                } else {
                    //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Gagal",Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();

                }




            }
        });






    }
}
