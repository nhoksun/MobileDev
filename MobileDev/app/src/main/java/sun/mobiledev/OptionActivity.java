package sun.mobiledev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class OptionActivity extends Activity {

    // tạo 2 biến private chứa index màu mà user chọn
    private int index1=0, index2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                index1 = position;
                // lấy index mà user đã chọn.
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                index2 = position;
                // Lấy index mà user đã chọn.
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void onOK(View view) {
        // gởi dữ liệu về activity trước
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("ForeColor", index1); // lấy giá trị màu text
        bundle.putInt("BackColor", index2); // lấy giá trị màu nền
        intent.putExtras(bundle); // gởi kèm dữ liệu
        setResult(RESULT_OK, intent); // gởi kết quả về
        finish(); // đóng activity
    }

}
