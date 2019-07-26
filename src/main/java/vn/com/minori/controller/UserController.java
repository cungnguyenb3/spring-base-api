package vn.com.minori.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import vn.com.minori.api.request.UserDeleteRequest;
import vn.com.minori.api.request.UserGetIdRequest;
import vn.com.minori.api.request.UserInsertRequest;
import vn.com.minori.api.request.UserUpdateRequest;
import vn.com.minori.common.common.CommonConstants;
import vn.com.minori.common.common.CommonFunction;
import vn.com.minori.common.common.ScreenMessageConstants;
import vn.com.minori.common.dto.UserDTO;
import vn.com.minori.common.dto.UserUpdateDTO;
import vn.com.minori.common.output.BaseOutput;
import vn.com.minori.repository.user.UserRepository;
import vn.com.minori.service.user.UserService;
import vn.com.minori.utils.MapperUtil;

@RestController
@RequestMapping(CommonConstants.API_URL_CONST.USER_ROOT)
public class UserController {
    private static Log logger = LogFactory.getLog(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = CommonConstants.API_URL_CONST.GET_ALL, method = RequestMethod.GET)
    public BaseOutput getAll() {
        logger.info("========== UserController.getAll START ==========");
        BaseOutput response = userService.getAll();
        logger.info(CommonFunction.convertToJSONStringResponse(response));
        logger.info("========== UserController.getAll END ==========");
        return response;
    }

    @RequestMapping(value = CommonConstants.API_URL_CONST.GET_ID, method = RequestMethod.POST)
    public BaseOutput getId(@RequestBody UserGetIdRequest request) {
        logger.info("========== UserController.getId START ==========");
        logger.info("request: " + CommonFunction.convertToJSONString(request));
        try {
            BaseOutput response = userService.getId(request.getUserId());
            logger.info("======= UserController.getId ========");
            return response;
        } catch (Exception e){
            logger.trace(ScreenMessageConstants.FAILURE,e);
            return CommonFunction.failureOutput();
        }
    }

    @RequestMapping(value = CommonConstants.API_URL_CONST.INSERT, method = RequestMethod.POST)
    public BaseOutput insert(@Valid @RequestBody UserInsertRequest request) {
        logger.info("========== UserController.insert START ==========");
        logger.info("request: " + CommonFunction.convertToJSONString(request));
        try {
            UserDTO userDTO = MapperUtil.mapper(request, UserDTO.class);
            BaseOutput response = userService.insert(userDTO);
            logger.info(CommonFunction.convertToJSONStringResponse(response));
            logger.info("========== UserController.insert END ==========");
            return response;
        }
        catch (Exception e){
            logger.trace(ScreenMessageConstants.FAILURE, e);
            return CommonFunction.failureOutput();
        }
    }

    @RequestMapping(value = CommonConstants.API_URL_CONST.UPDATE, method = RequestMethod.PUT)
    public BaseOutput update(@RequestBody UserUpdateRequest request){
        logger.info("========== UserController.update START ==========");
        logger.info("request: " + CommonFunction.convertToJSONString(request));
        try {
            UserUpdateDTO userUpdateDTO = MapperUtil.mapper(request, UserUpdateDTO.class);
            BaseOutput response = userService.update(userUpdateDTO);
            logger.info(CommonFunction.convertToJSONStringResponse(response));
            logger.info("========== UserController.update END ==========");
            return response;
        }
        catch (Exception e){
            logger.trace(ScreenMessageConstants.FAILURE, e);
            return CommonFunction.failureOutput();
        }
    }

    @RequestMapping(value = CommonConstants.API_URL_CONST.DELETE, method = RequestMethod.DELETE)
    public BaseOutput delete(@RequestBody UserDeleteRequest request){
        logger.info("========== UserController.delete START ==========");
        logger.info("request: " + CommonFunction.convertToJSONString(request));
        try {
            BaseOutput response = userService.delete(request.getId());
            logger.info("========== UserController.delete END ==========");
            return response;
        }
        catch (Exception e) {
            logger.trace(ScreenMessageConstants.FAILURE, e);
            return CommonFunction.failureOutput();
        }
    }
}