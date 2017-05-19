package sun.mobiledev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class Lab1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
    }
    public void gotoSecondActivity(View view){
        Intent secondIntent = new Intent(this,Lab1SecondActivity.class);
        startActivity(secondIntent);
    }
}
