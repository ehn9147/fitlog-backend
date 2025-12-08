package com.fitlog.workout_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "settings")
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String displayName;
    private Integer weeklyGoal;
    private Boolean notificationsOn;
    private String theme;

    public Settings() {}

    public Long getId() { return id; }

    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public Integer getWeeklyGoal() { return weeklyGoal; }
    public void setWeeklyGoal(Integer weeklyGoal) { this.weeklyGoal = weeklyGoal; }

    public Boolean getNotificationsOn() { return notificationsOn; }
    public void setNotificationsOn(Boolean notificationsOn) { this.notificationsOn = notificationsOn; }

    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }
}
