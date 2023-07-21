package  com.example.mybatisplus.validator;

import  com.example.mybatisplus.eums.CommonResultCodeEnums;
import  com.example.mybatisplus.exceptions.IllegalParameterException;
import  com.example.mybatisplus.model.UserModel;

public class UserControllerValidator {
    public static void updateValidator(UserModel userModel) {
        if (null == userModel.getId() || userModel.getId() <= 0) {
            throw new IllegalParameterException(CommonResultCodeEnums.VALIDATION_EXCEPTION.getCode(), CommonResultCodeEnums.VALIDATION_EXCEPTION.getDescribe());
        }
    }
}
