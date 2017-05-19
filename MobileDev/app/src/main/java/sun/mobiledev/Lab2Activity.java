package sun.mobiledev;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Lab2Activity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.clear:
//                    return true;
//                case R.id.setting:
//                    return true;
//                case R.id.exit:
//                    return true;
//            }
//            return false;
//        }

//    };

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        super.onCreateOptionsMenu(menu);
        // Lấy menu ngữ cảnh của ứng dụng
        MenuInflater menuInflater_lab2 = getMenuInflater();
        // Thiết lập Menu
        menuInflater_lab2.inflate(R.menu.menu_lab2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.clear:
                // Xử lý Xóa ở đây
                AlertDialog.Builder message = new AlertDialog.Builder(this);
                message.setTitle(R.string.message_caption);
                message.setMessage(R.string.message_content);
                message.setNeutralButton(R.string.close, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText et = (EditText)findViewById(R.id.edit_text_lab2);
                                et.setText(""); // xoá nội dung edittext
                            }
                        }).show();

                break;
            case R.id.setting:
                // Xử lý Setting ở đây
                Intent intent = new Intent(this,OptionActivity.class);
                final int result=1;
                // khởi tạo activity có lấy kết quả về
                startActivityForResult(intent, result);
                break;
            case R.id.exit:
                // Xử lý Exit ở đây
                // thoát ứng dụng
//                new AlertDialog.Builder(this)
//                        .setTitle(R.string.exit_caption)
//                        .setMessage(R.string.exit_content)
//                        .setNegativeButton(R.string.yes, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                            //thoát khỏi ứng dụng
//                                finish();
//                            }
//                        })
//                        .setPositiveButton(R.string.no, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
////                             TODO Auto-generated method stub
//                            return;
//                        }
//                        })
//                        .show();
//                finish();
//                break;
                final Dialog dialog = new Dialog(Lab2Activity.this);
                dialog.setCancelable(false);
                dialog.setTitle(R.string.exit_caption);
                dialog.setContentView(R.layout.dialog);
                Button btnYes = (Button) dialog.findViewById(R.id.exit_yes);
                Button btnNo = (Button) dialog.findViewById(R.id.exit_no);

                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Thoát Lab2
                        Toast.makeText(getApplication(),"Đã thoát Lab2",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Do Nothings
                        dialog.dismiss();
                        return;
                    }
                });
                dialog.show();

        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // lấy Bundle dữ liệu
        Bundle bundle = data.getExtras();
        int index1 = bundle.getInt("ForeColor");
        int index2 = bundle.getInt("BackColor");
//        Toast.makeText(this.getApplication(),""+index1+"        "+index2,Toast.LENGTH_SHORT).show();
        // lấy mảng màu
        String colorArray[] = getResources().getStringArray(R.array.color_array);
        Toast.makeText(this.getApplication(),"Text: "+colorArray[index1]+"        Back: "+colorArray[index2],Toast.LENGTH_SHORT).show();
        // tham chiếu đến editText
        EditText et = (EditText)findViewById(R.id.edit_text_lab2);
        // thiết lập màu
        et.setTextColor(Color.parseColor(colorArray[index1]));
//        et.setTextColor(ContextCompat.getColor(this,R.color.yellow));
        et.setBackgroundColor(Color.parseColor(colorArray[index2]));
    }

}
