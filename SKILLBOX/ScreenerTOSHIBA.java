import javax.imageio.*;
import java.awt.AWTException;
import java.awt.*;
import java.io.*;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;


class Screen
{
    public static void main (String[] args)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
        Date now = new Date();
	
	BufferedImage image = null;
        try 
	{
		image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	}
	catch(AWTException ae)
	{
    		ae.printStackTrace();
	}
	
	try
        {
                ImageIO.write(image, "png", new File("/home/arseny/Рабочий стол/screen/", formatter.format(now) + ".png"));
        }
        catch(IOException ae)
        {
                ae.printStackTrace();

        }
    }
}
