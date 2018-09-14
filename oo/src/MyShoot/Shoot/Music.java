package MyShoot.Shoot;
import java.applet.*; 
import java.net.*;

public class Music { 
	    public Music()
	    {
	        try
	        {
	            URL SoundFile=new URL("/oo/src/MyShoot/Shoot/∫√œÎƒ„.mp3");
	            AudioClip Sound=Applet.newAudioClip(SoundFile);
	            Sound.play();
	            Sound.loop();
	            try
	            {
	                Thread.sleep(1000);
	            }catch(InterruptedException e){}
	        }catch(MalformedURLException mue){}
	    }
} 
