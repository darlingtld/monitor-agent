package com.emc.service;

import com.emc.pojo.send.MonitorInfo;

public interface IMonitorService {

    MonitorInfo getMonitorInfo() throws Exception;

}