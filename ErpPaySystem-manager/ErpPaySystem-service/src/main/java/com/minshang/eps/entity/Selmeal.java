package com.minshang.eps.entity;

public class Selmeal {
    private Integer mealid;

    private Integer dishesdepotid;

    private String mealname;

    private Byte mealtype;

    private Double oriprice;

    private Double price;

    private Double memberprice;

    private String picurl;

    private Byte state;

    private Byte weigth;

    private Byte recommend;

    private Byte hot;

    private Byte pushmoney;

    private Byte pushtype;

    private Double fixmoney;

    private Double proportion;

    private String alldishesname;
    
    public Integer getMealid() {
        return mealid;
    }

    public void setMealid(Integer mealid) {
        this.mealid = mealid;
    }

    public Integer getDishesdepotid() {
        return dishesdepotid;
    }

    public void setDishesdepotid(Integer dishesdepotid) {
        this.dishesdepotid = dishesdepotid;
    }

    public String getMealname() {
        return mealname;
    }

    public void setMealname(String mealname) {
        this.mealname = mealname == null ? null : mealname.trim();
    }

    public Byte getMealtype() {
        return mealtype;
    }

    public void setMealtype(Byte mealtype) {
        this.mealtype = mealtype;
    }

    public Double getOriprice() {
        return oriprice;
    }

    public void setOriprice(Double oriprice) {
        this.oriprice = oriprice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMemberprice() {
        return memberprice;
    }

    public void setMemberprice(Double memberprice) {
        this.memberprice = memberprice;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl == null ? null : picurl.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getWeigth() {
        return weigth;
    }

    public void setWeigth(Byte weigth) {
        this.weigth = weigth;
    }

    public Byte getRecommend() {
        return recommend;
    }

    public void setRecommend(Byte recommend) {
        this.recommend = recommend;
    }

    public Byte getHot() {
        return hot;
    }

    public void setHot(Byte hot) {
        this.hot = hot;
    }

    public Byte getPushmoney() {
        return pushmoney;
    }

    public void setPushmoney(Byte pushmoney) {
        this.pushmoney = pushmoney;
    }

    public Byte getPushtype() {
        return pushtype;
    }

    public void setPushtype(Byte pushtype) {
        this.pushtype = pushtype;
    }

    public Double getFixmoney() {
        return fixmoney;
    }

    public void setFixmoney(Double fixmoney) {
        this.fixmoney = fixmoney;
    }

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

	public String getAlldishesname() {
		return alldishesname;
	}

	public void setAlldishesname(String alldishesname) {
		this.alldishesname = alldishesname;
	}
}