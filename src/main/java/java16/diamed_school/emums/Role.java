package java16.diamed_school.emums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
        ADMIN,STUDENT;

        @Override
        public String getAuthority() {
                return name();
        }
}
