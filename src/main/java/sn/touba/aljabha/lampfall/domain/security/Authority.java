package sn.touba.aljabha.lampfall.domain.security;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class Authority implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 123123L;
    @Getter
    private final String authority;

}
