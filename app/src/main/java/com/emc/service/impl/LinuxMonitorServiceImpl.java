package com.emc.service.impl;

import com.emc.pojo.send.MonitorInfo;
import com.emc.service.IMonitorService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by tangl9 on 2015-10-29.
 */
@Service
public class LinuxMonitorServiceImpl implements IMonitorService {

    public double getCpuUsage() throws Exception {
        double cpuUsed = 0;
        Runtime rt = Runtime.getRuntime();
        Process p = rt.exec("top -b -n 1");
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String str;
            String[] strArray;
            while ((str = in.readLine()) != null) {
                int m = 0;
                if (str.contains(" R ") && !str.contains("top")) {
                    strArray = str.split("\\s+");
                    for (String tmp : strArray) {
                        if (tmp.trim().length() == 0)
                            continue;
                        if (++m == 9) {
                            cpuUsed += Double.parseDouble(tmp);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return cpuUsed;
    }

    public static void main(String[] args) throws Exception {
        LinuxMonitorServiceImpl cpu = new LinuxMonitorServiceImpl();
        System.out.println("cpu used:" + cpu.getCpuUsage() + "%");
    }

    @Override
    public MonitorInfo getMonitorInfo() throws Exception {
        double cpuRatio = getCpuUsage();

        MonitorInfo infoBean = new MonitorInfo();
//        infoBean.setFreeMemory(freeMemory);
//        infoBean.setFreePhysicalMemorySize(freePhysicalMemorySize);
//        infoBean.setMaxMemory(maxMemory);
//        infoBean.setOsName(osName);
//        infoBean.setTotalMemory(totalMemory);
//        infoBean.setTotalMemorySize(totalMemorySize);
//        infoBean.setTotalThread(totalThread);
//        infoBean.setUsedMemory(usedMemory);
        infoBean.setCpuRatio(cpuRatio);
        return infoBean;
    }
}
