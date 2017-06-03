package com.homeedu.service;

import org.springframework.stereotype.Service;

import com.homeedu.entity.Parent;

@Service
public class ParentService extends BaseService{
	public boolean addNewParent(Parent newPar){
		return getDaoManager().getParentDAO().addNewParent(newPar);
	}
}
