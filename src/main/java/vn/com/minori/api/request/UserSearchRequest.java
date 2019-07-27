package vn.com.minori.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchRequest extends BaseRequest {
    private String keyword;
}
