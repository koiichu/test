package sound.sound;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
    MediaPlayer mpBgm; /*ประกาศ class*/
    Button btnOK;
    ToggleButton tbBGM; /*Toggle Button ปิดเปิดเสียง*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        mpBgm = MediaPlayer.create(MainActivity.this, R.raw.bgm);
        mpBgm.setLooping(true); /*กำหนดให้วนลูปตลอด*/
        mpBgm.start();/*สั่งให้เริ่มเล่นไฟล์เสียง bgm ทันทีเมื่อผู้ใช้เปิดแอปฯ*/

        btnOK = (Button) findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new OnClickListener() {
            /*กำหนดค่าให้กับ btnOK ของคลาส Button และเรียกใช้ Listener
            เมื่อผู้ใช้กดปุ่ม btnOK ก็จะเรียกใช้คลาส MediaPlayer
            ให้เล่นไฟล์เสียงที่อยู่ใน res/raw ที่ชื่อว่า sound_effect */
            public void onClick(View v) {
                MediaPlayer mpEffect
                        = MediaPlayer.create(MainActivity.this, R.raw.sound_effect);
                mpEffect.start();/*สั่งให้เริ่มเล่นไฟล์เสียง sound_effect ทันที*/
            }
        });

        tbBGM = (ToggleButton) findViewById(R.id.tbBGM);
        tbBGM.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            /*กำหนดค่าให้กับ tbBGM ของคลาส ToggleButton และเรียกใช้ Listener
            เมื่อกดให้ปุ่ม Toggle Button เป็น ON (True) ก็จะให้เล่นเสียง BGM*/
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if (arg1)
                    mpBgm.start();
                else
                    mpBgm.stop();
            }
        });
    }

    public void onResume() {
        super.onResume();
        if (tbBGM.isChecked())
            mpBgm.start();
    }
        /* ฟังก์ชัน onResume ที่จะทำงานเมื่อเปิดแอปพลิเคชันขึ้นมา
        หรือว่าย่อแอปพลิเคชันไว้ แล้วเปิดเข้ามาใหม่อีกครั้ง
        โดยฟังก์ชันนี้ก็จะให้เช็คว่าปุ่ม tbBGM ที่เป็น Toggle Button
        ว่าปุ่มดังกล่าวเป็น ON หรือ OFF ถ้ามีสถานะเป็น ON
        ก็จะให้เล่นไฟล์เสียง BGM ต่อจากของเดิม
        */

    public void onPause() {
        super.onPause();
        mpBgm.pause();
    }
    /*onPause หยุดเล่นเมื่อออกจากแอป เปิดแอปเข้ามาก็เล่นต่อด้วย onResume*/

    public void onDestroy() {
        super.onDestroy();
        mpBgm.stop();
        mpBgm.release();
        mpBgm = null;
    }
     /*หยุดเล่นเมื่อออกจากแอป แล้วเครียร์ข้อมูลใน mpBgm ทิ้ง เป็นการยกเลิกการเล่นเสียงไปเลย*/
}