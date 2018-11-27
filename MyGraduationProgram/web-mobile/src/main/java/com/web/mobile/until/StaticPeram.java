package com.web.mobile.until;

public class StaticPeram {

    /**
     * 手机验证部分配置
     */
    /**
     * 设置超时时间-可自行调整
     */
    final static String DEFAULT_CONNECT_TIMEOUT = "sun.net.client.DEFAULT_CONNECT_TIMEOUT";

    final static String DEFAULT_READ_TIMEOUT = "sun.net.client.DEFAULT_READ_TIMEOUT";

    final static String TIMEOUT = "10000";

    /**
     * 初始化ascClient需要的几个参数
     * 短信API产品名称（短信产品名固定，无需修改）
     */
    final static String PRODUCT = "Dysmsapi";

    // 短信API产品域名（接口地址固定，无需修改）
    final static String DOMAIN = "dysmsapi.aliyuncs.com";

    /**
     * 替换成你的AK (产品密)
     * 你的accessKeyId,填你自己的 上文配置所    得  自行配置
     */
    final static String ACCESS_KEY_ID = "LTAIxxgebxDvvNUm";

    /**
     * 你的accessKeySecret,填你自己的 上文配置所得 自行配置
     */
    final static String ACCESS_KEY_SECRET = "HJSpZxPUUvnj1YiuetnzCnpSThhsxs";

    /**
     * 必填:短信签名-可在短信控制台中找到
     * 阿里云配置你自己的短信签名填入
     */
    final static String SIGN_NAME = "骑士人才系统";

    /**
     * 必填:短信模板-可在短信控制台中找到
     * 阿里云配置你自己的短信模板填入
     */
    final static String TEMPLATE_CODE = "SMS_151835412";

}
