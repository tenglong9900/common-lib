package com.arta.lib.adapter;

import java.util.List;

import com.arta.lib.widget.listener.OnEntityViewPagerClickListener;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/**
 * 基于ViewPager的泛型实体数据适配器
 * @author 王春龙
 *
 * @param <T>
 */
public class BaseEntityPageAdapter<T> extends PagerAdapter implements OnClickListener{
	
	protected List<T> entityList;
	
	protected Context context;
	
	protected BaseAdapterEntityViewManage<T> adapterItemManage;
	
	private OnEntityViewPagerClickListener<T> onEntityViewPagerClickListener;
	
	/**
	 * 
	 * @param context
	 * @param entityList 数据实体列表
	 * @param adapterItemManage 生成子视图的管理器
	 */
	public BaseEntityPageAdapter(Context context, List<T> entityList, BaseAdapterEntityViewManage<T> adapterItemManage){
		this.context = context;
		this.entityList = entityList;
		this.adapterItemManage = adapterItemManage;
	}
	
	public void setOnEntityViewPagerClickListener(OnEntityViewPagerClickListener<T> onEntityViewPagerClickListener){
		this.onEntityViewPagerClickListener = onEntityViewPagerClickListener;
	}
	
	@Override
	public int getCount() {
		return entityList.size();
	}

	public Object getItem(int position){
		return entityList.get(position);
	}
	
	@Override
	public Object instantiateItem(final ViewGroup container, final int position) {
		T entity = entityList.get(position);
		View view = adapterItemManage.getAdapterItemView(context, entity, position);
		container.addView(view);
		view = adapterItemManage.updateAdapterItemView(context, view, entity, position);
		view.setTag(AdapterConstant.TAG_KEY, new ViewHolder(container, entity, position));
		view.setClickable(true);
		view.setOnClickListener(this);
		return view;
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {			
		View view = (View) object;
		((ViewPager) container).removeView(view);
	}

	@Override
	public void onClick(View v) {
		@SuppressWarnings("unchecked")
		ViewHolder viewHolder = (ViewHolder) v.getTag(AdapterConstant.TAG_KEY);
		if(onEntityViewPagerClickListener != null){
			onEntityViewPagerClickListener.onEntityViewClick((ViewPager)viewHolder.viewGroup, v, viewHolder.entity, viewHolder.position);
		}
	}
	
	private class ViewHolder{
		ViewGroup viewGroup;
		T entity;
		int position;
		public ViewHolder(ViewGroup viewGroup, T entity, int position){
			this.viewGroup = viewGroup;
			this.entity = entity;
			this.position = position;
		}
	}
}
