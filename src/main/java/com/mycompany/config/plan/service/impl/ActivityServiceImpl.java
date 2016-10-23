/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.config.plan.service.impl;

import com.mycompany.config.plan.Activity;
import com.mycompany.config.plan.ActivityType;
import com.mycompany.config.plan.dao.ActivityDao;
import com.mycompany.config.plan.service.ActivityService;

import java.util.List;

/**
 *
 * @author Patgaonkar
 */
public class ActivityServiceImpl implements ActivityService {

    private ActivityDao activityDao;

    public ActivityDao getActivityDao() {
        return activityDao;
    }

    public void setActivityDao(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    public List<Activity> getActivities() {
        return activityDao.getActivities();
    }

    public Activity getActivityForTypeCode(String typeCode) {
        return activityDao.getActivityForTypeCode(typeCode);
    }
    public List<Activity> getActivitiesByPlanResponsibility(String planid,String respid){
       return activityDao.getActivitiesByPlanResponsibility(planid, respid);
    }
}
