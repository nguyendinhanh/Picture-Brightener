import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.Color;

public class Brightness 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner in = new Scanner (System.in);
		System.out.print("What picture would you like to edit? : ");
		String file = in.next();

		Picture picture = new Picture ( file );

		System.out.print("How bright do you want your image? (0-5) ");
		double level = in.nextDouble();

		for ( int i = 0; i < picture.width(); i++)
			for ( int j = 0; j < picture.height(); j++)
			{
				Color c = picture.get(i, j);
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();

				red  = (int)(red*level);  
				green= (int)(green*level);   
				blue = (int)(blue*level);

				if ( red > 255 )
					red  = 255;
				if ( green > 255 )
					green = 255;
				if ( blue > 255 )
					blue = 255;
				c = new Color ( red, green, blue);
						picture.set(i, j, c);
			}
		picture.show();
	}
}
