package haru.boxy.a0620eventhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {
    private TextView numdisplay;
    private Button start;
    private Button end;
    //인덱스 변수
    private int idx;
    //타이머 변수
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        numdisplay = (TextView)findViewById(R.id.num);
        start = (Button)findViewById(R.id.start);
        end = (Button)findViewById(R.id.end);

        //구문으로 볼 때는 1부터 10까지 1초마다 텍스트 뷰에 출력해야 하지만
        //실제로 출력하는 부분은 모드 모아서 한꺼번에 처리
        //idx는 1초마다 1씩 증가하지만 10초 후에 한꺼번에 10번을 수행함
        //화면 상에서는 10초 후에 10을 출력하는 것으로 보임
        //이때 쓸 수 있는 게 CountDownTimer 메소드
/*        try{
            for(int i=0; i<10; i=i+1){
                idx = idx + 1;
                Log.e("idx",idx + "");
                numdisplay.setText(idx + "");
                Thread.sleep(1000);
            }
        }catch(Exception e){

        }
*/

/*
        //일정한 주기마다 메인 스레드에게 onTick 메소드의 수행을 요청함
        CountDownTimer timer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
                idx = idx + 1;
                numdisplay.setText(idx + "");
            }

            @Override
            public void onFinish() {
            }
        };
        timer.start();
*/
    start.setOnClickListener((view)->{
        timer = new CountDownTimer(10000,1000){
            @Override
            public void onTick(long l){
                idx = idx + 1;
                numdisplay.setText(idx + "");
            }
            @Override
            public void onFinish(){}
        };
        timer.start();
    });
    end.setOnClickListener((view)->{
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    });

    }
}
