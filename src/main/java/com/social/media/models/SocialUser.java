package com.social.media.models;

import jakarta.persistence.*;


@Entity
public class SocialUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "user")
    private SocialProfile socialProfile;
}
