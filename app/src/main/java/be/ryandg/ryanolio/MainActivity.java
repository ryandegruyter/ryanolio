package be.ryandg.ryanolio;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String[] mAppNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initAppButtons();
    }

    private void initAppButtons() {
        LinearLayout mainLayoutContainer = (LinearLayout) findViewById(R.id.main_container);
        mAppNames = getResources().getStringArray(R.array.apps);

        //get the resource ids of all the string items inside the string-array
        final TypedArray typedArray = getResources().obtainTypedArray(R.array.apps);

        for (int i = 0; i < mAppNames.length; i++) {
            final String appName = mAppNames[i];
            Button appButton;
            if (mAppNames.length - 1 == i) {
                appButton = new AppCompatButton(
                        new ContextThemeWrapper(this, R.style.appButton), null, R.style.appButton
                );
            } else {
                appButton = new AppCompatButton(this);
            }
            final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            appButton.setLayoutParams(params);
            appButton.setId(typedArray.getResourceId(i, -1));
            appButton.setTag(appName);
            appButton.setText(appName);
            appButton.setOnClickListener(this);
            mainLayoutContainer.addView(appButton);
        }

        typedArray.recycle();
    }

    @Override
    public void onClick(View v) {
        String msg = String.format("This will open my %s app.", v.getTag());
        showMessage(msg);
//        handleAppButtons(v.getId());
    }

    //    in the future open apps
    private void handleAppButtons(int id) {
        switch (id) {
            case R.string.scores_ap:
                //todo open app
                break;
            case R.string.spotify_streamer:
                //todo open spotify app
                break;
            case R.string.library_app:
                //todo open library app
                break;
            case R.string.xyz_reader:
                //todo open xyz app
                break;
            case R.string.build_it_bigger:
                //todo open xyz app
                break;
            case R.string.capstone:
                //todo open capstone
                break;
        }
    }

    private void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


}
