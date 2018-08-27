package com.starstudio.diffutildemo;

import android.support.v7.util.DiffUtil;

import java.util.List;

public class DiffCalback extends DiffUtil.Callback {

    private List<UserBean> oldUserBeans;
    private List<UserBean> newUserBeans;

    public DiffCalback(List<UserBean> oldUserBeans,List<UserBean> newUserBeans){
        this.oldUserBeans= oldUserBeans;
        this.newUserBeans= newUserBeans;
    }

    @Override
    public int getOldListSize() {
        return oldUserBeans==null?0:oldUserBeans.size();
    }

    @Override
    public int getNewListSize() {
        return newUserBeans==null?0:newUserBeans.size();

    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
//        if(true)return false;
        UserBean userBean = oldUserBeans.get(oldItemPosition);
        UserBean userBean1 = newUserBeans.get(newItemPosition);
        return  userBean.getName().equalsIgnoreCase(userBean1.getName());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        UserBean userBean = oldUserBeans.get(oldItemPosition);
        UserBean userBean1 = newUserBeans.get(newItemPosition);
        return  userBean.toString().equalsIgnoreCase(userBean1.toString());
    }

    //tell what filed changed
//    @Nullable
//    @Override
//    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
//
//        Bundle payload = new Bundle();
//        payload.putString("name","123");
//
//        return payload;//super.getChangePayload(oldItemPosition, newItemPosition);
//
//
//
//    }
}
