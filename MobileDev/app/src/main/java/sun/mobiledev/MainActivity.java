package sun.mobiledev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.lab1,R.id.lab2,R.id.lab3,R.id.lab4,R.id.lab5,R.id.lab6,R.id.lab7,R.id.lab8})
    public void doOnClick (View v){
        switch (v.getId()){
            case R.id.lab1:
                showToast("Bài Lab 1");
                gotoLab1(v);
                break;
            case R.id.lab2:
                showToast("Bài Lab 2");
                gotoLab2(v);
                break;
            case R.id.lab3:
                showToast("Bài Lab 3");
                break;
            case R.id.lab4:
                showToast("Bài Lab 4");
                break;
            case R.id.lab5:
                showToast("Bài Lab 5");
                break;
            case R.id.lab6:
                showToast("Bài Lab 6");
                break;
            case R.id.lab7:
                showToast("Bài Lab 7");
                break;
            case R.id.lab8:
                showToast("Bài Lab 8");
                break;
            default:
                break;
        }
    }

    private void showToast(String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    public void gotoLab1(View view){
        Intent intentlab1 = new Intent(MainActivity.this,Lab1Activity.class);
        startActivity(intentlab1);
    }

    public void gotoLab2(View view){
        Intent intentlab2 = new Intent(MainActivity.this,Lab2Activity.class);
        startActivity(intentlab2);
    }

    public void gotoLab3(View view){
        Intent intentlab3 = new Intent(MainActivity.this,Lab1Activity.class);
        startActivity(intentlab3);
    }

}
