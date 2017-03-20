package org.sogrey.tsd.toast;

import android.os.CountDownTimer;

/**
 * Created by Muddz on 26-01-2017.
 */

public class ToastDurationWatcher {

    private static final int LENGTH_LONG = 3500;
    private static final int LENGTH_SHORT = 2000;
    private int duration;
    private OnToastFinished onToastFinished;

    /**
     *
     * @param duration 持续时间
     * @param onToastFinished 吐司结束监听
     */
    public ToastDurationWatcher(int duration, OnToastFinished onToastFinished) {
        this.duration = duration;
        this.onToastFinished = onToastFinished;
        trackToastDuration();
    }


    private void trackToastDuration() {
        CountDownTimer countDownTimer = new CountDownTimer(getToastDuration() + 500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if (onToastFinished != null) {
                    onToastFinished.onToastFinished();
                }
            }
        };
        countDownTimer.start();
    }


    private long getToastDuration() {
        if (duration == 1) {
            return (long) LENGTH_LONG;
        } else {
            return (long) LENGTH_SHORT;
        }
    }
}
