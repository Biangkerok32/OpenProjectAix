package io.kangris.parallax;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.*;
import com.google.appinventor.components.runtime.*;

@DesignerComponent(category = ComponentCategory.EXTENSION, 
                   description = "Simple Parallax<br>by kangris", 
                   iconName = "images/extension.png", 
                   nonVisible = true, 
                   version = 1)
@SimpleObject(external = true)
public class SimpleParallax extends AndroidNonvisibleComponent implements Component{
    private ComponentContainer container;
    private Activity activity;
    private Context context;
    private View view;
    private CustomScrollView mBgScrollView;
    private CustomScrollView mContentScrollView;
    private int y;

    public SimpleParallax(ComponentContainer container) {
        super(container.$form());
    	  activity = container.$context();
    	  context = (Context) activity;
    }

    public View getView() {
        return this.view;
    }
    
    @SimpleFunction
    public void InitView(AndroidViewComponent backgroundArrangement, AndroidViewComponent contentArrangement) {
        CustomScrollView mBgScrollView = (CustomScrollView) backgroundArrangement.getView();
        CustomScrollView mContentScrollView = (CustomScrollView) contentArrangement.getView();
        mContentScrollView.setOnScrollParallexListener(new CustomScrollView.OnScrollParallexListener() {
            public void onScrollParallexListener(CustomScrollView scrollview, int y) {
              // when the content scrollview will scroll by say 100px, 
              // the background scrollview will scroll by 50px. It will 
              // look like a parallax effect where the background is 
              // scrolling with a different speed then the content scrollview.
              // mBgScrollView.scrollTo(0, (int)(y / 2f));
                OnScrollChanged(y);
            }
         });
    }
  
   
    @SimpleFunction
    public void ScrollToParallex(int y){
        mBgScrollView.scrollTo(0, (int)(y / 2f));
    }

    @SimpleEvent
    public void OnScrollChanged(int y) {
        EventDispatcher.dispatchEvent(this, "OnScrollChanged", y);
    }
    

}
