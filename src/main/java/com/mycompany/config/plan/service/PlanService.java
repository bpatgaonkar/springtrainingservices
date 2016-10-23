package com.mycompany.config.plan.service;

import java.util.List;

import com.mycompany.config.plan.Plan;
import com.mycompany.config.plan.Responsibility;

public interface PlanService {
	public Plan getPlanByName(String planName);
	public Plan getPlanById(String planId);
	public List<Plan> getAllPlans();
	public Long addPlan(Plan plan);
	public void saveOrUpdatePlan(Plan plan);
        public List<Responsibility> getResponsiblityById(String responsiblityId);
}
