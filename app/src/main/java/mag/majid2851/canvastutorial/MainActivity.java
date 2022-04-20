package mag.majid2851.canvastutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    //LayoutAnimation layoutAnimation;
    SurfaceLayout surfaceLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        surfaceLayout=new SurfaceLayout(this);

        setContentView(surfaceLayout);

    }

    @Override
    protected void onPause() {
        super.onPause();
        surfaceLayout.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        surfaceLayout.resume();
    }
}