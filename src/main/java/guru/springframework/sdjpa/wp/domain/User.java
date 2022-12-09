package guru.springframework.sdjpa.wp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.NonNull;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name="wp_users", indexes = {
        @Index(name = "user_login_key", columnList = "user_login"),
        @Index(name = "user_nicename", columnList = "user_nicename"),
        @Index(name = "user_email", columnList = "user_email")
})
public class User {
    @Id
    @Size(max = 20)
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_login")
    @Size(max = 60)
    @NonNull
    private String login;

    @Column(name = "user_pass")
    @Size(max = 255)
    @NonNull
    private String password;

    @Column(name = "user_nicename")
    @NonNull
    @Size(max = 50)
    private String nicename;

    @Column(name = "user_email")
    @NonNull
    @Size(max = 100)
    @Email
    private String email;

    @URL
    @Column(name = "user_url")
    @NonNull
    @Size(max = 100)
    private String url;

    @Column(name = "user_registered")
    @NotNull
    private Timestamp registered;

    @Column(name = "user_activation_key")
    @NonNull
    @Size(max = 255)
    private String activationKey;

    @Column(name = "user_status")
    @NonNull
    @Size(max = 11)
    private Integer status;

    @Basic(optional = false)
    String displayName;

    @OneToMany(mappedBy = "user")
    Set<UserMeta> userMetaSet;

    @OneToMany
    @JoinColumn(name = "user_id")
    Set<Comment> commentSet;

    public Set<UserMeta> getUserMetaSet() {
        return userMetaSet;
    }

    public void setUserMetaSet(Set<UserMeta> userMetaSet) {
        this.userMetaSet = userMetaSet;
    }

    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNicename() {
        return nicename;
    }

    public void setNicename(String nicename) {
        this.nicename = nicename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getRegistered() {
        return registered;
    }

    public void setRegistered(Timestamp registered) {
        this.registered = registered;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
