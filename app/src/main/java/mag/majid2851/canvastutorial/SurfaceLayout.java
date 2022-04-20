package mag.majid2851.canvastutorial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceLayout extends SurfaceView implements Runnable
{
    Thread thread=null;
    boolean canDraw=false;
    Bitmap backgroundBit,img;
    Canvas canvas;
    SurfaceHolder surfaceHolder;

    Paint redFill,blueFill,greenFill;
    Paint redStroke,blueStroke,greenStroke;
    Path rectangle;
    int imgX,imgY;
    final int LEFT=300;
    final int RIGHT=900;
    final int TOP=500;
    final int BOTTOM=1100;
    final int speed=10;

    public SurfaceLayout(Context context) {
        super(context);
        surfaceHolder=getHolder();
        backgroundBit= BitmapFactory.decodeResource(getResources(),R.drawable.chess);
        img=BitmapFactory.decodeResource(getResources(),R.drawable.naruto);
        imgX=LEFT;
        imgY=TOP;

    }

    @Override
    public void run() {
        init();

        while (canDraw){
            if (!surfaceHolder.getSurface().isValid())
            {
                continue;
            }
            canvas=surfaceHolder.lockCanvas();
            motionNaruto(speed);
            canvas.drawBitmap(backgroundBit,0,0,null);
            drawSquare(LEFT,RIGHT,TOP,BOTTOM);
            canvas.drawBitmap(img,imgX-img.getWidth()/2,
                    imgY-img.getHeight()/2,null);
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }

    private void drawSquare(int x1, int x2, int y1, int y2)
    {
        rectangle=new Path();
        rectangle.moveTo(x1,y1);
        rectangle.lineTo(x2,y1);
        rectangle.moveTo(x2,y1);
        rectangle.lineTo(x2,y2);
        rectangle.moveTo(x2,y2);
        rectangle.lineTo(x1,y2);
        rectangle.moveTo(x1,y2);
        rectangle.lineTo(x1,y1);
        this.canvas.drawPath(rectangle,redStroke);


    }

    public void pause()
    {
        canDraw=false;
        while (true){
            try {
                thread.join();
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        thread=null;

    }
    public void resume(){
        canDraw=true;
        thread=new Thread(this);
        thread.start();

    }
    public void init()
    {
        redFill=new Paint();
        redFill.setColor(Color.RED);
        redFill.setStyle(Paint.Style.FILL);

        blueFill=new Paint();
        blueFill.setColor(Color.BLUE);
        blueFill.setStyle(Paint.Style.FILL);

        greenFill=new Paint();
        greenFill.setColor(Color.GREEN);
        greenFill.setStyle(Paint.Style.FILL);

        redStroke=new Paint();
        redStroke.setColor(Color.RED);
        redStroke.setStyle(Paint.Style.STROKE);
        redStroke.setStrokeWidth(10);

        blueStroke=new Paint();
        blueStroke.setColor(Color.BLUE);
        blueStroke.setStyle(Paint.Style.STROKE);
        blueStroke.setStrokeWidth(10);

        greenStroke=new Paint();
        greenStroke.setColor(Color.GREEN);
        greenStroke.setStyle(Paint.Style.STROKE);
        greenStroke.setStrokeWidth(10);
    }
    public void motionNaruto(int speed)
    {
        if (imgX<RIGHT && imgY==TOP)
        {
            imgX=imgX+speed;
        }
        if (imgY<BOTTOM && imgX==RIGHT)
        {
            imgY=imgY+speed;
        }
        if (imgX>=LEFT && imgY==BOTTOM)
        {
            imgX=imgX-speed;
        }
        if (imgY<=BOTTOM && imgX==LEFT)
        {
            imgY=imgY-speed;
        }

    }

}
