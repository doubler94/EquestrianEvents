package cavalli.entity.Competition;

import cavalli.entity.Rider.Rider;
import cavalli.entity.User.User;

import javax.persistence.*;

/**
 * Created by Ola on 08.12.2016.
 */
@Entity
@Table(name = "Competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String StartDate;

    private String StopDate;

    private String ManagerTrack;

    private String Manager;

    private String PlaceSize;

    private String WarmUpSize;

    private String Ground;

    private String Price;

    @JoinColumn(name = "UserId")
    @ManyToOne
    private User user;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public String getStopDate() {
        return StopDate;
    }

    public void setStopDate(String StopDate) {
        this.StopDate = StopDate;
    }

    public String getManagerTrack() {
        return ManagerTrack;
    }

    public void setManagerTrack(String ManagerTrack) {
        this.ManagerTrack = ManagerTrack;
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String Manager) {
        this.Manager = Manager;
    }

    public String getPlaceSize() {
        return PlaceSize;
    }

    public void setPlaceSize(String PlaceSize) {
        this.PlaceSize = PlaceSize;
    }

    public String getWarmUpSize() {
        return WarmUpSize;
    }

    public void setWarmUpSize(String WarmUpSize) {
        this.WarmUpSize = WarmUpSize;
    }

    public String getGround() {
        return Ground;
    }

    public void setGround(String Ground) {
        this.Ground = Ground;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "Id=" + Id +
                ", StartDate='" + StartDate + '\'' +
                ", StopDate='" + StopDate + '\'' +
                ", ManagerTrack='" + ManagerTrack + '\'' +
                ", Manager='" + Manager + '\'' +
                ", PlaceSize='" + PlaceSize + '\'' +
                ", WarmUpSize='" + WarmUpSize + '\'' +
                ", Ground='" + Ground + '\'' +
                ", Price='" + Price + '\'' +
                ", user=" + user +
                '}';
    }
}
