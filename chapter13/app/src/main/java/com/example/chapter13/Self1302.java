package com.example.chapter13;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Self1302 extends AppCompatActivity{
    ListView listViewMP3;
    MediaPlayer mPlayer;
    SeekBar pbMP3;      //add
    Switch switch1;     //add


    ArrayList<String> mp3List;
    String selectedMP3;

    String mp3Path = Environment.getExternalStorageDirectory().getPath() + "/" ;

    boolean PAUSED = false; // 음악이 일시정지 중인지 체크.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.self1302_main);


        // add
        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        // SDCard의 파일을 읽어서 리스트뷰에 출력
        mp3List = new ArrayList<String>(); // 가변적 문자열

        File[] listFiles = new File(mp3Path).listFiles();
        String fileName, extName;

        if (listFiles != null) // 오류 때문에 추가
        for (File file : listFiles) {
            fileName = file.getName();
            extName = fileName.substring(fileName.length() - 3);
            if (extName.equals((String) "mp3")) // 확장명이 mp3일 때만 추가함.
                mp3List.add(fileName);
        }

        ListView listViewMP3 = (ListView) findViewById(R.id.listViewMP3);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, mp3List);
        listViewMP3.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listViewMP3.setAdapter(adapter);
        listViewMP3.setItemChecked(0, true);

        listViewMP3
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> arg0, View arg1,
                                            int arg2, long arg3) {
                        switch1.setChecked(false);
                        mPlayer.stop();
                        selectedMP3 = mp3List.get(arg2);
                    }
                });
        selectedMP3 = mp3List.get(0);



        pbMP3 = (SeekBar) findViewById(R.id.pbMP3);

        switch1 = (Switch) findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (switch1.isChecked() == true) {

                    try {
                        mPlayer = new MediaPlayer();
                        mPlayer.setDataSource(mp3Path + selectedMP3);
                        mPlayer.prepare();
                        mPlayer.start();
                    } catch (IOException e) {
                    }

       //             mPlayer = MediaPlayer.create(getApplicationContext(),
       //                     R.raw.song1);
       //            mPlayer.start();
                    makeThread();
                } else {
                    mPlayer.stop();
                }
            }
        });

        pbMP3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onStopTrackingTouch(SeekBar seekBar) {

            }

            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                if (fromUser) {
                    mPlayer.seekTo(progress);
                }

            }
        });

    }

    void makeThread() {
        new Thread() {
            public void run() {
                // 음악이 계속 작동 중이라면
                while (mPlayer.isPlaying()) {
                    pbMP3.setMax(mPlayer.getDuration()); // 음악의 시간을 최대로 설정
                    pbMP3.setProgress(mPlayer.getCurrentPosition()); // 현재 위치를
                    // 지정
                    SystemClock.sleep(100);
                }
                pbMP3.setProgress(0);
            }
        }.start();
    }
}
