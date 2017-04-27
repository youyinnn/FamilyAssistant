package model;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/2/13
 */
public class UserLocation {

    private int id;
    private String username;
    private String location;
    private String portrait_url;

    public UserLocation() {
    }

    @Override
    public String toString() {
        return "UserLocation{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", location='" + location + '\'' +
                ", portrait_url='" + portrait_url + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPortrait_url() {
        return portrait_url;
    }

    public void setPortrait_url(String portrait_url) {
        this.portrait_url = portrait_url;
    }

    public UserLocation(int id, String username, String location, String portrait_url) {

        this.id = id;
        this.username = username;
        this.location = location;
        this.portrait_url = portrait_url;
    }
}
