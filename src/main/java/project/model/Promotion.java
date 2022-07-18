package project.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Promotion {
    private int id;
    private String name;
    private String form;
    private int discountRate;
    private String product;
    private String beginDate;
    private String endDate;
    private String status;
    private String description;

    public Promotion() {
    }

    public Promotion(int id, String name, String form, int discountRate, String product, String beginDate, String endDate, String status, String description) {
        this.id = id;
        this.name = name;
        this.form = form;
        this.discountRate = discountRate;
        this.product = product;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.status = status;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date stringBeginToDATE() throws Exception {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(beginDate);
        return date;
    }

    public Date stringEndToDATE() throws Exception {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(beginDate);
        return date;
    }
}

