package org.sogrey.tsd.demo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import org.sogrey.tsd.toast.Tt;

/**
 * Created by Sogrey on 2017/3/21.
 */

public class ToastActivity extends AppCompatActivity {
    Tt st, stBuilder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        stBuilder = new Tt
                .Builder(this, "Turn off fly mode").withGravity(Gravity.TOP)
                .withBackgroundColor(Color.parseColor("#865aff"))
                .withIcon(R.drawable.ic_airplanemode_inactive_black_24dp)
                .withMaxAlpha()
                .build();

    }

    public void Toaster(View v) {

        switch (v.getId()) {
            case R.id.button1:

                st = new Tt(this, "Updating profile", Toast.LENGTH_LONG);
                st.setBackgroundColor(Color.parseColor("#ff5a5f"));
                st.setTextColor(Color.WHITE);
                st.setIcon(R.drawable.ic_autorenew_black_24dp);
                st.spinIcon();
                st.setMaxAlpha();
                st.show();

                break;

            case R.id.button2:

                stBuilder.show();

                break;

            case R.id.button3:


                st = new Tt(this, "Profile saved", Toast.LENGTH_LONG);
                st.setBackgroundColor(Color.parseColor("#3b5998"));
                st.setMaxAlpha();
//                st.setAnimation();
                st.setTextFont(Typeface.createFromAsset(getAssets(), "fonts/Dosis-Light.otf"));
                st.show();


                break;

            case R.id.button4:

                st = new Tt(this.getApplicationContext(), "PHONE IS OVERHEATING!", Toast.LENGTH_LONG);
                st.setCornerRadius(5);
                st.setBackgroundColor(Color.BLACK);
                st.setTextColor(Color.RED);
                st.setBoldText();
                st.show();

                break;

            case R.id.button5:

                Tt.makeText(this, "Picture saved in gallery", Toast.LENGTH_LONG, R.style.StyleableToast).show();

                break;

            case R.id.button6:

                st = new Tt(this, "Wrong password/username", Toast.LENGTH_LONG);
                st.setBackgroundColor(Color.parseColor("#2187c6"));
                st.setBoldText();
                st.setTextColor(Color.WHITE);
                st.setCornerRadius(7);
                st.show();
                break;
        }
    }
}
