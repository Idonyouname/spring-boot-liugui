package com.liugui.springbootdevtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootDevtoolsApplication {
    /**
     * 实现无需手动重启项目，提高开发效率
     * 步骤：
     *  1.引入devtools依赖，并设置optional = true
     *  2.maven 中   设置fork和addResources 为true
     *  <configuration>
     *                     <fork>true</fork>
     *                     <addResources>true</addResources>
     *                 </configuration>
     *  3.配置中添加指定目录进行自动重启
     *  4.如果使用的是idea工具 则还需要两项设置
     *      a. ctrl+shift+a 调出设置 Registry 勾选 compiler....runing
     *      b. setting compiler  勾选 build project auto....
     */
    @GetMapping("/helloDevtools")
    public String helloDevtools(){
        return "热加载完成";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDevtoolsApplication.class, args);
    }


}
