package org.askerov.dynamicgrid;

import android.util.Log;
import android.view.DragEvent;
import android.view.View;

public class DragDropController implements View.OnDragListener {

	@Override
	public boolean onDrag(View v, DragEvent event) {

		switch (event.getAction()) {

			case DragEvent.ACTION_DRAG_STARTED:
				Log.d("DragDropController", "started ");
				break;

			case DragEvent.ACTION_DRAG_LOCATION:

				int eventX = (int) event.getX();
				int eventY = (int) event.getY();

				Log.d("DragDropController", " " + eventX);
				Log.d("DragDropController", " " + eventY);

//				if (mActivePointerId == INVALID_ID) {
//					break;
//				}
//
//				int pointerIndex = event.findPointerIndex(mActivePointerId);
//				int pointerIndex = event.getAction(mActivePointerId);
//
//				mLastEventY = (int) event.getY(pointerIndex);
//				mLastEventX = (int) event.getX(pointerIndex);
//				int deltaY = mLastEventY - mDownY;
//				int deltaX = mLastEventX - mDownX;
//
//				if (mCellIsMoving) {
//					mHoverCellCurrentBounds.offsetTo(mHoverCellOriginalBounds.left + deltaX + mTotalOffsetX, mHoverCellOriginalBounds.top + deltaY + mTotalOffsetY);
//					mHoverCell.setBounds(mHoverCellCurrentBounds);
//					invalidate();
//					handleCellSwitch();
//					mIsMobileScrolling = false;
//					handleMobileCellScroll();
//					return false;
//				}
				break;

			case DragEvent.ACTION_DROP:
				Log.d("DragDropController", "drop ");
				break;

			case DragEvent.ACTION_DRAG_ENDED:
				Log.d("DragDropController", "Ended");
				break;

			case DragEvent.ACTION_DRAG_ENTERED:
				Log.d("DragDropController", "Entered ");
				break;

			case DragEvent.ACTION_DRAG_EXITED:
				Log.d("DragDropController", "Exited ");
				break;
		}

		return true;
	}
}
