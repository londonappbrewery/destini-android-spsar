package com.londonappbrewery.destini;

import android.app.Activity;
//import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity { //AppCompatActivity {


    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mBtnTop;
    Button mBtnBottom;
    TextView mStoryTextView;
    int mStoryIndex;

    final int T1Story = 1;
    final int T2Story = 2;
    final int T3Story = 3;
    final int T4Story = 4;
    final int T5Story = 5;
    final int T6Story = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
//            mScore = savedInstanceState.getInt("ScoreKey");
//            mStoryIndex = savedInstanceState.getInt("IndexKey");
        } else {
//            mScore = 0;
//            mStoryIndex = 0;
        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mBtnTop = (Button) findViewById(R.id.buttonTop);
        mBtnBottom = (Button) findViewById(R.id.buttonBottom);
        mStoryIndex = 1;

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mBtnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoryIndex = setIdxFromTopBtn(mStoryIndex);
                updateQuestion();
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBtnBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStoryIndex = setIdxFromBottomBtn(mStoryIndex);
                updateQuestion();
            }
        });


    }

    private void updateQuestion(){
        //mStoryIndex = ++mStoryIndex; // % mQuestionBank.length;

        switch (mStoryIndex) {
            case 2:
                mStoryTextView.setText(R.string.T2_Story);
                mBtnTop.setText(R.string.T2_Ans1);
                mBtnBottom.setText(R.string.T2_Ans2);
                break;
            case 3:
                mStoryTextView.setText(R.string.T3_Story);
                mBtnTop.setText(R.string.T3_Ans1);
                mBtnBottom.setText(R.string.T3_Ans2);
                break;
            case 4:
                mStoryTextView.setText(R.string.T4_End);
                mBtnTop.setText("");
                mBtnBottom.setText("");
                break;
            case 5:
                mStoryTextView.setText(R.string.T5_End);
                mBtnTop.setText("");
                mBtnBottom.setText("");
                break;
            case 6:
                mStoryTextView.setText(R.string.T6_End);
                mBtnTop.setText("");
                mBtnBottom.setText("");
                break;
        }

        if ((mStoryIndex == 0) || (mStoryIndex > 3)){
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game over");
            alert.setCancelable(false);
            //alert.setMessage("You scored " + mScore + " points");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alert.show();
        }

//        mQuestion = mQuestionBank[mIndex].getQuestionId();
//        mQuestionTextView.setText(mQuestion);
//        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
//        mScoreTextView.setText("Score " + mScore + "/" + mQuestionBank.length);
    }
//    @Override
//    public void onSaveInstanceState(Bundle outState){
//        super.onSaveInstanceState(outState);
//        //outState.putInt("ScoreKey", mScore);
//        outState.putInt("IndexKey", mStoryIndex);
//    }

    private int setIdxFromTopBtn (int index){
        switch (index) {
            case T1Story:
                return T3Story;
            case T2Story:
                return T3Story;
            case T3Story:
                return T6Story;
//            case T4Story: return T0Story;
//            case T5Story: return T0Story;
//            case T6Story: return T0Story;
            default:
                return 0;
        }
    }

    private int setIdxFromBottomBtn(int index) {
        switch (index) {
            case T1Story:
                return T2Story;
            case T2Story:
                return T4Story;
            case T3Story:
                return T5Story;
//        case T4Story: return T0Story;
//        case T5Story: return T0Story;
//        case T6Story: return T0Story;
            default:
                return 0;
        }
    }
}
