package com.mycompany.config.plan.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.mycompany.config.plan.Plan;
import com.mycompany.config.plan.Responsibility;
import com.mycompany.config.plan.dao.PlanDao;
import com.mycompany.config.plan.service.PlanService;

public class PlanServiceImpl implements PlanService {

    private PlanDao planDao;
    public static final Logger log = Logger.getLogger(PlanServiceImpl.class);

    public PlanDao getPlanDao() {
        return planDao;
    }

    public void setPlanDao(PlanDao planDao) {
        this.planDao = planDao;
    }

    public Plan getPlanByName(String planName) {
        Plan plan = planDao.getPlanByName(planName);
        return plan;
    }

    public List<Plan> getAllPlans() {
        return planDao.getAllPlans();
    }

    public Long addPlan(Plan plan) {
        return planDao.addPlan(plan);
    }

    public void saveOrUpdatePlan(Plan plan) {
        planDao.saveOrUpdatePlan(plan);
    }

    public Plan getPlanById(String planId) {
        return planDao.getPlanById(planId);
    }

    public List<Responsibility> getResponsiblityById(String responsiblityId) {
        return planDao.getResponsiblityById(responsiblityId);
    }
}
