####  spring boot 全局异常处理

全局异常处理的两种方式
1. 服务端
2. 浏览器客户端

服务端：
    可以使用自定义异常类和自定义异常枚举类 
    定义相关全局响应实体用于返回
    通过@RestControllerAdvice来返回json格式数据返回给前端
    通过@ExceptionHandler 统一处理某种异常
    也可以通过@ResponseStatus 指定处理某种状态码
    方式是多种多样的，可以简单处理也可以精确处理，看实际需求和企业规范
    事实上这一套东西基本可以从Spring异常处理的源码可见的。
    Spring真是事实上的行业标准。
    
    
浏览器客户端：
    定义异常模板（html,ftl等），在public.error文件中定义静态文件，
    如果没有异常模板，就是返回spring boot默认的错误提示页面
    对应返回异常时会进入该模板返回该异常页面。
    比如github就自定义异常页面返回。
    （可以试图访问曾经删除过的github页面，得到404的页面）
    这里只是提一下这种方式。

原理其实是这样的：
         一旦系统发生4xx或者5xx错误，
        ErrorPageCustomizer就会生效，给/error发送请求。
        到达BasicErrorController，返回对应ModelAndView。

