package practicehome;

import java.util.Random;

public class random {
	
	public int getRandomNumber()
	{
		Random random=new Random();
		int rannum=random.nextInt(100000);
		return rannum;
	}

}
