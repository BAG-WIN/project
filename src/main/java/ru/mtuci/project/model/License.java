package ru.mtuci.project.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "licence")
public class License {

    @Id
    @GeneratedValue
    private Long id;

    private Date first_activation_date, ending_date;
    private boolean blocked;
    private Integer device_count, duration;
    private String code, description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    private LicenseType licenseType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private ApplicationUser user;

    /*
    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String user_id;

    @OneToOne
    @MapsId
    private License licence;
     */
}
