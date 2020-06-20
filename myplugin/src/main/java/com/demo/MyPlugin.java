package com.demo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wuting
 * @date 2019/03/14
 */
@Mojo(name = "myPlugin", defaultPhase = LifecyclePhase.PACKAGE)
public class MyPlugin extends AbstractMojo {

    @Parameter
    private String msg;

    @Parameter
    private List<String> listParam;

    //通过自定义插件的方式传参数:mvn install -Dargs=123
    @Parameter(property = "args")
    private String args;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("Hello,my first maven plugin!!!");
        System.out.printf("msg:%s%n", msg);
        System.out.printf("listParam:%s%n", listParam);
        System.out.printf("args:%s%n", args);
    }

}
