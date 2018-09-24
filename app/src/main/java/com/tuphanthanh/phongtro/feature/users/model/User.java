package com.tuphanthanh.phongtro.feature.users.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("diachi")
    @Expose
    private String diachi;
    @SerializedName("sdt")
    @Expose
    private String sdt;
    @SerializedName("sophong")
    @Expose
    private String sophong;
    @SerializedName("cmnd")
    @Expose
    private String cmnd;
    @SerializedName("tendangnhap")
    @Expose
    private String tendangnhap;
    @SerializedName("isblock")
    @Expose
    private String isblock;
    @SerializedName("solanvipham")
    @Expose
    private String solanvipham;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getSophong() {
        return sophong;
    }

    public void setSophong(String sophong) {
        this.sophong = sophong;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getIsblock() {
        return isblock;
    }

    public void setIsblock(String isblock) {
        this.isblock = isblock;
    }

    public String getSolanvipham() {
        return solanvipham;
    }

    public void setSolanvipham(String solanvipham) {
        this.solanvipham = solanvipham;
    }

}