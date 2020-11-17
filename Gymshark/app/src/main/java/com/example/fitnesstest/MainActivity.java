package com.example.fitnesstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    public TextView titlepage, subtitlepage, btnexercise, quoteText;
    public ImageView imgpage;
    public Animation animimgpage, bttone, bttwo, btthree, lefttoright;
    public View bgprogress, bgprogresstop;
    public Button nextButton, prevButton;
    public Stack<String> previousQuotes;
    public int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animimgpage = AnimationUtils.loadAnimation(this, R.anim.animimgpage);
        bttone = AnimationUtils.loadAnimation(this, R.anim.bttone);
        bttwo = AnimationUtils.loadAnimation(this, R.anim.bttwo);
        btthree = AnimationUtils.loadAnimation(this, R.anim.btthree);
        lefttoright = AnimationUtils.loadAnimation(this, R.anim.lefttoright);


        titlepage = (TextView) findViewById(R.id.titlepage);
        subtitlepage = (TextView) findViewById(R.id.subtitlepage);
        btnexercise = (TextView) findViewById(R.id.btnexercise);
        imgpage = (ImageView) findViewById(R.id.imgpage);
        quoteText = (TextView) findViewById(R.id.titlepage);
        nextButton = (Button) findViewById(R.id.nextbutton);
        prevButton = (Button)findViewById(R.id.backbutton);

        bgprogress = (View) findViewById(R.id.bgprogress);
//        bgprogresstop = (View) findViewById(R.id.bgprogresstop);

        imgpage.startAnimation(animimgpage);
        titlepage.startAnimation(bttone);
        subtitlepage.startAnimation(bttone);

        btnexercise.startAnimation(btthree);
        bgprogress.startAnimation(bttwo);
//        bgprogresstop.startAnimation(lefttoright);

        //give an event to another page
        btnexercise.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this,WorkoutAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });
        Resources res = getResources();
        final String[] allQuotes = res.getStringArray(R.array.gymquotes);
        final String[] allAuthors = res.getStringArray(R.array.authors);

        previousQuotes = new Stack<>();

        index = getRandomQuote(allQuotes.length-1);
        quoteText.setText(allQuotes[index]+" -- "+ allAuthors[index]);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = getRandomQuote(allQuotes.length-1);
                quoteText.setText(allQuotes[index]+" -- "+ allAuthors[index]);
                previousQuotes.push(allQuotes[index]+" -- "+ allAuthors[index]);
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(previousQuotes.size()>0){
                    quoteText.setText(previousQuotes.pop());
                }
                else{
                    Toast.makeText(MainActivity.this,"Get new Quote!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public int getRandomQuote(int length){
        return (int) (Math.random() * length) + 1;
    }
}