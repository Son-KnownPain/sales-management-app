package supports;

public class Gift {
    public static final int MILESTONE_1 = 1000;
    public static final String GIFTCODE_1 = "TTBCV0001-V1";
    
    public static final int MILESTONE_2 = 3000;
    public static final String GIFTCODE_2 = "TTBCV0003-V1";
    
    public static final int MILESTONE_3 = 6000;
    public static final String GIFTCODE_3 = "TTBCV0006-V1";
    
    public static final int MILESTONE_4 = 10000;
    public static final String GIFTCODE_4 = "TTBCV0010-V1";
    
    public static final int MILESTONE_5 = 15000;
    public static final String GIFTCODE_5 = "TTBCV0015-V1";
    
    public static final int MILESTONE_6 = 25000;
    public static final String GIFTCODE_6 = "TTBCV0025-V1";
    
    public static final int MILESTONE_7 = 50000;
    public static final String GIFTCODE_7 = "TTBCV0050-V1";
    
    public static final int MILESTONE_8 = 100000;
    public static final String GIFTCODE_8 = "TTBCV0100-V1";
    
    public static int getMilestone(int prevPoint, int newPoint) {
        if (prevPoint < MILESTONE_1 && newPoint >= MILESTONE_1) {
            return MILESTONE_1;
        } else if (prevPoint < MILESTONE_2 && newPoint >= MILESTONE_2) {
            return MILESTONE_2;
        } else if (prevPoint < MILESTONE_3 && newPoint >= MILESTONE_3) {
            return MILESTONE_3;
        } else if (prevPoint < MILESTONE_4 && newPoint >= MILESTONE_4) {
            return MILESTONE_4;
        } else if (prevPoint < MILESTONE_5 && newPoint >= MILESTONE_5) {
            return MILESTONE_5;
        } else if (prevPoint < MILESTONE_6 && newPoint >= MILESTONE_6) {
            return MILESTONE_6;
        } else if (prevPoint < MILESTONE_7 && newPoint >= MILESTONE_7) {
            return MILESTONE_7;
        } else if (prevPoint < MILESTONE_8 && newPoint >= MILESTONE_8) {
            return MILESTONE_8;
        } else {
            return 0;
        }
    }
}
