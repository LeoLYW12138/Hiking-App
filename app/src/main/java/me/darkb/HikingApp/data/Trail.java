package me.darkb.HikingApp.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "trails")
public class Trail implements Serializable {
    @PrimaryKey
    private int id;

    private String img;
    private String title;
    private String subtitle;
    private Float difficulty;
    private Float length;
    private Float duration;
    private String region;
    private String start_pt;
    private String end_pt;
    private Boolean isTarget;


    public Trail(String img, String title, String subtitle, Float difficulty, Float length, Float duration, String region, String start_pt, String end_pt, Boolean isTarget) {
        this.img = img;
        this.title = title;
        this.subtitle = subtitle;
        this.difficulty = difficulty;
        this.length = length;
        this.duration = duration;
        this.region = region;
        this.start_pt = start_pt;
        this.end_pt = end_pt;
        this.isTarget = isTarget;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Float getDifficulty() {
        return difficulty;
    }

    public Float getLength() {
        return length;
    }

    public Float getDuration() {
        return duration;
    }

    public String getRegion() {
        return region;
    }

    public String getStart_pt() {
        return start_pt;
    }

    public String getEnd_pt() {
        return end_pt;
    }

    public Boolean getTarget() {
        return isTarget;
    }

    public static Trail[] populateData() {
        return new Trail[]{
                new Trail("aberdeen_country_park", "Aberdeen natural trail", "Hong Kong Trail", 1.0f, 1.2f, 1.0f, "Hong Kong Island",
                        "Take public transport to \"Hoy Au Lau Yue Kwong Chuen\" bus stop and walk up the Aberdeen Reservoir road for 10 minutes to reach the entrance of Aberdeen Country Park. Then walk along the path on the right hand side for 5 minutues to reach the start point of the trail.\n" +
                                "\n" + "Citybus routes - 7 and 76\n" + "New World First Bus (NWFB) routes - 95 and 971\n" + "Green Minibus routes - 4A, 4B, 4C, 4S and 52\n" + "Minibus - Aberdeen to Shek Pai Wan",
                        "The finishing point is located at the main dam of the Aberdeen Upper Reservoir. Visitors can walk along the Aberdeen Reservoir Road for 30 minutes to Yue Kwong Road bus stop.\n" +
                                "\n" + "Citybus - 7 and 76\n" + "New World First Bus (NWFB) routes - 95 and 971", false),
                new Trail("amah_rock", "Hung Mui Kuk Natural Trail", "Wilson Trail", 1.0f, 1.3f, 1.0f, "Central New Territories",
                        "Get off at \"World Wide Gardens\" bus stop and then take a walk about 2 minutes to reach the entrance of the Hung Mui Kuk Nature Trail located at the Hung Mui Kuk Barbecue Site.\n" +
                                "\n" + "Kowloon Motor Bus (KMB) routes - 80, 85, 85B, 86A, 87B, 89B, 170, 182, 281M, N170 , N182 , N281",
                        "Get off at \"World Wide Gardens\" bus stop and then take a walk about 2 minutes to reach the entrance of the Hung Mui Kuk Nature Trail located at the Hung Mui Kuk Barbecue Site.\n" +
                                "\n" + "Kowloon Motor Bus (KMB) routes - 80, 85, 85B, 86A, 87B, 89B, 170, 182, 281M, N170 , N182 , N281", false),
                new Trail("grassy_hill", "MacLehose Trail (Section 7)", "MacLehose Trail", 3.0f, 6.2f, 2.5f, "Central New Territories",
                        "Take Green Minibus route no. 82 at Shiu Wo Street, Tsuen Wan, to the Pineapple Dam Green Minibus Terminus at Shing Mun Reservoir, or take public transport via the Ho Fung College at Wo Yi Hop Road. Get off at Ho Fung College and walk along the Shing Mun Road for 20 minutes to reach the Pineapple Dam.\n" +
                                "\n" + "KMB - 32, 36, 40X, 46P, 46X, 47X, 48X, 73X, 278X, N36, 40P, 46P, 47A, 234C, 273C, 273P, 278P\n" + "Green Minibus - 94, 312, 403, 403A, 403X, 94S (94S only runs on Sundays and public holidays)",
                        "Continue to MacLehose Trail (Section 8) and leave at Route Twisk, or walk along Wilson Trail Section 7 from Lead Mine Pass for about one and a half hour to Yuen Tun Ha and then take Green Minibus to leave.\n" + "\n" + "Green Minibus - 23K and 23S", false),
                new Trail("lai_chi_wo", "Lai Chi Wo Natural Trail", "Natural Trail", 1.0f, 1.2f, 1.0f, "North New Territories",
                        "Take public transport to Wu Kau Tang Green Minibus terminus located at Chi Sum Road. Then walk from Wu Kau Tang to Lai Chi Wo for 2 hours to reach the start point.\n" +
                                "\n" + "Kowloon Motor Bus (KMB) routes - 275R (275R only runs on Sundays and public holidays.)\n" + "Green Minibus routes - 20R",
                        "Visitors can return to Start Point and take public transport for leaving. On Sundays and public holidays, ferry service is available from Lai Chi Wo to Ma Liu Shui.\n" +
                                "\n" + "Kowloon Motor Bus (KMB) routes - 275R (275R only runs on Sundays and public holidays.)\n" +
                                "Green Minibus routes - 20R\n" + "Ferry Service - Lai Chi Wo Ferry Pier to Ma Liu Shui Ferry Pier (only runs on Sundays and public holidays at 3:30 pm)", false)
        };
    }
}
