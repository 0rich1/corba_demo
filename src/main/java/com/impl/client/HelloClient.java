package com.impl.client;

import com.Hello;
import com.HelloHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import java.util.Properties;

public class HelloClient {

    public static void main(String[] args) throws Exception{
        Properties props = new Properties();
        // 生成一个ORB，并初始化，这个和Server端一样
        props .put("org.omg.CORBA.ORBInitialPort", "1050");
        props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
        ORB orb = ORB.init(args, props);
        // 获得根命名上下文  NameService
        org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
        // 用NamingContextExt代替NamingContext.
        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

        // 通过名称获取服务器端的对象引用
        String name = "Hello";
        Hello hello = HelloHelper.narrow(ncRef.resolve_str(name));

        //调用远程对象
        String retVal = hello.sayHello();
        System.out.println(retVal);
    }
}
