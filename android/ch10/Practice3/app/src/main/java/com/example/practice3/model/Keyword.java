package com.example.practice3.model;

import java.io.Serializable;

public class Keyword implements Serializable {
    private static int total_count;
    private static int pageable_count;
    private static boolean is_end;

    private String[] region;
    private String keyword;
    private String selected_region;

    private String id;
    private String place_name;
    private String category_name;
    private String category_group_code;
    private String category_group_name;
    private String phone;
    private String address_name;
    private String road_address_name;
    private double x;
    private double y;
    private String place_url;
    private String distance;

    public static int getTotal_count() {
        return total_count;
    }

    public static void setTotal_count(int total_count) {
        Keyword.total_count = total_count;
    }

    public static int getPageable_count() {
        return pageable_count;
    }

    public static void setPageable_count(int pageable_count) {
        Keyword.pageable_count = pageable_count;
    }

    public static boolean isIs_end() {
        return is_end;
    }

    public static void setIs_end(boolean is_end) {
        Keyword.is_end = is_end;
    }

    public String[] getRegion() {
        return region;
    }

    public void setRegion(String[] region) {
        this.region = region;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSelected_region() {
        return selected_region;
    }

    public void setSelected_region(String selected_region) {
        this.selected_region = selected_region;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_group_code() {
        return category_group_code;
    }

    public void setCategory_group_code(String category_group_code) {
        this.category_group_code = category_group_code;
    }

    public String getCategory_group_name() {
        return category_group_name;
    }

    public void setCategory_group_name(String category_group_name) {
        this.category_group_name = category_group_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public String getRoad_address_name() {
        return road_address_name;
    }

    public void setRoad_address_name(String road_address_name) {
        this.road_address_name = road_address_name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getPlace_url() {
        return place_url;
    }

    public void setPlace_url(String place_url) {
        this.place_url = place_url;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
