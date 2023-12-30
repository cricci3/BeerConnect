package com.bicoccaprojects.beerconnect.entity;

import com.bicoccaprojects.beerconnect.entity.relational_entity.ClientReview;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "Client")
@Table(name = "client", uniqueConstraints = {
                @UniqueConstraint(name = "client_email_unique", columnNames = "email")})
public class Client {
    @Id
    @SequenceGenerator(name="client_sequence", sequenceName = "client_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "client_sequence") // generate an ID that starts from 1 and increments by 1 for each new entity
    @Column(name = "id_client", updatable = false)
    private Long idClient;

    @Column(name = "name_client", nullable = false)
    private String nameClient;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "date_birth", nullable = false)
    private Integer dateBirth;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "preferences", nullable = false)
    private String preferences;

    @OneToMany(mappedBy = "idClient")
    private List<ClientReview> clientReviews;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "client_to_client",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "id_client_followed"),
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = {"client_id", "id_client_followed"})
            })

    // altri utenti che seguono il Client soggetto
    private Set<Client> clientFollowers = new HashSet<Client>(); // lazy initialization

    // utenti seguiti dal client soggetto
    @ManyToMany(mappedBy = "clientFollowers")
    private Set<Client> followedByClient = new HashSet<Client>(); // lazy initialization


    public Client(String name, String email, Integer date_birth, String address, String preferences) {
        this.nameClient = name;
        this.email = email;
        this.dateBirth = date_birth;
        this.address = address;
        this.preferences = preferences;
    }

    public Client(Long idClient) {
        this.idClient = idClient;
    }

    public Client() {

    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long id) {
        this.idClient = id;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String name) {
        this.nameClient = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Integer date_birth) {
        this.dateBirth = date_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPreferences() {
        return preferences;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public Set<Client> getClientFollowers(){
        return clientFollowers;
    }

    public Set<Client> getFollowedByClient(){
        return followedByClient;
    }

    public void setClientFollowers(Set<Client> followers) {
        this.clientFollowers = followers;
    }

    public void setFollowedByClient(Set<Client> following) {
        this.followedByClient = following;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + idClient +
                ", name='" + nameClient + '\'' +
                ", email='" + email + '\'' +
                ", date_birth=" + dateBirth +
                ", address='" + address + '\'' +
                ", preferences='" + preferences + '\'' +
                '}';
    }
}
