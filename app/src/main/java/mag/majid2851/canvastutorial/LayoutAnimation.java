package mag.majid2851.canvastutorial;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;

public class LayoutAnimation extends View
{
    Paint redFill,blueFill,greenFill;
    Paint redStroke,blueStroke,greenStroke;
    Path triangle;
    Bitmap narutoBit;
    int narutoX,narutoY;
    final int pxNum=1;

    int xDir=pxNum,yDir=pxNum;
    int narutoWidth,narutoHeight;
    public LayoutAnimation(Context context)
    {
        super(context);
        setBackgroundResource(R.drawable.chess);
        narutoX=320;
        narutoY=470;

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
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

        Rect rect=new Rect();
        rect.set(210,125,250,175);
        canvas.drawRect(rect,greenStroke);


        Rect rect2=new Rect();
        rect.set(420,125,460,175);
        canvas.drawRect(rect,redFill);

        canvas.drawCircle(600,600,70,blueStroke);
        canvas.drawCircle(600,600,20,greenFill);
        canvas.drawCircle(600,600,10,redFill);

        canvas.drawCircle(200,600,70,blueStroke);
        canvas.drawCircle(200,600,20,greenFill);
        canvas.drawCircle(200,600,10,redFill);

        canvas.drawCircle(400,400,70,blueStroke);
        canvas.drawCircle(400,400,20,greenFill);
        canvas.drawCircle(400,400,10,redFill);

        triangle=new Path();
        triangle.moveTo(400,400);
        triangle.lineTo(600,600);
        triangle.moveTo(600,600);
        triangle.lineTo(200,600);
        triangle.moveTo(200,600);
        triangle.lineTo(400,400);

        canvas.drawPath(triangle,redStroke);

        narutoBit= BitmapFactory.decodeResource(getResources(),R.drawable.naruto);
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(getResources(),R.drawable.naruto,options);
        narutoHeight=options.outHeight;
        narutoWidth=options.outWidth;



        if (narutoX>=canvas.getWidth()-narutoWidth){
            xDir=-pxNum;
            yDir=-pxNum;
        }else if (narutoX<320)
        {
            xDir=pxNum;
            yDir=pxNum;
        }


        narutoX=narutoX+xDir;
        narutoY=narutoY+yDir;

        canvas.drawBitmap(narutoBit,narutoX,narutoY,null);
        invalidate();
    }
}
