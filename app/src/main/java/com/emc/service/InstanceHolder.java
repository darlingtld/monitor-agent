package com.emc.service;

import com.emc.service.impl.WindowsMonitorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tangl9 on 2015-10-29.
 */
@Component
public class InstanceHolder {

    @Autowired
    private WindowsMonitorServiceImpl windowsMonitorService;

    private static InstanceHolder INSTANCE;

    public InstanceHolder() {
        INSTANCE=this;
    }

    public static WindowsMonitorServiceImpl getWindowsMonitorService() {
        return INSTANCE.windowsMonitorService;
    }
}
