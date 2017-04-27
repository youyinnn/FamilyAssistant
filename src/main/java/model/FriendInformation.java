package model;

/**
 * @description: friend message class
 * @author: youyinnn
 * @date: 2017/2/11
 */
public class FriendInformation {

    private int id;
    private int friend_id;
    private String remark;
    private String relationship;

    public FriendInformation() {

    }

    public FriendInformation(int id, int friend_id, String remark, String relationship) {
        this.id = id;
        this.friend_id = friend_id;
        this.remark = remark;
        this.relationship = relationship;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFriend_id() {
        return friend_id;
    }

    public void setFriend_id(int friend_id) {
        this.friend_id = friend_id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return "FriendInformation{" +
                "id=" + id +
                ", friend_id=" + friend_id +
                ", remark='" + remark + '\'' +
                ", relationship='" + relationship + '\'' +
                '}';
    }
}
