package com.minshang.eps.entity;

public class Dishes {
    private Integer dishesid;

    private String dishesname;

    private Integer dishestypeid;

    private Double price;

    private Double memberprice;

    private Integer unit;

    private String spellremember;

    private String numremember;

    private Byte state;

    private Byte weigth;

    private Byte recommend;

    private Byte hot;

    private Byte nowprice;

    private Byte pushmoney;

    private Byte pushtype;

    private Double fixmoney;

    private Double proportion;

    private Double cost;
    
    private Byte multispe;
    
    private Byte recommenddishes;

    public Integer getDishesid() {
        return dishesid;
    }

    public void setDishesid(Integer dishesid) {
        this.dishesid = dishesid;
    }

    public String getDishesname() {
        return dishesname;
    }

    public void setDishesname(String dishesname) {
        this.dishesname = dishesname == null ? null : dishesname.trim();
    }

    public Integer getDishestypeid() {
        return dishestypeid;
    }

    public void setDishestypeid(Integer dishestypeid) {
        this.dishestypeid = dishestypeid;
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

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public String getSpellremember() {
        return spellremember;
    }

    public void setSpellremember(String spellremember) {
        this.spellremember = spellremember == null ? null : spellremember.trim();
    }

    public String getNumremember() {
        return numremember;
    }

    public void setNumremember(String numremember) {
        this.numremember = numremember == null ? null : numremember.trim();
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

    public Byte getNowprice() {
        return nowprice;
    }

    public void setNowprice(Byte nowprice) {
        this.nowprice = nowprice;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

	public Byte getMultispe() {
		return multispe;
	}

	public void setMultispe(Byte multispe) {
		this.multispe = multispe;
	}

	public Byte getRecommenddishes() {
		return recommenddishes;
	}

	public void setRecommenddishes(Byte recommenddishes) {
		this.recommenddishes = recommenddishes;
	}
}