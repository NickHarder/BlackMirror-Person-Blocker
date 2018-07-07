package austin.milford.rosales.whitechristmas;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.hardware.camera2.CameraManager;

public class MainActivity extends Activity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);

        CameraManager CM = this.getSystemService(CameraManager.class);

        String[] idList = {};
        try {
            idList = CM.getCameraIdList();
            String text = "";
            for (int i = 0; i < idList.length; i++) {
                text = text + idList[i] + "|"; }
            tv.setText(text);
        } catch (android.hardware.camera2.CameraAccessException e) {
            System.err.println("CameraAccessException: " + e.getMessage());
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
