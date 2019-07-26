package vn.com.minori.common.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO extends BaseDTO{
    private String name;
    private String email;
    private String phone;
    private String password;
}
