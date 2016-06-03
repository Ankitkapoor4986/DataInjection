package com.bb.injection.Service;

import com.bb.injection.dao.TBBBuddyGroupDao;
import com.bb.injection.model.TBBBuddyGroup;

import java.util.List;

/**
 * Created by ankit on 1/6/16.
 */
public class TBBBuddyGroupService {

    private static TBBBuddyGroupService tbbBuddyGroupService =new TBBBuddyGroupService();
    private TBBBuddyGroupService(){}
    public static TBBBuddyGroupService getInstance(){
        return tbbBuddyGroupService;
    }
    private TBBBuddyGroupDao tbbBuddyGroupDao =TBBBuddyGroupDao.getInstance();

    public void insert(List<TBBBuddyGroup> tbbBuddyGroups){
        tbbBuddyGroupDao.insert(tbbBuddyGroups);
    }

    public void insert(TBBBuddyGroup tbbBuddyGroup){
        tbbBuddyGroupDao.insert(tbbBuddyGroup);
    }
}
