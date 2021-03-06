package com.arta.lib.widget.tabbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
/**
 * tabBar 按钮，基于{@link ImageView}实现，过滤按钮被按压后的状态
 * @author 王春龙
 *
 */
public class TabButton extends ImageView{

	public TabButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	public TabButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public TabButton(Context context) {
		super(context);
		init();
	}
	
	private void init(){
		this.setClickable(true);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
//		Drawable drawable = this.getBackground();
//		if(drawable == null){
//			drawable = this.getDrawable();
//		}
//		if(drawable == null){
//			return super.onTouchEvent(event);
//		}
//		
//		BitmapDrawable bitmapDrawbale = null;
//		if(drawable instanceof BitmapDrawable){
//			bitmapDrawbale = (BitmapDrawable)drawable;
//		}
//		else if(drawable instanceof StateListDrawable){
//			bitmapDrawbale = (BitmapDrawable) ((StateListDrawable)drawable).getCurrent();
//		}
//		
//		if(bitmapDrawbale != null){
//			if (isInTouchArea((int)event.getX() , (int)event.getY() , bitmapDrawbale.getBitmap())||
//        event.getAction() != MotionEvent.ACTION_DOWN){
//			        return super.onTouchEvent(event);
//		    }
//			else{
//		        return false;
//		    }
//		}
//		else{
//			return false;
//		}
		
		if(this.isSelected()) return true;
		return super.onTouchEvent(event);
	}

//	private boolean isInTouchArea(int x, int y , Bitmap bitmap) {
//		if(x < 0 || x >= bitmap.getWidth() || y < 0 || y >= bitmap.getHeight()) return false;
//		
//		int pixel = bitmap.getPixel(x, y);  
//        
//        if (((pixel >> 24) & 0xff) > 0)  
//        {       
//            return true;  
//        }  
//        return false;
//	}

	/**
	 * 选中选项卡
	 * @param select
	 */
	public void setTabToggle(boolean select){
		this.setSelected(select);
		this.invalidate();
	}
}
