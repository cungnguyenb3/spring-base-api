package vn.com.pn.api.request;

import lombok.Getter;
import lombok.Setter;
import vn.com.pn.common.common.DisplayNameConstant;
import vn.com.pn.validate.annotation.Required;

@Getter
@Setter
public class UserGetIdRequest extends BaseRequest{
    @Required(displayFieldName = DisplayNameConstant.USER.GET_ID.USER_ID)
    private String userId;
}
