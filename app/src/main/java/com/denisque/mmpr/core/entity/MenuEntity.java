package com.denisque.mmpr.core.entity;

import java.util.Objects;

public class MenuEntity {
    public String title;
    public String buttonText;

    public MenuEntity() {
    }

    public MenuEntity(String title, String buttonText) {
        this.title = title;
        this.buttonText = buttonText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getButtonText() {
        return buttonText;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuEntity that = (MenuEntity) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(buttonText, that.buttonText);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, buttonText);
    }

    @Override
    public String toString() {
        return "MenuEntity{" +
                "title='" + title + '\'' +
                ", buttonText='" + buttonText + '\'' +
                '}';
    }
}
