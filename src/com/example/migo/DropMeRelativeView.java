package com.example.migo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.RelativeLayout;

public class DropMeRelativeView extends RelativeLayout{
	
	private String clicked_drop ;
	
	
		public String getClicked(){
			return clicked_drop;
		}
		
		public void setClicked(){
			System.out.println("clicked from setclick type is"+this.clicked_drop);
			if(clicked_drop.equals("false")){	
				
				inflate(getContext(), R.layout.drop_relative_view_pressed, this);
				
				this.clicked_drop = "true";
			}else {
				
				inflate(getContext(), R.layout.drop_relative_view_unpressed, this);
				this.clicked_drop="false";
			}
		}
				
		
		

		public DropMeRelativeView(Context context) {
			super(context);
			
		}
		
		public DropMeRelativeView(Context context, AttributeSet attrs) {
			super(context, attrs);
			initViews(context, attrs);
		}

		public DropMeRelativeView(Context context, AttributeSet attrs, int defStyle) {
			this(context, attrs);
			initViews(context, attrs);
		}
		
		public void initViews(Context context, AttributeSet attrs) {
			TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
					R.styleable.dropMeRelative, 0, 0);
			this.setWillNotDraw(false);
			
			try {
				clicked_drop = a.getString(R.styleable.dropMeRelative_clicked_drop);
		
			System.out.println("clicked type is"+clicked_drop);
			if(clicked_drop.equals("true")){
				inflate(getContext(), R.layout.drop_relative_view_pressed, this);
			}else 
				inflate(getContext(), R.layout.drop_relative_view_unpressed, this);
			}finally{
				a.recycle();
			}
			
			
			
		}
		
		@Override
	    protected void onDraw(Canvas canvas) {
	    	super.onDraw(canvas);
//	    	initViews(this.getContext(), )
	    	
	    	
		
		}
		
		

		
		
		
		

	

}
