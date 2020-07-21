package io.kangris.parallex;
    
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView {

	public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public CustomScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CustomScrollView(Context context) {
		super(context);
	}

	OnScrollParallexListener mListener;

	/**
	 * 
	 */
	public void setOnScrollParallexListener(OnScrollParallexListener listener) {
		this.mListener = listener;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View#onScrollChanged(int, int, int, int)
	 */
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {

		super.onScrollChanged(l, t, oldl, oldt);

		if (mListener != null)
			mListener.onScrollParallexListener(this, t);
	}

	public interface OnScrollParallexListener {
		void onScrollParallexListener(CustomScrollView scrollview, int value);
	}


}
