package com.fantastic3.thebeautiful.fragments;


import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2015/11/10 10:25
 * Created by Author boobooL
 * 邮箱：boobooMX@163.com
 */

/**
 * Fragment的工厂
 */
public class FragmentFactory {

    public static Map<Integer,BaseFragment> mFragments=new HashMap<>();
    public static  BaseFragment createFragment(int position){

        BaseFragment fragment = null;
        fragment=mFragments.get(position);//在集合中取出来fragment
        if(fragment==null){//如果fragment为空，进行创建
            if(position==0){
                fragment=new VideoNewestFragment();
            }else if(position==1){
                fragment= new VideoHotFragment();
            }else if(position==2){
                fragment= new VideoCareFragment();
            }
            if(fragment!=null){//如果fragment不为空，添加到集合中
                mFragments.put(position, fragment);
            }
        }
        return  fragment;
    }

    public static Map<Integer,BaseFragment> mFragments2=new HashMap<>();
    public static  BaseFragment createFragment2(int position){
        BaseFragment fragment = null;
        fragment=mFragments2.get(position);//在集合中取出来fragment
        if(fragment==null){//如果fragment为空，进行创建
            if(position==0){
                fragment=new DiscoverNewestFragment();
            }else if(position==1){
                fragment= new DiscoverHotFragment();
            }else if(position==2){
                fragment= new DiscoverConcernedFragment();
            }
            if(fragment!=null){//如果fragment不为空，添加到集合中
                mFragments2.put(position, fragment);
            }
        }
        return  fragment;
    }






}
