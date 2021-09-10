package com.zhaluobox.crazyjava.第18章类加载机制与反射.chapter18_02_类加载器;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

public class CustomClassLoader extends ClassLoader {

    protected CustomClassLoader(ClassLoader parent) {
        super(parent);
    }

    protected CustomClassLoader() {
        super();
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    @Override
    protected Object getClassLoadingLock(String className) {
        return super.getClassLoadingLock(className);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    @Override
    protected URL findResource(String name) {
        return super.findResource(name);
    }

    @Override
    protected Enumeration<URL> findResources(String name) throws IOException {
        return super.findResources(name);
    }

    @Override
    protected Package definePackage(String name, String specTitle, String specVersion, String specVendor, String implTitle, String implVersion,
                                    String implVendor, URL sealBase) throws IllegalArgumentException {
        return super.definePackage(name, specTitle, specVersion, specVendor, implTitle, implVersion, implVendor, sealBase);
    }

    @Override
    protected Package getPackage(String name) {
        return super.getPackage(name);
    }

    @Override
    protected Package[] getPackages() {
        return super.getPackages();
    }

    @Override
    protected String findLibrary(String libname) {
        return super.findLibrary(libname);
    }
}
