import axios from "axios";
import { Message } from "element-ui"; // 在js文件中使用message必须导入这个依赖
import router from "../router";

// 成功、失败信息，通过提示框来显示

// 在组件中可以直接使用this.$message使用提示框，但是在js文件中不可以这样使用

// axios中的interceptors是拦截器的意思，拦截器有两种，分别是response和request

// 响应拦截器
axios.interceptors.response.use(success=>{
    // success 表示成功调用该接口，但是可能后端接口不允许你做此操作

    if(success.status && success.status == 200){
        // 业务逻辑错误
        if(success.data.code == 500 || success.data.code == 401 || success.data.code == 403){
            Message.error({message:success.data.message});
            return;
        }
        // 判断有没有信息，有信息的就是成功的
        if(success.data.message){
            Message.success({message:success.data.message});
        }
    }

    // 返回传递对象信息
    return success.data;

}, error=>{
    // error 表示直接调用接口失败
    if(error.response.code == 504 || error.response.code == 404){
        Message.error({message:'服务器出现问题'});
    }else if(error.response.code == 403){
        Message.error({message:'权限不足，请联系管理员'});
    }else if(error.response.code == 401){
        Message.error({message:'尚未登录，请登录！'});
        router.replace('/home1');
    }else{
        if(error.response.data.message){
            Message.error({message:error.response.data.message});
        }else{
            Message.error({message:'未知错误！'});
        }
    }

    return;

});

// 有一些项目要求在url前面加一些前置路径
let base = ''

// 传送json格式的post请求
export const postRequest = (url,params)=>{
    return axios({
        method: 'post',
        url: `${base}${url}`,
        data: params
    })
}

// 传送json格式的get请求
export const getRequest = (url,params)=>{
    return axios({
        method: 'get',
        url: `${base}${url}`,
        data: params
    })
}

// 传送json格式的put请求
export const putRequest = (url,params)=>{
    return axios({
        method: 'put',
        url: `${base}${url}`,
        data: params
    })
}

// 传送json格式的delete请求
export const deleteRequest = (url,params)=>{
    return axios({
        method: 'delete',
        url: `${base}${url}`,
        data: params
    })
}

