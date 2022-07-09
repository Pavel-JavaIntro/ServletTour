package by.course.tourist.model;

import java.time.LocalDate;
import java.util.Date;

public class Tour {
    private int id;
    private int statusId;
    private int typeId;
    private String Description;
    private int capacity;
    private int booked;
    private Date startDate;
    private Date endDate;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", statusId=" + statusId +
                ", typeId=" + typeId +
                ", Description='" + Description + '\'' +
                ", capacity=" + capacity +
                ", booked=" + booked +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                '}';
    }
}
