package com.example.demo;

public class People {
    private final String name;
    private final String surname;
    private final  Integer changeForCredit;
    private final Integer agePeople;
    private final Integer professionPeople;
    private final Integer company;
    private final Integer userId;




    public People(String name, String surname, Integer changeForCredit,
                  Integer agePeople, Integer professionPeople, Integer company, Integer userId) {
        this.name = name;
        this.surname = surname;
        this.changeForCredit = changeForCredit;
        this.agePeople = agePeople;
        this.professionPeople = professionPeople;
        this.company = company;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public Integer getChangeForCredit() {
        return changeForCredit;
    }

    public Integer getAgePeople() {
        return agePeople;
    }

    public Integer getProfessionPeople() {
        return professionPeople;
    }

    public Integer getCompany() {
        return company;
    }

    public Integer getUserId() {
        return userId;
    }
}