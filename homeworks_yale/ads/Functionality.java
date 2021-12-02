package ads;

public class Functionality {
	// give each functionality a score
	protected int[] functions;
	
	public Functionality(int web_browsing, int office_work, int photo_video_editing,
			int games, int coding, int social, int watchTV, int power_time) {
		functions = new int[8];
		functions[0] = web_browsing;		// web_browsing;
		functions[1] = office_work;			//office_work;
		functions[2] = photo_video_editing;	// photo_video_editing;
		functions[3] = games;				// games;
		functions[4] = coding;				// coding;
		functions[5] = social;				// social;
		functions[6] = watchTV;				// watchTV;
		functions[7] = power_time;			// power_time;
	}
}