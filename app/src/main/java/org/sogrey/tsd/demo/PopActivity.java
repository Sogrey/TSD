package org.sogrey.tsd.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import org.sogrey.tsd.pop.BubblePopup;

public class PopActivity extends AppCompatActivity {
    private Button mBtnPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);
        mBtnPop = (Button) findViewById(R.id.button_pop);
    }

    public void ShowPop(View v) {
        View inflate = View.inflate(this, R.layout.popup_bubble_image, null);
        BubblePopup bubblePopup = new BubblePopup(this, inflate);
        bubblePopup.anchorView(mBtnPop)
//                .showAnim(new BounceRightEnter())
//                .dismissAnim(new SlideLeftExit())
                .gravity(Gravity.BOTTOM)
                .autoDismiss(true)
                .show();
    }

}
