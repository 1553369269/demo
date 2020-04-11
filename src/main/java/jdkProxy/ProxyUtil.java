package jdkProxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Description TODO
 * Author caihaojie
 * @Date 2020-03-27 16:08
 **/
public class ProxyUtil {

    /**
     *  content --->string
     *  .java  io
     * .class
     *
     *
     *
     * .new   反射----》class
     * @return
     */
    public static Object newInstance(Class targetInf,CoustomInvocationHandler h){
        Object proxy = null;
        Method methods[] = targetInf.getDeclaredMethods();
        String line = "\n";
        String tab = "\t";
        String infName = targetInf.getSimpleName();
        String content = "";
        String packageContent = "package com.google;" +line;
        String importContent = "import " + targetInf.getName() + ";" +line
                              +"import jdkProxy.CoustomInvocationHandler;"+line
                              + "import java.lang.Exception;" +line
                              + "import java.lang.reflect.Method;" +line;
        String clazzFirstLineContent = "public class $Proxy implements " + infName + "{" +line;
        String filedContent  =tab+"private CoustomInvocationHandler h;"+line;
        String constructorContent =tab+"public $Proxy (CoustomInvocationHandler h){" +line
                +tab+tab+"this.h =h;"
                +line+tab+"}"+line;
        String methodContent = "";
        for (Method method : methods) {
            String returnTypeName = method.getReturnType().getSimpleName();
            String methodName = method.getName();
            // String.class String.class
            Class args[] = method.getParameterTypes();
            String argsContent = "";
            String paramsContent = "";
            int flag = 0;
            for (Class arg : args) {
                String temp = arg.getSimpleName();
                // String
                // String p0,String p1
                argsContent += temp + "p" + flag + ",";
                paramsContent += "p" + flag + ",";
                flag++;
            }
            if (argsContent.length()>0){
                argsContent=argsContent.substring(0,argsContent.lastIndexOf(",")-1);
                paramsContent=paramsContent.substring(0,paramsContent.lastIndexOf(",")-1);
            }
            methodContent+=tab+"public "+returnTypeName+" "+methodName+"("+argsContent+")throws Exception {"+line
                    +tab+tab+"Method method = Class.forName(\""+targetInf.getName()+"\").getDeclaredMethod(\""+methodName+"\");"+line
                    +tab+tab+"return ("+returnTypeName+")h.invoke(method);"+line;
            methodContent+=tab+"}"+line;
        }
        content=packageContent+importContent+clazzFirstLineContent+filedContent+constructorContent+methodContent+"}";

        File file =new File("d:\\com\\google\\$Proxy.java");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();

            // 编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
            Iterable units = fileManager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
            t.call();
            fileManager.close();

            // 类加载
            URL[] urls = new URL[]{new URL("file:D:\\\\")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("com.google.$Proxy");

            Constructor constructor = clazz.getConstructor(CoustomInvocationHandler.class);
            proxy = constructor.newInstance(h);

        }catch (Exception e){
            e.printStackTrace();
        }

        return proxy;
    }
}
