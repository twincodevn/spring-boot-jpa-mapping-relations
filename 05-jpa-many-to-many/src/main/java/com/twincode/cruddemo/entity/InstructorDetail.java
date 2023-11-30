package com.twincode.cruddemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
    // annotate the class as entity

    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name="youtube_channel")
    private String  youtubeChannel;
    // annotate fields with db column
    @Column(name="hobby")
    private String hobby;


    @OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;


    // constructors


    public InstructorDetail() {
    }

    public InstructorDetail( String youtubeChannel, String hobby) {

        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    // getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
