package com.emc.service;

import com.emc.pojo.send.MonitorInfo;
import com.emc.service.impl.WindowsMonitorServiceImpl;


/**
 * Created by tangl9 on 2015-10-29.
 */
public class MonitorTest {

    public static void main(String[] args) throws Exception {
        IMonitorService service = new WindowsMonitorServiceImpl();
        MonitorInfo monitorInfo = service.getMonitorInfo();
        System.out.println("cpu ratio=" + monitorInfo.getCpuRatio());
        System.out.println("available memory=" + monitorInfo.getTotalMemory());
        System.out.println("free memory=" + monitorInfo.getFreeMemory());
        System.out.println("max available memory=" + monitorInfo.getMaxMemory());
        System.out.println("os=" + monitorInfo.getOsName());
        System.out.println("total physical memory=" + monitorInfo.getTotalMemorySize() + "kb");
        System.out.println("free physical memory=" + monitorInfo.getFreeMemory() + "kb");
        System.out.println("used physical memory=" + monitorInfo.getUsedMemory() + "kb");
        System.out.println("thread count=" + monitorInfo.getTotalThread() + "kb");
    }
}
