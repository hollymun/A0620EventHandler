package haru.boxy.a0620eventhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EventRoutingActivity extends AppCompatActivity {

    private TextView display;
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_routing);

        display = (TextView)findViewById(R.id.routedisplay);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);

        //이벤트 처리 객체
        View.OnClickListener router = (view)->{
            //이벤트가 발생한 뷰를 구분해서 분기문 작성
            if(view == btn1){
                display.setText("Java Java");
            }else if(view == btn2){
                display.setText("Kotlin Kotlin");
            }
        };
        btn1.setOnClickListener(router);
        btn2.setOnClickListener(router);
/*
        btn1.setOnClickListener((view)->{
            display.setText("Java");
        });
        btn2.setOnClickListener((view)->{
            display.setText("Kotlin");
        });
*/
    }
}
