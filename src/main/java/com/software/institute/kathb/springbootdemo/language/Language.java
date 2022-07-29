package com.software.institute.kathb.springbootdemo.language;

import com.software.institute.kathb.springbootdemo.film.Film;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "language")
public class Language {

    @Id
    @Column(name="language_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int languageId;

    @Column(name="name")
    private String name;

    @Column(name="last_update")
    private String lastUpdate;

    @OneToMany(mappedBy = "filmLanguage")
    private Set<Film> films;

    public Language()
    {

    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
