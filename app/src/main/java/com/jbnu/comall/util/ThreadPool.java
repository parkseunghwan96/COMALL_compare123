package com.jbnu.comall.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static ExecutorService internetService = Executors.newCachedThreadPool();
}
