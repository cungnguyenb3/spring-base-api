package vn.com.minori.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequest extends BaseRequest {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;
}
