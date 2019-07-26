package vn.com.minori.api.request;

import lombok.Getter;
import lombok.Setter;
import vn.com.minori.common.common.DisplayNameConstant;
import vn.com.minori.validate.annotation.Required;

@Getter
@Setter
public class UserGetIdRequest extends BaseRequest{
    @Required(displayFieldName = DisplayNameConstant.USER.GET_ID.USER_ID)
    private String userId;
}
