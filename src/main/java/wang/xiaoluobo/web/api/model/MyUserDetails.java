//package wang.xiaoluobo.web.api.model;
//
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//
//import java.util.Collection;
//
//@Data
//public class MyUserDetails extends User {
//
//    private static final long serialVersionUID = -1212367372911855308L;
//
//    private Long id;
//
//    private String username;
//
//    private String mobile;
//
//    private Long group;
//
//    private boolean admin;
//
//    private String token;
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    public MyUserDetails(Long id, String username, String password, String token, String mobile, Long group, boolean admin, Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, authorities);
//        this.id = id;
//        this.username = username;
//        this.token = token;
//        this.mobile = mobile;
//        this.group = group;
//        this.admin = admin;
//    }
//}
