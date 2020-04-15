
package com.petstore.petstoreTests;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;


public class Order {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("petId")
    @Expose
    private int petId;
    @SerializedName("quantity")
    @Expose
    private int quantity;
    @SerializedName("shipDate")
    @Expose
    private String shipDate;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("complete")
    @Expose
    private boolean complete;

    public Order() {

    }

    public Order(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        super();
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("petId", petId).append("quantity", quantity).append("shipDate", shipDate).append("status", status).append("complete", complete).toString();
    }

}
