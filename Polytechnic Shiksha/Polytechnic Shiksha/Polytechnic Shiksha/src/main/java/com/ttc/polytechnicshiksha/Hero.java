package com.ttc.polytechnicshiksha;



public class Hero {

    String image;
    String name, team,teacherName;

    public Hero(String image, String name, String team, String teacherName) {
        this.image = image;
        this.name = name;
        this.team = team;
        this.teacherName = teacherName;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getTeacher() {
        return teacherName;
    }
}
