package org.sogrey.tsd.dialog.listener;

/**
 * Created by Sogrey on 2017/3/22.
 */

import android.view.View;
import android.widget.AdapterView;

public interface OnOperItemClickListener {
    void onOperItemClick(AdapterView<?> parent, View view, int position, long id);
}