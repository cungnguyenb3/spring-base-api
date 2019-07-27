package vn.com.minori.service.user;
import java.util.List;

import vn.com.minori.common.dto.UserDTO;
import vn.com.minori.common.dto.UserUpdateDTO;
import vn.com.minori.common.output.BaseOutput;
import vn.com.minori.domain.User;

public interface UserService {
    BaseOutput getAll();
    BaseOutput getId(String userId);
    BaseOutput insert(UserDTO userDTO);
    BaseOutput update(UserUpdateDTO userUpdateDTO);
    BaseOutput delete(String userId);
//    BaseOutput search(String keyword);
}
