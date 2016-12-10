package com.activiti.utils;


import com.activiti.bean.base.Sidebar;
import com.activiti.bean.base.SidebarItem;
import com.google.common.collect.Lists;

import java.util.List;

public class SidebarUtil {
    public static Sidebar getSideBar() {
        Sidebar sidebar = new Sidebar();

        List<SidebarItem> items = Lists.newArrayList();
        items.add(new SidebarItem("��ҳ", "/", "fa-crosshairs"));

        SidebarItem tableManager = new SidebarItem("���", "/table", "fa-info");
        tableManager.addChild(new SidebarItem("���ݱ��", "/table/dataTable", "fa-mars-stroke-h"));
        tableManager.addChild(new SidebarItem("JP���", "/table/jpTable", "fa-mars-stroke-h"));
        items.add(tableManager);

        SidebarItem formManager = new SidebarItem("��", "/form", "fa-tasks");
        formManager.addChild(new SidebarItem("������", "/form/baseForm", "fa-mars-stroke-h"));
        formManager.addChild(new SidebarItem("У���", "/form/validatorForm", "fa-mars-stroke-h"));
        formManager.addChild(new SidebarItem("�ļ��ϴ�", "/form/validatorForm", "fa-mars-stroke-h"));
        formManager.addChild(new SidebarItem("�༭��", "/form/validatorForm", "fa-mars-stroke-h"));
        formManager.addChild(new SidebarItem("����ѡ��", "/form/validatorForm", "fa-mars-stroke-h"));
        items.add(formManager);

        SidebarItem activitiManager = new SidebarItem("������", "/act", "fa-sitemap");
        activitiManager.addChild(new SidebarItem("���̶���", "/act/process/list", "fa-mars-stroke-h"));
        activitiManager.addChild(new SidebarItem("�������", "/act/task/list", "fa-mars-stroke-h"));
        activitiManager.addChild(new SidebarItem("��ٵ�", "/act/leaveBill/list", "fa-mars-stroke-h"));
        items.add(activitiManager);

/*

        SidebarItem messageManager = new SidebarItem("���Ź���", "/sms", "fa-envelope-o");
        items.add(messageManager);

        SidebarItem demandManager = new SidebarItem("�������", "/demand", "fa-ship");
        demandManager.addChild(new SidebarItem("�����б�","/demand/list","fa-paw"));
        items.add(demandManager);

        SidebarItem dataStatisticManager = new SidebarItem("����ͳ��", "/data", "fa-bar-chart");
        items.add(dataStatisticManager);

        SidebarItem settingsManager = new SidebarItem("���ù���", "/settings", "fa-cogs");
        items.add(settingsManager);*/

        sidebar.setItems(items);

        return sidebar;
    }

}
