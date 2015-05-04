package com.example.migo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ContactRelativeView extends RelativeLayout{
	
	private String clicked ;
	
	
		public String getClicked(){
			return clicked;
		}
		
		public void setClicked(){
		
			
			
			
				System.out.println("clicked from setclick type is"+this.clicked);
				if(clicked.equals("false")){	
					
					inflate(getContext(), R.layout.contact_relative_pressed, this);
					this.clicked = "true";
				}else {
					
					inflate(getContext(), R.layout.contact_relative_view, this);
					this.clicked="false";
				}
					
				
				
			
		}
				
		
		
		
		
		public ContactRelativeView(Context context) {
			super(context);
			//initViews(context, null);
			
			LayoutInflater.from(context).inflate(R.layout.contact_relative_view, this);
		}
		
		public ContactRelativeView(Context context, AttributeSet attrs) {
			super(context, attrs);
			initViews(context, attrs);
		}

		public ContactRelativeView(Context context, AttributeSet attrs, int defStyle) {
			this(context, attrs);
			initViews(context, attrs);
		}
		
		private void initViews(Context context, AttributeSet attrs) {
			TypedArray a = context.getTheme().obtainStyledAttributes(attrs,
					R.styleable.contactRelative, 0, 0);
			
			
			try {
			clicked = a.getString(R.styleable.contactRelative_clicked);
		
			System.out.println("clicked type is"+clicked);
			if(clicked.equals("true")){
				inflate(getContext(), R.layout.contact_relative_pressed, this);
			}else 
				inflate(getContext(), R.layout.contact_relative_view, this);
			}finally{
				a.recycle();
			}
			
			
			
		}
		
		
		
		@Override
	    protected void onDraw(Canvas canvas) {
	    	super.onDraw(canvas);
	    	

	    	
	    	
		
		}
		
		

		
		
		
		

	

}
