package sun.mobiledev;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Lab1SecondActivity extends Activity {

    private Spinner     Spinner_Calculation;
    private EditText    EditText_NumberFirst;
    private EditText    EditText_NumberSecond;
    private TextView    TextView_Result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_second);
    }
    public void showMe(View view){
        String msg;
        // Lấy tham chiếu đến EditText
        EditText edt= (EditText)findViewById(R.id.edtTen);
        msg = "Xin Chào " + edt.getText().toString();
        // Hiển thị massage box (Toast)
        Toast.makeText(getApplication(),msg,Toast.LENGTH_SHORT).show();
    }


    public void calculation(View view) {
        EditText_NumberFirst     = (EditText)findViewById(R.id.edt_Number_1);
        EditText_NumberSecond    = (EditText)findViewById(R.id.edt_Number_2);
        Spinner_Calculation = (Spinner)findViewById(R.id.spn_PhepToan);
        TextView_Result = (TextView)findViewById(R.id.tv_ket_qua);
        int Spinner_Position = Spinner_Calculation.getSelectedItemPosition();
        float F_Result = 0;
        switch (Spinner_Position){
                    case 0 :
                        F_Result=summation();
                        break;
                    case 1 :
                        F_Result=subtraction();
                        break;
                    case 2 :
                        F_Result=multiplication();
                        break;
                    default:
                        F_Result=division();
                        break;
                }
        TextView_Result.setText(F_Result+"");
    }

    public float summation(){
        float result = Float.parseFloat(EditText_NumberFirst.getText().toString())  + Float.parseFloat(EditText_NumberSecond.getText().toString());
        return result;
    }

    public float subtraction(){
        float result = Float.parseFloat(EditText_NumberFirst.getText().toString()) - Float.parseFloat(EditText_NumberSecond.getText().toString());
        return result;
    }

    public float division(){
        float result = Float.parseFloat(EditText_NumberFirst.getText().toString())  / Float.parseFloat(EditText_NumberSecond.getText().toString());
        return result;
    }

    public float multiplication(){
        float result = Float.parseFloat(EditText_NumberFirst.getText().toString())  * Float.parseFloat(EditText_NumberSecond.getText().toString());
        return result;
    }
}
