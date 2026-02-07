package org.example.movie.model;

import jakarta.persistence.*;

@Entity
@Table(name = "viewers")
public class Viewer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;
    private String email;

    public Viewer(String viewerName) {
        super(viewerName);
    }

    public Viewer(String name, int age, String email) {
        super(name);
        this.age = age;
        this.email = email;
    }

    protected Viewer() {
        super();
    }

    @Override
    public String getRole() {
        return "Viewer";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return super.getName(); }
    public void setName(String name) { super.setName(name); }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}