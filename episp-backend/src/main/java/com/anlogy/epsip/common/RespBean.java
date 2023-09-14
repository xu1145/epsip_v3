package com.anlogy.epsip.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {

    private static final Integer SUCCESS_CODE = 200;
    private static final Integer ERROR_CODE = 500;

    private Integer code;
    private String message;
    private Object object;

    /**
     * 成功返回结果
     * @param message
     * @return
     */
    public static RespBean success(String message){
        return new RespBean(SUCCESS_CODE, message, null);
    }

    /**
     * 成功返回结果
     * @param message
     * @param object
     * @return
     */
    public static RespBean success(String message, Object object){
        return new RespBean(SUCCESS_CODE, message,object);
    }

    /**
     * 失败返回结果
     * @param message
     * @return
     */
    public static RespBean error(String message){
        return new RespBean(ERROR_CODE, message, null);
    }

    /**
     * 失败返回结果
     * @param message
     * @param object
     * @return
     */
    public static RespBean error(String message, Object object){
        return new RespBean(ERROR_CODE, message, object);
    }

    /**
     * 查询成功返回结果
     * @return
     */
    public static RespBean successGet(){
        return new RespBean(SUCCESS_CODE,"查询成功", null);
    }

    public static RespBean successGet(Object object){
        return new RespBean(SUCCESS_CODE,"查询成功", object);
    }

    /**
     * 查询失败返回结果
     * @return
     */
    public static RespBean errorGet(){
        return new RespBean(ERROR_CODE,"查询失败", null);
    }

    public static RespBean errorGet(Object object){
        return new RespBean(ERROR_CODE,"查询失败", object);
    }

    /**
     * 添加成功返回结果
     * @return
     */
    public static RespBean successAdd(){
        return new RespBean(SUCCESS_CODE,"添加成功", null);
    }

    public static RespBean successAdd(Object object){
        return new RespBean(SUCCESS_CODE,"添加成功", object);
    }

    /**
     * 添加失败返回结果
     * @return
     */
    public static RespBean errorAdd(){
        return new RespBean(ERROR_CODE,"添加失败", null);
    }

    public static RespBean errorAdd(Object object){
        return new RespBean(ERROR_CODE,"添加失败", object);
    }

    /**
     * 删除成功返回结果
     * @return
     */
    public static RespBean successDel(){
        return new RespBean(SUCCESS_CODE,"删除成功", null);
    }

    public static RespBean successDel(Object object){
        return new RespBean(SUCCESS_CODE,"删除成功", object);
    }

    /**
     * 删除失败返回结果
     * @return
     */
    public static RespBean errorDel(){
        return new RespBean(ERROR_CODE,"删除失败", null);
    }

    public static RespBean errorDel(Object object){
        return new RespBean(ERROR_CODE,"删除失败", object);
    }


    /**
     * 更新成功返回结果
     * @return
     */
    public static RespBean successUpdate(){
        return new RespBean(SUCCESS_CODE,"更新成功", null);
    }

    public static RespBean successUpdate(Object object){
        return new RespBean(SUCCESS_CODE,"更新成功", object);
    }

    /**
     * 更新失败返回结果
     * @return
     */
    public static RespBean errorUpdate(){
        return new RespBean(ERROR_CODE,"更新失败", null);
    }

    public static RespBean errorUpdate(Object object){
        return new RespBean(ERROR_CODE,"更新失败", object);
    }

}
