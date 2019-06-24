package haru.boxy.a0620eventhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class VarietyEventActivity extends AppCompatActivity {

    private EditText edit;
    private Button btn;
    private LinearLayout mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variety_event);

        edit = (EditText)findViewById(R.id.edit);
        btn = (Button)findViewById(R.id.hidekeyboard);
        mainView = (LinearLayout)findViewById(R.id.mainview);

        //키보드 관리 객체를 생성
        final InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        //버튼을 눌렀을 때 이벤트 처리
        btn.setOnClickListener((view)->{
            imm.hideSoftInputFromWindow(
                    edit.getWindowToken(),0);
        });

        //메인 뷰 영역을 터치했을 때의 이벤트 처리
        mainView.setOnTouchListener((view, event)->{
            imm.hideSoftInputFromWindow(edit.getWindowToken(),0);
            return true;
        });
    }
}
