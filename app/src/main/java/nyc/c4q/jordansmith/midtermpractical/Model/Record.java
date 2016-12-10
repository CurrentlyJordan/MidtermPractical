package nyc.c4q.jordansmith.midtermpractical.Model;

/**
 * Created by jordansmith on 12/10/16.
 */

public class Record {

    private int liked;
    private String username;
    private String profileBackground;
    private Repost repost;

    public Repost getRepost() {
        return repost;
    }

    public void setRepost(Repost repost) {
        this.repost = repost;
    }

    public int getLiked() {
        return liked;
    }

    public void setLiked(int liked) {
        this.liked = liked;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileBackground() {
        return profileBackground;
    }

    public void setProfileBackground(String profileBackground) {
        this.profileBackground = profileBackground;
    }
}